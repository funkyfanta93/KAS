package model;

import java.time.LocalDateTime;

public class Konference {
	private String navn = "";
	private LocalDateTime dato = LocalDateTime.of(2012, 12, 12, 12, 12);
	private int pris = 0;
	private int længde = 0;

	public Konference(String navn, LocalDateTime dato, int pris, int længde) {
		this.navn = navn;
		this.dato = dato;
		this.pris = pris;
		this.længde = længde;
	}

	public int getLængde() {
		return længde;
	}

	public void setLængde(int længde) {
		this.længde = længde;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	public void setDato(LocalDateTime dato) {
		this.dato = dato;
	}

	public LocalDateTime getDato() {
		return dato;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

	public int getPris() {
		return pris;
	}

}
