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
	
	
	
	public static udalost vyvolejUdalost(udalost event,Stack zasobnikUdalosti,Random gen){
		
		typUdalosti typ = event.getTyp();
		
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

			
			udalost novaUdalost = new udalost(event.getKonecUdalosti(), konec, typNovy, event.tram.getId(), nova.getNazev(), event.tram, gen);
			tramvaj tramcka = event.getTram();
			novaUdalost.printUdalost();
			tramcka.setPosledniUdalost(novaUdalost);
		}
		else{
			//JIZDA VPRED/VZAD
			
			typUdalosti typNovy = typUdalosti.jizdaVpred;
			
			stanice staniceByla = event.tram.getDosazenaStanice();
			tramvaj.smerTramvaje smernice = event.tram.getSmer();
			
			if(smernice == tramvaj.smerTramvaje.vpred){
				stanice nova = staniceByla.getNasledujici();
				if(nova == null){}
			}
			else{
				stanice nova = staniceByla.getPredchozi();
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		udalost aha = new udalost();
		return aha;
		
		
		
		
	}
	
	
	
	
	
	
}
