package model;

import java.time.LocalDateTime;

public class Udflugt {
	private int pris = 0;
	private boolean frokost;
	private LocalDateTime dato;

	public Udflugt(int pris, boolean frokost, LocalDateTime dato) {
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

	public void setDato(LocalDateTime dato) {
		this.dato = dato;
	}

	public LocalDateTime getDato() {
		return dato;
	}
}
