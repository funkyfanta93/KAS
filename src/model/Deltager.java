package model;

public class Deltager {
	private String navn;
	private String adresse;

	private String by;
	private int telefonnr;

	public Deltager(String navn, String adresse, String by, int telefonnr) {
		this.navn = navn;
		this.adresse = adresse;
		this.by = by;
		this.telefonnr = telefonnr;

	}

	public String getNavn() {
		return navn;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getBy() {
		return by;
	}

	public int getTelefonnr() {
		return telefonnr;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public void setTelefonnr(int telefonnr) {
		this.telefonnr = telefonnr;
	}

}
