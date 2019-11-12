package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

public class Tilmelding {
	private String ledsagerNavn;
	private boolean ledsager;
	private LocalDate ankomstDato;
	private LocalDate afrejseDato;
	private Deltager deltager;
	private Konference konferance;

	private Hotel hotel;
	private final ArrayList<Tilvalg> tilvalg = new ArrayList<>();
	private final ArrayList<Udflugt> udflugter = new ArrayList<>();

	public void addHotel(Hotel hotel) {
		this.hotel = hotel;

	}

	public void addTilvalg(Tilvalg tilvalg) {
		if (!this.tilvalg.contains(tilvalg)) {
			this.tilvalg.add(tilvalg);
		}
	}

	public void removeTilvalg(Tilvalg tilvalg) {
		if (this.tilvalg.contains(tilvalg)) {
			this.tilvalg.remove(tilvalg);
		}
	}

	public void addUdflugter(Udflugt Udflugt) {
		if (!this.udflugter.contains(Udflugt)) {
			this.udflugter.add(Udflugt);
		}
	}

	public void removeUdflugter(Udflugt udflugt) {
		if (this.udflugter.contains(udflugt)) {
			this.udflugter.remove(udflugt);
		}
	}

	/**
	 * 
	 * Tildmelding med Ledsager og Firma
	 * 
	 * 
	 */

	public Tilmelding(String navn, String adresse, int telefonnr,
			boolean fordragsholder, String by, LocalDate ankomst,
			LocalDate afrejse, Firma firma, String ledsagerNavn,
			Konference konference) {
		this.deltager = new Deltager(navn, adresse, by, telefonnr,
				fordragsholder, firma);
		this.ledsager = true;
		this.ledsagerNavn = ledsagerNavn;
		this.ankomstDato = ankomst;
		this.afrejseDato = afrejse;
		this.konferance = konference;

	}

	/**
	 * 
	 * Tildmelding uden Ledsager med Firma
	 * 
	 * 
	 */

	public Tilmelding(String navn, String adresse, int telefonnr,
			boolean fordragsholder, String by, LocalDate ankomst,
			LocalDate afrejse, Firma firma, Konference konference) {
		this.deltager = new Deltager(navn, adresse, by, telefonnr,
				fordragsholder, firma);
		this.ledsager = false;
		this.ankomstDato = ankomst;
		this.afrejseDato = afrejse;
		this.konferance = konference;

	}

	/**
	 * 
	 * Tildmelding med Ledsager og uden Firma
	 * 
	 * 
	 */

	public Tilmelding(String navn, String adresse, int telefonnr,
			boolean fordragsholder, String by, LocalDate ankomst,
			LocalDate afrejse, String ledsagerNavn, Konference konference) {
		this.deltager = new Deltager(navn, adresse, by, telefonnr,
				fordragsholder);
		this.ledsager = true;
		this.ledsagerNavn = ledsagerNavn;
		this.ankomstDato = ankomst;
		this.afrejseDato = afrejse;
		this.konferance = konference;

	}

	/**
	 * 
	 * Tildmelding uden Ledsager og Firma
	 * 
	 * 
	 */

	public Tilmelding(String navn, String adresse, int telefonnr,
			boolean fordragsholder, String by, LocalDate ankomst,
			LocalDate afrejse, Konference konference) {
		this.deltager = new Deltager(navn, adresse, by, telefonnr,
				fordragsholder);
		this.ledsager = false;
		this.ankomstDato = ankomst;
		this.afrejseDato = afrejse;
		this.konferance = konference;

	}

	public int beregnPris() {
		int pris = 0;
		if (!deltager.isFordragsholder()) {
			pris += this.konferance.getPris()
					* ChronoUnit.DAYS.between(ankomstDato, afrejseDato);
		}
		if (hotel != null) {
			if (ledsager) {
				pris += this.hotel.getDobbeltPris()
						* (ChronoUnit.DAYS.between(ankomstDato, afrejseDato)
								- 1);
			} else {
				pris += this.hotel.getEnkeltPris()
						* (ChronoUnit.DAYS.between(ankomstDato, afrejseDato)
								- 1);
			}
			for (Tilvalg tilvalg2 : tilvalg) {
				pris += tilvalg2.getPris()
						* (ChronoUnit.DAYS.between(ankomstDato, afrejseDato)
								- 1);
			}

		}
		if (ledsager) {
			for (Udflugt udflugt : udflugter) {

				pris += udflugt.getPris();
			}
		}
		return pris;

	}

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
