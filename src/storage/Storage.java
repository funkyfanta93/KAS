package storage;

import java.util.ArrayList;

import model.Firma;

public class Storage {

	private static ArrayList<Firma> firmaer = new ArrayList<>();

	public static ArrayList<Firma> getArrangementer() {
		return new ArrayList<>(firmaer);
	}

	public static void addPlads(Firma firma) {
		firmaer.add(firma);
	}

}
