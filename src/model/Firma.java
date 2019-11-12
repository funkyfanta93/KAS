package model;

public class Firma {
	private String navn = "";
	private int CVR = 0;
	private int telefonNr = 0;

	public Firma(String navn, int CVR, int telefonNr) {
		this.navn = navn;
		this.CVR = CVR;
		this.telefonNr = telefonNr;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getCVR() {
		return CVR;
	}

	public void setCVR(int CVR) {
		this.CVR = CVR;
	}

	public int getTelefonNr() {
		return telefonNr;
	}

	public void setTelefonNr(int telefonNr) {
		this.telefonNr = telefonNr;
	}

}