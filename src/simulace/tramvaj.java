package simulace;

public class tramvaj {
	
	//overeni spojeni s GitHub	

	public String toString() {
		return "tramvaj cislo "+ id + "se naleza v stanici " + dosazenaStanice + " a je ve stavu " + stav;
	}



	public enum stavTramvaje {vprovozu,rozbita}
	public stavTramvaje stav;
	public String misto; //popis kde tramvaj je
	public stanice dosazenaStanice;
	public String id;
	
	
	
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



	public tramvaj(stavTramvaje stav, String misto, stanice dosazenaStanice, String id) {
		super();
		this.stav = stav;
		this.misto = misto;
		this.dosazenaStanice = dosazenaStanice;
		this.id = id;
	}



	public static void main(String[] args) {
		System.out.println(stavTramvaje.vprovozu);
	}
}
