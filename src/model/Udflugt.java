package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Udflugt {
	private int pris;
	private boolean frokost;
	private LocalDate dato;

	public Udflugt(int pris, boolean frokost, LocalDate dato) {
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

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public LocalDate getDato() {
		return dato;
	}
}
