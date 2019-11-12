package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Konference {
	private String navn;
	private LocalDateTime dato;
	private int pris;
	private int længde;

	private ArrayList<Hotel> hoteller = new ArrayList<>();

	public ArrayList<Hotel> getHoteller() {
		return new ArrayList<>(hoteller);
	}

	private ArrayList<Udflugt> udflugter = new ArrayList<>();

	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<>(udflugter);
	}

	public Konference(String navn, LocalDateTime dato, int pris, int længde) {
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

	public void setDato(LocalDateTime dato) {
		this.dato = dato;
	}

	public LocalDateTime getDato() {
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

}
