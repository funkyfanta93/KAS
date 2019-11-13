package model;

public class Tilvalg {
	private String navn;
	private int pris;

	public Tilvalg(String navn, int pris, Hotel hotel) {
		this.navn = navn;
		this.pris = pris;
		hotel.addTilvalg(this);
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

	public void setPris(int pris) {
		this.pris = pris;
	}

}
