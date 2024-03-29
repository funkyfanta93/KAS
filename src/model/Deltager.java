package model;

import storage.Storage;

public class Deltager {
	private String navn;
	private String adresse;
	private Firma firma;
	private boolean fordragsholder;
	private String Firmanavn;
	private int firmaCVR;

	private String by;
	private int telefonnr;

	public Deltager(String navn, String adresse, String by, int telefonnr,
			boolean fordragsholder) {
		this.navn = navn;
		this.adresse = adresse;
		this.by = by;
		this.telefonnr = telefonnr;
		this.fordragsholder = fordragsholder;

	}

	public Deltager(String navn, String adresse, String by, int telefonnr,
			boolean fordragsholder, String firmaNavn, int firmaCVR) {
		this.navn = navn;
		this.adresse = adresse;
		this.by = by;
		this.telefonnr = telefonnr;
		this.fordragsholder = fordragsholder;
		this.Firmanavn = firmaNavn;
		this.firmaCVR = firmaCVR;

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

	public boolean isFordragsholder() {
		return fordragsholder;
	}

	public void setFordragsholder(boolean fordragsholder) {
		this.fordragsholder = fordragsholder;
	}

}
