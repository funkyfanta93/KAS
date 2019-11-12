package model;

public class Hotel {
	private String navn;
	private int pris;

	public Hotel(String navn, int pris) {
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
