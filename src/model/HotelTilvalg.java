package model;

public class HotelTilvalg {
	private String navn;
	private int pris;

	public HotelTilvalg(String navn, int pris) {
		this.navn = navn;
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

	public void setPris(int pris) {
		this.pris = pris;
	}

}
