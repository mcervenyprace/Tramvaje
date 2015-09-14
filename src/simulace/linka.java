package simulace;

import java.util.*;

public class linka {
	
	public char pismeno;
	
	public Stack zasobnik;
	
	
	
	public linka(char nazev){
		this.setPismeno(nazev);
		this.zasobnik = new Stack();
	}
	
	public void pridejStanice(stanice pridat){
		zasobnik.push(pridat);		
	}
	/**
	 * Vypise nazev linky a stanice ktere do ni patri
	 * @return nazev linky ve formatu String
	 */
	
	public String vypis(){
		String nazev = Character.toString(this.pismeno);
		System.out.println("Linka: " + nazev);
		
		boolean b = true;
		Stack nahrada = new Stack();

		while(b){
			try{
				stanice vypsat = (stanice) zasobnik.pop();
				System.out.println(vypsat.getNazev());
				nahrada.push(vypsat);
			
			}
			catch (EmptyStackException e) {
				b = false;
				this.setZasobnik(nahrada);//opraveni zasobniku
			}
			
			
			
		}
		
		
		return nazev;
	}
	
	
	
	
	public void setPismeno(char nazev){
		this.pismeno = nazev;
	}
	

	

	public Stack getZasobnik() {
		return zasobnik;
	}

	public void setZasobnik(Stack zasobnik) {
		this.zasobnik = zasobnik;
	}

	public static void main(String[] args) {
	
	}
	
}
