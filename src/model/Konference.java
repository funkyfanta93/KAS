package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Konference {
	private String navn;
	private LocalDate dato;
	private int pris;
	private int længde;

	private final ArrayList<Hotel> hoteller = new ArrayList<>();

	public ArrayList<Hotel> getHoteller() {
		return new ArrayList<>(hoteller);
	}

	private final ArrayList<Udflugt> udflugter = new ArrayList<>();

	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<>(udflugter);
	}

	public ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

	public ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<>(tilmeldinger);
	}

	public Konference(String navn, LocalDate dato, int pris, int længde) {
		this.navn = navn;
		this.dato = dato;
		this.pris = pris;
		this.længde = længde;
	}

	public int getLængde() {
		return længde;
	}

	public void setLængde(int længde) {
		this.længde = længde;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public LocalDate getDato() {
		return dato;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

	public int getPris() {
		return pris;
	}

	public void addHotel(Hotel hotel) {
		if (!hoteller.contains(hotel)) {
			hoteller.add(hotel);
		}
	}

	public void removeHotel(Hotel hotel) {
		if (hoteller.contains(hotel)) {
			hoteller.remove(hotel);
		}
	}

	public void addUdflugt(Udflugt udflugt) {
		if (!udflugter.contains(udflugt)) {
			udflugter.add(udflugt);
		}
	}

	public void removeUdflugt(Udflugt udflugt) {
		if (udflugter.contains(udflugt)) {
			udflugter.remove(udflugt);
		}
	}

	public void addTilmelding(Tilmelding tildmelding) {
		if (!tilmeldinger.contains(tildmelding)) {
			tilmeldinger.add(tildmelding);
		}
	}

	public void removeTilmelding(Tilmelding tilmelding) {
		if (tilmeldinger.contains(tilmelding)) {
			tilmeldinger.remove(tilmelding);
		}
	}

	public int tælTilmeldinger() {
		int tilmeldinger = 0;
		for (Tilmelding tilmelding : this.tilmeldinger) {
			tilmeldinger++;
		}
		return tilmeldinger;
	}

	@Override
	public String toString() {
		return navn;
	}

}
