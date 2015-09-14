package simulace;

import simulace.cas.udajCasu;
import java.util.*;

public class udalost {
	
	public cas.udajCasu pocatekUdalosti;
	public cas.udajCasu konecUdalosti;
	public typUdalosti typ;	
	public String idTramvaje;
	public String lokace;
	public tramvaj tram;
	Random generator;
	
	

	public cas.udajCasu getPocatekUdalosti() {
		return pocatekUdalosti;
	}

	public void setPocatekUdalosti(cas.udajCasu pocatekUdalosti) {
		this.pocatekUdalosti = pocatekUdalosti;
	}

	public cas.udajCasu getKonecUdalosti() {
		return konecUdalosti;
	}

	public void setKonecUdalosti(cas.udajCasu konecUdalosti) {
		this.konecUdalosti = konecUdalosti;
	}

	public typUdalosti getTyp() {
		return typ;
	}

	public void setTyp(typUdalosti typ) {
		this.typ = typ;
	}

	public String getIdTramvaje() {
		return idTramvaje;
	}

	public void setIdTramvaje(String idTramvaje) {
		this.idTramvaje = idTramvaje;
	}

	public String getLokace() {
		return lokace;
	}

	public void setLokace(String lokace) {
		this.lokace = lokace;
	}
	





	public tramvaj getTram() {
		return tram;
	}

	public void setTram(tramvaj tram) {
		this.tram = tram;
	}






	public enum typUdalosti {nastupVystup,jizdaVpred,havarie}


	public udalost(udajCasu pocatekUdalosti, udajCasu konecUdalosti, typUdalosti typ, String idTramvaje,
			String lokace, tramvaj tram,Random gen) {
		super();
		this.pocatekUdalosti = pocatekUdalosti;
		this.konecUdalosti = konecUdalosti;
		this.typ = typ;
		this.idTramvaje = idTramvaje;
		this.lokace = lokace;
		this.tram =tram;
		this.generator = gen;
	};
	
	public udalost(){}
	
	public void printUdalost(){
		System.out.println("****************");
		pocatekUdalosti.vypis();
		konecUdalosti.vypis();
		System.out.println(typ);
		System.out.println("KDE: " + lokace);
		System.out.println(this.idTramvaje);

		
	}
	
	
	
	public static udalost vyvolejUdalost(udalost event,ArrayList zasobnikUdalosti,Random gen,int Konec){
		
		typUdalosti typ = event.getTyp();
		udalost novaUdalost = new udalost();
		if(typ == typUdalosti.jizdaVpred){
			//PRIPAD ZE SE JEDE DOPREDU => nova udalost je nastup/vystup
			typUdalosti typNovy = typUdalosti.nastupVystup;
			
			stanice staniceByla = event.tram.getDosazenaStanice();
			tramvaj.smerTramvaje smernice = event.tram.getSmer();
			stanice nova;//je treba urcit novou stanici, zde nemuze byt null
			
			if(smernice == tramvaj.smerTramvaje.vpred){
				nova = staniceByla.getNasledujici();
			}
			else{
				nova = staniceByla.getPredchozi();
			}
			event.tram.setDosazenaStanice(nova);
			event.tram.setMisto(nova.getNazev());
			
			int vygenerovanyCas = gen.nextInt(run.nastupVystup+1);
			//System.out.println(""+ vygenerovanyCas);
			udajCasu konec = cas.udajCasu.kopie(event.getKonecUdalosti());
			konec.zvysCasMin(vygenerovanyCas);

			
			novaUdalost = new udalost(event.getKonecUdalosti(), konec, typNovy, event.tram.getId(), nova.getNazev(), event.tram, gen);
			tramvaj tramcka = event.getTram();
			novaUdalost.printUdalost();
			tramcka.setPosledniUdalost(novaUdalost);
		}
		else{
			//JIZDA VPRED/VZAD
			
			typUdalosti typNovy = typUdalosti.jizdaVpred;
			
			stanice staniceByla = event.tram.getDosazenaStanice();
			tramvaj.smerTramvaje smernice = event.tram.getSmer();
			stanice nova = new stanice("pass");
			spoj novy = new spoj();
			
			
			if(smernice == tramvaj.smerTramvaje.vpred){
				nova = staniceByla.getNasledujici();
				novy = staniceByla.getNasledujiciSpoj();
				if(nova == null){//obraceniSmeru
					event.tram.setSmer(tramvaj.smerTramvaje.vzad);
					nova = staniceByla.getPredchozi();
					novy = staniceByla.getPredchoziSpoj();
				}
			}
			else{//smer vzad
				nova = staniceByla.getPredchozi();
				novy = staniceByla.getPredchoziSpoj();
				if(nova == null){//obraceniSmeru
					event.tram.setSmer(tramvaj.smerTramvaje.vpred);
					nova = staniceByla.getNasledujici();
					novy = staniceByla.getNasledujiciSpoj();
			}
			
		}
			
			stanice stara = staniceByla;
			//je dana stanice stara,nova a spoj k nim novy
			
			udajCasu konec = cas.udajCasu.kopie(event.getKonecUdalosti());
			
			int prum = novy.getPrumernaDobaCesty();
			int var = novy.getVarianceCesty();			
			int vygenerovanyCas = prum + gen.nextInt(var+1);
			
			konec.zvysCasMin(vygenerovanyCas);
			String retezec = "Jede z: " + stara.getNazev() + " do: " + nova.getNazev();
			novaUdalost = new udalost(event.getKonecUdalosti(), konec, typNovy, event.tram.getId(), retezec, event.tram, gen);
			tramvaj tramcka = event.getTram();
			novaUdalost.printUdalost();
			tramcka.setPosledniUdalost(novaUdalost);
			
			
			
			
			
			
			}
		
		int hodnota = novaUdalost.getKonecUdalosti().vypoctiPoradi();
		if(hodnota < Konec){
		zaradUdalost(zasobnikUdalosti , novaUdalost);}
		else
		{System.out.println("DOSAZENO KONCE SIMULACE");}
		return novaUdalost;}
	
	
	public static void zaradUdalost(ArrayList listek, udalost U){
		Iterator listovac = listek.iterator();
		int[] policko = new int[listek.size()];

		for(int i=0;i<listek.size();i++){
			udalost udal = (udalost) listovac.next();
			int hodnota = udal.getKonecUdalosti().vypoctiPoradi();
			policko[i] = hodnota;
		}
		int cislo = U.getKonecUdalosti().vypoctiPoradi();
		int citac;
		for(citac=0;citac<listek.size();citac++){
			if(cislo<=policko[citac]){
				break;
			}
		}
		listek.add(citac, U);
		//System.out.println("Zarazeno " + citac + " " + listek.size());
			
			
		}
		
		
		
		
		
	}
	

