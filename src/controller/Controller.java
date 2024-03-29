package controller;

import java.time.LocalDate;
import java.time.Month;

import model.Firma;
import model.Hotel;
import model.Konference;
import model.Tilmelding;
import model.Tilvalg;
import model.Udflugt;
import storage.Storage;

public class Controller {

	public static void init() {
		LocalDate a = LocalDate.of(2014, Month.JANUARY, 1);
		LocalDate b = LocalDate.of(2014, Month.JANUARY, 2);
		LocalDate c = LocalDate.of(2014, Month.JANUARY, 3);
		LocalDate d = LocalDate.of(2014, Month.JANUARY, 4);

		Hotel h1 = createHotel("Hej", 200, 400);

		Konference k1 = createKonference("Den 1 Konferance", a, 1500, 3);
		Konference k2 = createKonference("Den 2 Konferance", d, 1000, 2);

		Tilmelding t1 = createTilmelding("Jonas", "kk", 32323232, false,
				"aarhus", a, c, k1);

		tilføjHotel(k1, h1);

		createTilvalg("wifi", 2, h1);

		Udflugt udflugt = createUdflugt("jonas", 20, true, a, k1);

	}

	public static void tilføjHotel(Konference konferance, Hotel hotel) {
		konferance.addHotel(hotel);

	}

	public static void tilføjUdflugt(Konference konference, Udflugt udflugt) {
		konference.addUdflugt(udflugt);
	}

	public static Konference createKonference(String navn, LocalDate dato,
			int pris, int længde) {
		Konference konference = new Konference(navn, dato, pris, længde);
		Storage.addKonference(konference);
		return konference;

	}

	/**
	 * 
	 * Tildmelding med Ledsager og Firma
	 * 
	 * 
	 */

	public static Tilmelding createTildmelding(String navn, String adresse,
			int telefonnr, boolean fordragsholder, String by, LocalDate ankomst,
			LocalDate afrejse, String firmanavn, int firmatlf,
			String ledsagerNavn, Konference konference) {
		Tilmelding tilmelding = new Tilmelding(navn, adresse, telefonnr,
				fordragsholder, by, ankomst, afrejse, firmanavn, firmatlf,
				ledsagerNavn, konference);
		Storage.addTilmelding(tilmelding);
		return tilmelding;

	}

	/**
	 * 
	 * Tildmelding uden Ledsager med Firma
	 * 
	 * 
	 */

	public static Tilmelding createTildmelding(String navn, String adresse,
			int telefonnr, boolean fordragsholder, String by, LocalDate ankomst,
			LocalDate afrejse, String firmanavn, int firmatelefon,
			Konference konference) {
		Tilmelding tilmelding = new Tilmelding(navn, adresse, telefonnr,
				fordragsholder, by, ankomst, afrejse, firmanavn, firmatelefon,
				konference);
		Storage.addTilmelding(tilmelding);
		return tilmelding;
	}

	/**
	 * 
	 * Tildmelding med Ledsager og uden Firma
	 * 
	 * 
	 */

	public static Tilmelding createTilmelding(String navn, String adresse,
			int telefonnr, boolean fordragsholder, String by, LocalDate ankomst,
			LocalDate afrejse, String ledsagerNavn, Konference konference) {
		Tilmelding tilmelding = new Tilmelding(navn, adresse, telefonnr,
				fordragsholder, by, ankomst, afrejse, ledsagerNavn, konference);
		Storage.addTilmelding(tilmelding);
		return tilmelding;
	}

	/**
	 * 
	 * Tildmelding uden Ledsager og Firma
	 * 
	 * 
	 */

	public static Tilmelding createTilmelding(String navn, String adresse,
			int telefonnr, boolean fordragsholder, String by, LocalDate ankomst,
			LocalDate afrejse, Konference konference) {
		Tilmelding tilmelding = new Tilmelding(navn, adresse, telefonnr,
				fordragsholder, by, ankomst, afrejse, konference);
		Storage.addTilmelding(tilmelding);
		return tilmelding;
	}

	public static Udflugt createUdflugt(String navn, int pris, boolean frokost,
			LocalDate dato, Konference konference) {
		Udflugt udflugt = new Udflugt(navn, pris, frokost, dato, konference);
		Storage.addUdflugt(udflugt);
		return udflugt;
	}

	public static Hotel createHotel(String navn, int enkeltPris,
			int dobbeltPris) {
		Hotel hotel = new Hotel(navn, enkeltPris, dobbeltPris);
		Storage.addHotel(hotel);
		return hotel;
	}

	public static Tilvalg createTilvalg(String navn, int pris, Hotel hotel) {
		Tilvalg tilvalg = new Tilvalg(navn, pris, hotel);
		Storage.addTilvalg(tilvalg);
		return tilvalg;

	}

	public static void bookHotel(Tilmelding tilmelding, Hotel hotel) {
		tilmelding.addHotel(hotel);
	}

	public static void bookTilvalg(Tilmelding tilmelding, Tilvalg tilvalg) {
		tilmelding.addTilvalg(tilvalg);
	}

	public static void bookUdflugt(Tilmelding tilmelding, Udflugt udflugt) {
		tilmelding.addUdflugter(udflugt);
	}

}
