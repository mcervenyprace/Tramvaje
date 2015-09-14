package simulace;



import java.util.*;

import simulace.cas.udajCasu;
import simulace.tramvaj.stavTramvaje;
import simulace.udalost.typUdalosti;

public class run {
	
	
	public static final boolean karambol = true;
	
	public static final int nastupVystup = 3; 
	public static final int minutaVterin = 60; 

	public static void main(String args[]){
		
		System.out.println("Vitejte v Martinovo simulaci tramvaji!");
		
		// pole s nazvy zastavek 
		
		final String[] poleZastavek1 = {"Ejpovicka","Uzlova","Makova","Kvetova"};
		final String[] poleZastavek2 = {"Vokata","Uzlova","Mrnava"};
		
		// pole s vzdalenostmi zastavek (v minutach)
		
		final int[] poleVzdalenosti1 = {4,5,3};
		final int[] poleVzdalenosti2 = {6,7};
		
		// pole s variancemi zpozdeni

		final int[] poleZpozdeni1 = {2,6,7};
		final int[] poleZpozdeni2 = {2,13};		
		
		// doba nastupu a vystupu
		
		
		
		//tramvaj prvniTramvaj = new tramvaj(tramvaj.stavTramvaje.vprovozu, poleZastavek1[0], null, "RX1");	
		
		final stanice[] polestanic1 = new stanice[4];
		final stanice[] polestanic2 = new stanice[3];
		
		//vytvoreni a naplneni linky A stanicemi
		
		linka linkaA = new linka('A');
		
		stanice predchoziStanice = null;
		
		for(int i=0;i<polestanic1.length;i++){
			stanice novaStanice = new stanice(poleZastavek1[i]);
			novaStanice.setLinkaTetoStanice(linkaA);
			polestanic1[i] = novaStanice;
			linkaA.pridejStanice(novaStanice);
			
			if(predchoziStanice != null){
				spoj.spojDveStanice(predchoziStanice,novaStanice, linkaA,poleVzdalenosti1[i-1],poleZpozdeni1[i-1]);	
			}
			predchoziStanice = novaStanice;
			
			
		}
		
		linkaA.vypis();
		
		System.out.println("##########");
		
		predchoziStanice = null;
		
		linka linkaB = new linka('B');
		
		for(int i=0;i<polestanic2.length;i++){
			stanice novaStanice = new stanice(poleZastavek2[i]);
			novaStanice.setLinkaTetoStanice(linkaB);
			polestanic2[i] = novaStanice;
			linkaB.pridejStanice(novaStanice);
			
			if(predchoziStanice != null){
				spoj.spojDveStanice(predchoziStanice,novaStanice, linkaA,poleVzdalenosti2[i-1],poleZpozdeni2[i-1]);
			}
			predchoziStanice = novaStanice;
		}
		
		linkaB.vypis();
		
		System.out.println("##########");	
		
		//vytvoreni tramvaji
		
		tramvaj tram1 = new tramvaj(tramvaj.stavTramvaje.vprovozu, tramvaj.smerTramvaje.vpred, poleZastavek1[3], polestanic1[3], "RX2");
		tram1.printTramvaj();
		
		tramvaj tram2 = new tramvaj(tramvaj.stavTramvaje.vprovozu, tramvaj.smerTramvaje.vzad, poleZastavek2[2], polestanic2[2], "VU12");
		tram2.printTramvaj();
		
		stanice opravarna = new stanice("opravarna");
		tramvaj tram3 = new tramvaj(tramvaj.stavTramvaje.rozbita, tramvaj.smerTramvaje.neexistuje,"V oprave", opravarna, "BKE3");
		tram3.printTramvaj();
		
	
		
		System.out.println("##########");
		System.out.println("Vitejte v Martinovo simulaci tramvaji!");
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Zadejte prosim pocet minut po ktere ma simulace bezet:");
		// get user input for a
		int casMax = reader.nextInt()*minutaVterin;		
		//int casMax = 6000;
		
		udajCasu t = new udajCasu(0, 0,0, 0);
		System.out.println("Pocatecni cas je:");
		t.vypis();
		
		ArrayList zasobnikUdalosti = new ArrayList(); //zasobnik s udalostmi
		Random nahoda = new Random(); // generator nahodnych cisel
		
		udalost udalost1 = new udalost(t, t, udalost.typUdalosti.nastupVystup, tram1.getId(), tram1.getMisto(),tram1,nahoda);
		tram1.setPosledniUdalost(udalost1);
		
		udalost udalost2 = new udalost(t, t, udalost.typUdalosti.nastupVystup, tram2.getId(), tram2.getMisto(),tram2,nahoda);
		tram2.setPosledniUdalost(udalost2);
		
		zasobnikUdalosti.add(udalost1);
		zasobnikUdalosti.add(udalost2);
		//udalost1.printUdalost();
		
		while(!zasobnikUdalosti.isEmpty()){
			udalost vybranaUdalost = (udalost) zasobnikUdalosti.remove(0);		
			udalost.vyvolejUdalost(vybranaUdalost,zasobnikUdalosti,nahoda,casMax,karambol);
			}
				
		
	}
	

		
		
		
		
		
}
	
	

	
	
	
	
	
	
