package gui;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import model.Hotel;
import model.Konference;
import model.Tilmelding;
import model.Udflugt;

public class DeltagerWindow extends Stage {

	Konference konference;
	Hotel hotel;
	Udflugt udflugt;

	public DeltagerWindow(String title, Konference konference) {

		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);
		this.konference = konference;
		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public DeltagerWindow(String title, Hotel hotel, Konference konferance) {

		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);
		this.hotel = hotel;
		this.konference = konferance;
		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public DeltagerWindow(String title, Udflugt udflugt,
			Konference konferance) {

		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);
		this.udflugt = udflugt;
		this.konference = konferance;
		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	private final ListView<Tilmelding> lvwDeltager = new ListView<>();

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		pane.add(lvwDeltager, 0, 1, 1, 2);
		lvwDeltager.setPrefWidth(200);
		lvwDeltager.setPrefHeight(200);
		lvwDeltager.getItems().setAll();

		Label lblH = new Label("Deltagere");
		pane.add(lblH, 0, 0);

		Button ryd = new Button("slet");
		pane.add(ryd, 3, 0);

		if ((hotel == null) && (udflugt == null)) {
			lvwDeltager.getItems().setAll(konference.getTilmeldinger());
			ryd.setOnAction(event -> {
				konference.removeTilmelding(
						lvwDeltager.getSelectionModel().getSelectedItem());
				lvwDeltager.getItems().setAll(konference.getTilmeldinger());
			});
		}

		if (!(this.hotel == null)) {

			ArrayList<Tilmelding> tilmelding = new ArrayList<>();
			ArrayList<Tilmelding> vis = new ArrayList<>();

			tilmelding.addAll(konference.getTilmeldinger());

			for (Tilmelding tilmelding2 : tilmelding) {
				if (tilmelding2.getHotel() != null) {
					if (tilmelding2.getHotel().equals(hotel)) {
						vis.add(tilmelding2);
					}
				}

				tilmelding.removeAll(vis);

			}

			ryd.setOnAction(event -> {
				lvwDeltager.getSelectionModel().getSelectedItem()
						.setHotel(null);
				lvwDeltager.getItems().setAll(tilmelding);
			});

		}

		if (!(udflugt == null)) {

			ArrayList<Tilmelding> tilmelding = new ArrayList<>(
					konference.getTilmeldinger());

			for (Tilmelding tilmelding2 : tilmelding) {
				if (!(tilmelding2.getUdflugter().contains(udflugt))) {
					tilmelding.remove(tilmelding2);
				}
			}

			ryd.setOnAction(event -> {
				lvwDeltager.getSelectionModel().getSelectedItem()
						.removeUdflugter(udflugt);
				lvwDeltager.getItems().setAll(tilmelding);
			});

			lvwDeltager.getItems().setAll(tilmelding);

		}

	}

}
