package simulace;

import simulace.tramvaj.stavTramvaje;

public class run {

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
		
		
		}
			
	
}
