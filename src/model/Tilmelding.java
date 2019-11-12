package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tilmelding {
	private String ledsagerNavn;
	private boolean ledsager;
	private LocalDate ankomstDato;
	private LocalDate afrejseDato;
	private Deltager deltager;
	private Konference konferance;

	private ArrayList<Hotel> hoteller = new ArrayList<>();
	private ArrayList<Tilvalg> tilvalg = new ArrayList<>();

	public void addHotel(Hotel hotel) {
		if (!hoteller.contains(hotel)) {
			hoteller.add(hotel);
		}
	}

	public void addTilvalg(Tilvalg tilvalg) {
		if (!this.tilvalg.contains(tilvalg)) {
			this.tilvalg.add(tilvalg);
		}
	}

	public void removeHotel(Hotel hotel) {
		if (hoteller.contains(hotel)) {
			hoteller.remove(hotel);
		}
	}

	public void removeTilvalg(Tilvalg tilvalg) {
		if (this.tilvalg.contains(tilvalg)) {
			this.tilvalg.remove(tilvalg);
		}
	}

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

	public Tilmelding(String navn, String adresse, int telefonnr,
			boolean fordragsholder, String by, LocalDate ankomst,
			LocalDate afrejse, Konference konference) {
		this.deltager = new Deltager(navn, adresse, by, telefonnr,
				fordragsholder);
		this.ledsager = true;
		this.ankomstDato = ankomst;
		this.afrejseDato = afrejse;
		this.konferance = konference;

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
