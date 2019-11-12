package model;

import java.util.ArrayList;

public class Hotel {
	private String navn;
	private int enkeltPris;
	private int dobbeltPris;

	private final ArrayList<Tilvalg> tilvalg = new ArrayList<>();

	public ArrayList<Tilvalg> getTilvalg() {
		return new ArrayList<>(tilvalg);
	}

	public Hotel(String navn, int enkeltPris, int dobbeltPris) {
		this.navn = navn;
		this.enkeltPris = enkeltPris;
		this.dobbeltPris = dobbeltPris;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getEnkeltPris() {
		return enkeltPris;
	}

	public void setEnkeltPris(int enkeltPris) {
		this.enkeltPris = enkeltPris;
	}

	public int getDobbeltPris() {
		return dobbeltPris;
	}

	public void setPris(int dobbeltPris) {
		this.dobbeltPris = dobbeltPris;
	}

}
