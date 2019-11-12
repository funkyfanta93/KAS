package storage;

import java.util.ArrayList;

import model.Deltager;
import model.Firma;
import model.Hotel;
import model.Konference;
import model.Tilmelding;
import model.Tilvalg;
import model.Udflugt;

public class Storage {

	private static ArrayList<Firma> firmaer = new ArrayList<>();

	public static ArrayList<Firma> getFirma() {
		return new ArrayList<>(firmaer);
	}

	public static void addFirma(Firma firma) {
		firmaer.add(firma);
	}

	public static void removeFirma(Firma firma) {
		firmaer.remove(firma);
	}

	private static ArrayList<Deltager> deltagerer = new ArrayList<>();

	public static ArrayList<Deltager> getDeltager() {
		return new ArrayList<>(deltagerer);
	}

	public static void addDeltager(Deltager deltager) {
		deltagerer.add(deltager);
	}

	public static void removeDeltager(Deltager deltager) {
		deltagerer.remove(deltager);
	}

	private static ArrayList<Udflugt> udflugter = new ArrayList<>();

	public static ArrayList<Udflugt> getUdflugt() {
		return new ArrayList<>(udflugter);
	}

	public static void addUdflugt(Udflugt udflugt) {
		udflugter.add(udflugt);
	}

	public static void removeUdflugt(Udflugt udflugt) {
		udflugter.remove(udflugt);
	}

	private static ArrayList<Tilvalg> muligeTilvalg = new ArrayList<>();

	public static ArrayList<Tilvalg> getTilvalg() {
		return new ArrayList<>(muligeTilvalg);
	}

	public static void addTilvalg(Tilvalg tilvalg) {
		muligeTilvalg.add(tilvalg);
	}

	public static void removeTilvalg(Tilvalg tilvalg) {
		muligeTilvalg.remove(tilvalg);
	}

	private static ArrayList<Hotel> hoteller = new ArrayList<>();

	public static ArrayList<Hotel> getHotel() {
		return new ArrayList<>(hoteller);
	}

	public static void addHotel(Hotel hotel) {
		hoteller.add(hotel);
	}

	public static void removeHotel(Hotel hotel) {
		hoteller.remove(hotel);
	}

	private static ArrayList<Konference> konferencer = new ArrayList<>();

	public static ArrayList<Konference> getKonference() {
		return new ArrayList<>(konferencer);
	}

	public static void addKonference(Konference konference) {
		konferencer.add(konference);
	}

	public static void removeKonfernce(Konference konference) {
		konferencer.remove(konference);
	}

	private static ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

	public static ArrayList<Tilmelding> getTilmelding() {
		return new ArrayList<>(tilmeldinger);
	}

	public static void addTilmelding(Tilmelding tilmelding) {
		tilmeldinger.add(tilmelding);
	}

	public static void removeTilmelding(Tilmelding tilmelding) {
		tilmeldinger.remove(tilmelding);
	}

}
