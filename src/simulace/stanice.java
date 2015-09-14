package simulace;

public class stanice {
	
	public String nazev;
	
	public stanice predchozi;
	public stanice nasledujici;
	
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
