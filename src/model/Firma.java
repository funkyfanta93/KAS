package model;

public class Firma {
	private String navn;
	private int CVR;
	private int telefonNr;

	public Firma(String navn, int telefonNr) {
		this.navn = navn;
		this.telefonNr = telefonNr;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getTelefonNr() {
		return telefonNr;
	}

	public void setTelefonNr(int telefonNr) {
		this.telefonNr = telefonNr;
	}

}
