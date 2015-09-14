package simulace;

public class spoj {
	
	public linka linkaTohotoSpoje;
	
	public stanice prvniStanice;
	public stanice druhaStanice;
	
	public int prumernaDobaCesty;
	public int varianceCesty;
	
	
	/**
	 * spoji dve instance stanice nove vytvorenou instanci tridy spoj, kterou vraci
	 * nastavi predchozi u "druhe" a nasledujici stanice u "prvni"
	 * 
	 */
	public static spoj spojDveStanice(stanice prvniStanice,stanice druhaStanice, linka linkaStanic,int prumer,int variance){
		
		spoj spojMeziStanicemi = new spoj(linkaStanic,prvniStanice, druhaStanice,prumer,variance);
		
		prvniStanice.setNasledujici(druhaStanice);
		prvniStanice.setNasledujiciSpoj(spojMeziStanicemi);
		
		druhaStanice.setPredchozi(prvniStanice);
		druhaStanice.setPredchoziSpoj(spojMeziStanicemi);
		
		return spojMeziStanicemi;
	}
	
	
	public spoj(linka linkaTohotoSpoje, stanice prvniStanice, stanice druhaStanice, int prumernaDobaCesty,
			int varianceCesty) {
		super();
		this.linkaTohotoSpoje = linkaTohotoSpoje;
		this.prvniStanice = prvniStanice;
		this.druhaStanice = druhaStanice;
		this.prumernaDobaCesty = prumernaDobaCesty;
		this.varianceCesty = varianceCesty;
	}
	
	public linka getLinkaTohotoSpoje() {
		return linkaTohotoSpoje;
	}
	public void setLinkaTohotoSpoje(linka linkaTohotoSpoje) {
		this.linkaTohotoSpoje = linkaTohotoSpoje;
	}
	public stanice getPrvniStanice() {
		return prvniStanice;
	}
	public void setPrvniStanice(stanice prvniStanice) {
		this.prvniStanice = prvniStanice;
	}
	public stanice getDruhaStanice() {
		return druhaStanice;
	}
	public void setDruhaStanice(stanice druhaStanice) {
		this.druhaStanice = druhaStanice;
	}
	public int getPrumernaDobaCesty() {
		return prumernaDobaCesty;
	}
	public void setPrumernaDobaCesty(int prumernaDobaCesty) {
		this.prumernaDobaCesty = prumernaDobaCesty;
	}
	public int getVarianceCesty() {
		return varianceCesty;
	}
	public void setVarianceCesty(int varianceCesty) {
		this.varianceCesty = varianceCesty;
	}
	
	
	
	
	
	
	
}
