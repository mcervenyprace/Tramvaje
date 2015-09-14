package simulace;

public class tramvaj {
	
	//overeni spojeni s GitHub	

	public String toString() {
		return "tramvaj cislo "+ id + "se naleza v stanici " + dosazenaStanice + " a je ve stavu " + stav;
	}



	public enum stavTramvaje {vprovozu,rozbita}
	public enum smerTramvaje {vpred, vzad, neexistuje}
	
	
	public stavTramvaje stav;
	public String misto; //popis kde tramvaj je
	public smerTramvaje smer; //popis jak je tramvaj otocena (nemuze se otocit)
	public stanice dosazenaStanice;
	public String id;
	public udalost posledniUdalost;

	
	
	
	public smerTramvaje getSmer() {
		return smer;
	}



	public void setSmer(smerTramvaje smer) {
		this.smer = smer;
	}



	public udalost getPosledniUdalost() {
		return posledniUdalost;
	}



	public void setPosledniUdalost(udalost posledniUdalost) {
		this.posledniUdalost = posledniUdalost;
	}



	public stavTramvaje getStav() {
		return stav;
	}



	public void setStav(stavTramvaje stav) {
		this.stav = stav;
	}



	public String getMisto() {
		return misto;
	}



	public void setMisto(String misto) {
		this.misto = misto;
	}



	public stanice getDosazenaStanice() {
		return dosazenaStanice;
	}



	public void setDosazenaStanice(stanice dosazenaStanice) {
		this.dosazenaStanice = dosazenaStanice;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public tramvaj(stavTramvaje stav, smerTramvaje smer, String misto, stanice dosazenaStanice, String id) {
		super();
		this.stav = stav;
		this.smer = smer;
		this.misto = misto;
		this.dosazenaStanice = dosazenaStanice;
		this.id = id;
	}
	
	public void printTramvaj(){
		System.out.println("Tramvaj cislo: " + this.getId());
		System.out.println("Nachazi se na misto: " + this.getMisto());
		System.out.println("Nejpozdeji dosazena stanice: " + this.getDosazenaStanice().getNazev());
		System.out.println("Ve stavu: " + this.getStav());		
		
		
	}



	public static void main(String[] args) {
		System.out.println(stavTramvaje.vprovozu);
	}
}
