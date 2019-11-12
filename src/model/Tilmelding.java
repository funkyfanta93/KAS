package model;

import java.time.LocalDate;

public class Tilmelding {
	private String ledsagerNavn;
	private boolean ledsager;
	private LocalDate ankomstDato;
	private LocalDate afrejseDato;

	public String getLedsagerNavn() {
		return ledsagerNavn;
	}

	public void setLedsagerNavn(String ledsagerNavn) {
		this.ledsagerNavn = ledsagerNavn;
	}

	public boolean isLedsager() {
		return ledsager;
	}

	public void setLedsager(boolean ledsager) {
		this.ledsager = ledsager;
	}

	public LocalDate getAnkomstDato() {
		return ankomstDato;
	}

	public void setAnkomstDato(LocalDate ankomstDato) {
		this.ankomstDato = ankomstDato;
	}

	public LocalDate getAfrejseDato() {
		return afrejseDato;
	}

	public void setAfrejseDato(LocalDate afrejseDato) {
		this.afrejseDato = afrejseDato;
	}

}
