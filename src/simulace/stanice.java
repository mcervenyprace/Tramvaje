package simulace;

public class stanice {
	
	public linka linkaTetoStanice;
	
	public String nazev;
	
	public stanice predchozi;
	public stanice nasledujici;
	
	public spoj predchoziSpoj;
	public spoj nasledujiciSpoj;
	
	
	
	public stanice(String nazev){
		this.setNazev(nazev);
	}
	
	
	public linka getLinkaTetoStanice() {
		return linkaTetoStanice;
	}


	public void setLinkaTetoStanice(linka linkaTetoStanice) {
		this.linkaTetoStanice = linkaTetoStanice;
	}


	public spoj getPredchoziSpoj() {
		return predchoziSpoj;
	}


	public void setPredchoziSpoj(spoj predchoziSpoj) {
		this.predchoziSpoj = predchoziSpoj;
	}


	public spoj getNasledujiciSpoj() {
		return nasledujiciSpoj;
	}


	public void setNasledujiciSpoj(spoj nasledujiciSpoj) {
		this.nasledujiciSpoj = nasledujiciSpoj;
	}	
	
	public String getNazev() {
		return nazev;
	}
	public void setNazev(String nazev) {
		this.nazev = nazev;
	}
	public stanice getPredchozi() {
		return predchozi;
	}
	public void setPredchozi(stanice predchozi) {
		this.predchozi = predchozi;
	}
	public stanice getNasledujici() {
		return nasledujici;
	}
	public void setNasledujici(stanice nasledujici) {
		this.nasledujici = nasledujici;
	}
	
	
	
	
	
}
