package model;

import java.time.LocalDateTime;

public class Test {

	public static void main(String[] args) {

		LocalDateTime l = LocalDateTime.now();

		Konference konferance = new Konference("Hav og Himmel", l, 1500, 3);
		Tilmelding tildmelding = new Tilmelding("Hej", "", 0, false, "", null,
				null, konferance);

		System.out.println(tildmelding.beregnPris());

	}
}
