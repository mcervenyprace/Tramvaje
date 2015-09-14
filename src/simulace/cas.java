package simulace;
import java.util.*;

public class cas {
	
	public static class udajCasu{
		
		final int minutaVterin = 60;
		final int denHodin = 24;
		
		
		public int sekunda;//0-59
		public int minuta;//0-59
		public int hodina;//0-23
		public int den;//0-x		
		
		public udajCasu(int sekunda, int minuta, int hodina, int den){
		
			this.sekunda = sekunda;	
			this.minuta = minuta;
			this.hodina = hodina;
			this.den = den;
			this.zvysCas(0);//automaticky upravi format...
		}
		
		public static udajCasu kopie(udajCasu u){
			udajCasu novy = new udajCasu(u.getSekunda(), u.getMinuta(), u.getHodina(), u.getDen());
			return novy;
		}
		

		
		public int getMinuta() {
			return minuta;
		}

		public void setMinuta(int minuta) {
			this.minuta = minuta;
		}

		public int getSekunda() {
			return sekunda;
		}
		public void setSekunda(int sekunda) {
			this.sekunda = sekunda;
		}
		public int getHodina() {
			return hodina;
		}
		public void setHodina(int hodina) {
			this.hodina = hodina;
		}
		public int getDen() {
			return den;
		}
		public void setDen(int den) {
			this.den = den;
		}
		public void vypis(){
			String prvy = Integer.toString(sekunda);
			String druhy = Integer.toString(minuta);
			String treti = Integer.toString(hodina);
			String ctvrty = Integer.toString(den);
			
			System.out.println("Den:" + ctvrty + ":" + treti + "h:" + druhy + ":" + prvy);
			//int poradi = this.vypoctiPoradi();
			//System.out.println("" + poradi);//pouhe overeni poradi
		}
		
		/**
		 * Vypocte pocet vterin = poradi v simulaci 
		 * 
		 */
		public int vypoctiPoradi(){
			int vysledek = this.getSekunda();
			vysledek = vysledek + this.getMinuta()*this.minutaVterin;
			vysledek = vysledek + this.getHodina()*this.minutaVterin*this.minutaVterin;
			vysledek = vysledek + this.getDen()*this.minutaVterin*this.minutaVterin*this.denHodin;
			return vysledek;
		}
		
		
		
		
		/**
		 * Zvyseni casu o dany pocet MINUT, upravi na dany format
		 * 
		 */
		
		public void zvysCasMin(int minuty){
			int sekundy = minuty * this.minutaVterin;
			zvysCas(sekundy);
			
		}
		
		
		
		
		/**
		 * Zvyseni casu o dany pocet vterin, upravi na dany format
		 * 
		 */
		
		public void zvysCas(int vteriny){
			
			
			int sekundyNew = this.getSekunda() + vteriny;
			
			if(sekundyNew >=minutaVterin){
				int pocetVterin = sekundyNew % minutaVterin;
				int pocetMinut = (sekundyNew -pocetVterin)/minutaVterin;
				//System.out.println("" + pocetMinut);
				int vysledneMinuty = this.getMinuta()+pocetMinut;
				this.setMinuta(vysledneMinuty);
				this.setSekunda(pocetVterin);
			}
			
			int kontrola = this.getMinuta();
			if(kontrola >= minutaVterin){
				int pocetNavic = kontrola % minutaVterin;
				int pocetHodin = (kontrola -pocetNavic)/minutaVterin;
				int vysledneHodiny = this.getHodina()+pocetHodin;
				this.setMinuta(pocetNavic);
				this.setHodina(vysledneHodiny);
				
			}
			
			kontrola = this.getHodina();
			if(kontrola >= denHodin){
				int pocetNavic = kontrola % denHodin;
				int pocetDnu = (kontrola -pocetNavic)/denHodin;
				int vysledneDny = this.getDen()+pocetDnu;
				this.setHodina(pocetNavic);
				this.setDen(vysledneDny);
				
			}
			
			
		}
		
		
			
	}
	

	
	
	
	
	
	
	

	public static void main(String[] args) throws Exception {
		udajCasu t = new udajCasu(183, 59,70, 3);
		t.vypis();
		t.zvysCasMin(6000);
		t.vypis();
		
	}
	
	
}
