package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Hotel;
import model.Tilvalg;

public class TilvalgWindow extends Stage {

	Hotel hotel;

	public TilvalgWindow(Hotel hotel, String title) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);
		this.hotel = hotel;
		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}
	public TilvalgWindow(String title) {
		this(null, title);
	}

	private TextField txfNavn;
	private TextField txfPris;
	private Label lblError;

	private final ListView<Tilvalg> lvwTilvalg = new ListView<>();

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		pane.add(lvwTilvalg, 0, 1, 1, 2);
		lvwTilvalg.setPrefWidth(200);
		lvwTilvalg.setPrefHeight(200);
		lvwTilvalg.getItems().setAll(hotel.getTilvalg());

		Label lblH = new Label("Hoteller");
		pane.add(lblH, 0, 0);

		Label lbltH = new Label("TILFØJT HOTEL :");
		pane.add(lbltH, 0, 3);

		Label lblNavn = new Label("navn: ");
		pane.add(lblNavn, 0, 4);

		txfNavn = new TextField();
		pane.add(txfNavn, 0, 5);

		Label lblEPris = new Label("Pris:");
		pane.add(lblEPris, 0, 6);

		txfPris = new TextField();
		pane.add(txfPris, 0, 7);

		// txfDpris = new TextField();
		// pane.add(txfDpris, 0, 9);

		// pane.add(lblError, 0, 10);

		HBox vbox = new HBox();

		Button btnTilføjHotel = new Button("Tilføj");
		vbox.getChildren().add(btnTilføjHotel);
		btnTilføjHotel.setOnAction(event -> okAction());
		// btnTilføjHotel.setOnAction(event -> okAction());

		Button btnFortrydHotel = new Button("Luk");
		vbox.getChildren().add(btnFortrydHotel);

		pane.add(vbox, 0, 11);
	}

	private void okAction() {

		String name = txfNavn.getText().trim();
		if (name.length() == 0) {
			lblError.setText("Navn er tomt");
			return;
		}

		int test = -1;

		try {
			test = Integer.parseInt(txfPris.getText().trim());
		} catch (NumberFormatException ex) { // do nothing '
		}
		if (test < 0) {
			lblError.setText("Enkeltværelse pris er tom/forkert");
			return;
		}

		// Call controller methods

		Controller.createTilvalg(txfNavn.getText().trim(),
				Integer.valueOf(txfPris.getText().trim()), hotel);
		lvwTilvalg.getItems().setAll(hotel.getTilvalg());
	}
}
