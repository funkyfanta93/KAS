package model;

public class Udflugt {
	private double pris = 0;
	private String frokost = "";
	private String dato = "";

	public Udflugt(double pris, String frokost, String dato) {
		this.pris = pris;
		this.frokost = frokost;
		this.dato = dato;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public double getPris() {
		return pris;
	}

	public void setFrokost(String frokost) {
		this.frokost = frokost;
	}

	public String getFrokost() {
		return frokost;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public String getDato() {
		return dato;
	}
}
