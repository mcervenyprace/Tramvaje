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
	
	public static void main(String[] args) {
		System.out.println(stavTramvaje.vprovozu);
	}
}
