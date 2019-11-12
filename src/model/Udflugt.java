package model;

public class Udflugt {
	private int pris = 0;
	private boolean frokost = false;
	private String dato = "";

	public Udflugt(int pris, boolean frokost, String dato) {
		this.pris = pris;
		this.frokost = frokost;
		this.dato = dato;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

	public int getPris() {
		return pris;
	}

	public void setFrokost(boolean frokost) {
		this.frokost = frokost;
	}

	public boolean getFrokost() {
		return frokost;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public String getDato() {
		return dato;
	}
}
