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
		Hotel DHS = new Hotel("", 1050, 1250);

		Konference konferance = new Konference("Hav og Himmel", l, 1500, 3);
		Tilmelding tildmelding = new Tilmelding("Hej", "", 0, false, "", a, b,
				konferance);
		Tilmelding ulla = new Tilmelding("", "", 0, false, "", a, c, "",
				konferance);
		Tilmelding hans = new Tilmelding("", "", 0, false, "", a, b,
				konferance);
		hans.addHotel(DHS);

		System.out.println(tildmelding.beregnPris());

		ulla.addUdflugter(odense);

		System.out.println(ulla.beregnPris());

		System.out.println(hans.beregnPris());

	}
}
