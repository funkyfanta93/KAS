package model;

public class Konference {
	private String navn = "";
	private String dato = "";
	private double pris = 0;

	public Konference(String navn, String dato, double pris) {
		this.navn = navn;
		this.dato = dato;
		this.pris = pris;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public String getDato() {
		return dato;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public double getPris() {
		return pris;
	}

}
