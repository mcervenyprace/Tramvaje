package simulace;

import simulace.tramvaj.stavTramvaje;

public class run {

	public static void main(String args[]){
		
		
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
		
		
		System.out.println("Vitejte v Martinovo simulaci tramvaji!");
		//System.out.println(poleZastavek1[0]); //kontrola pole
		
		
		}
			
	
}
