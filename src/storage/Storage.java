package storage;

import java.util.ArrayList;

import model.Firma;

public class Storage {

	private static ArrayList<Firma> firmaer = new ArrayList<>();

	public static ArrayList<Firma> getFirma() {
		return new ArrayList<>(firmaer);
	}

	public static void addFirma(Firma firma) {
		firmaer.add(firma);
	}

}
