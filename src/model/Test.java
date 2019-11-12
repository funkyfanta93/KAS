package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Test {

	public static void main(String[] args) {

		LocalDateTime l = LocalDateTime.now();

		LocalDate a = LocalDate.of(2014, Month.JANUARY, 1);
		LocalDate b = LocalDate.of(2014, Month.JANUARY, 4);
		LocalDate c = LocalDate.of(2014, Month.JANUARY, 3);

		Udflugt odense = new Udflugt(125, true, l);
		Udflugt egeskov = new Udflugt(75, true, l);
		Udflugt trap = new Udflugt(200, true, l);
		Hotel DHS = new Hotel("", 1050, 1250);
		Tilvalg wifi = new Tilvalg("", 50);

		Konference konferance = new Konference("Hav og Himmel", l, 1500, 3);
		Tilmelding tildmelding = new Tilmelding("Hej", "", 0, false, "", a, b,
				konferance);
		Tilmelding ulla = new Tilmelding("", "", 0, false, "", a, c, "",
				konferance);
		Tilmelding hans = new Tilmelding("", "", 0, false, "", a, b,
				konferance);
		hans.addHotel(DHS);

		Tilmelding peter = new Tilmelding("Hej", "", 0, false, "", a, b, "",
				konferance);

		Tilmelding lone = new Tilmelding("Hej", "", 0, true, "", a, b, "",
				konferance);

		peter.addHotel(DHS);
		peter.addTilvalg(wifi);
		peter.addUdflugter(trap);
		peter.addUdflugter(egeskov);

		lone.addHotel(DHS);
		lone.addTilvalg(wifi);
		lone.addUdflugter(egeskov);
		lone.addUdflugter(odense);

		System.out.println(tildmelding.beregnPris());

		ulla.addUdflugter(odense);

		System.out.println(ulla.beregnPris());

		System.out.println(hans.beregnPris());

		System.out.println(peter.beregnPris());

		System.out.println(lone.beregnPris());

	}
}
