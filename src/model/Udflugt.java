package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Udflugt {
	private int pris;
	private boolean frokost;
	private LocalDate dato;
	private String navn;

	public Udflugt(String navn, int pris, boolean frokost, LocalDate dato,
			Konference konferance) {
		this.pris = pris;
		this.frokost = frokost;
		this.dato = dato;
		this.navn = navn;
		konferance.addUdflugt(this);
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
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
	@Override
	public String toString() {
		return navn;
	}
}
