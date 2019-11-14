package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Hotel;
import model.Konference;

public class HotelWindow extends Stage {

	public HotelWindow(String title, Konference konference) {

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

	public HotelWindow(String title) {
		this(title, null);
	}

	// ------------------------------------------------------------------

	private TextField txfNavn;
	private TextField txfPris;
	private TextField txfDpris;
	private Konference konference;

	private Label lblError = new Label("");
	private final ListView<Hotel> lvwHotel = new ListView<>();

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		pane.add(lvwHotel, 0, 1, 1, 2);
		lvwHotel.setPrefWidth(200);
		lvwHotel.setPrefHeight(200);
		lvwHotel.getItems().setAll(konference.getHoteller());

		Label lblH = new Label("Hoteller");
		pane.add(lblH, 0, 0);

		Label lbltH = new Label("TILFØJT HOTEL :");
		pane.add(lbltH, 0, 3);

		Label lblNavn = new Label("navn: ");
		pane.add(lblNavn, 0, 4);

		txfNavn = new TextField();
		pane.add(txfNavn, 0, 5);

		Label lblEPris = new Label("Enkeltværelse Pris:");
		pane.add(lblEPris, 0, 6);

		txfPris = new TextField();
		pane.add(txfPris, 0, 7);

		Label lblDpris = new Label("Dobbeltværelse Pris:");
		pane.add(lblDpris, 0, 8);

		txfDpris = new TextField();
		pane.add(txfDpris, 0, 9);

		pane.add(lblError, 0, 10);

		HBox vbox = new HBox();

		Button btnTilføjHotel = new Button("Tilføj");
		vbox.getChildren().add(btnTilføjHotel);
		btnTilføjHotel.setOnAction(event -> okAction());

		Button btnFortrydHotel = new Button("Luk");
		vbox.getChildren().add(btnFortrydHotel);

		pane.add(vbox, 0, 11);

	}

	private void okAction() {

		String name = txfNavn.getText().trim();
		if (name.length() == 0) {
			lblError.setText("Navn er tom");
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

		int test1 = -1;
		try {
			test1 = Integer.parseInt(txfDpris.getText().trim());
		} catch (NumberFormatException ex) {
			// do nothing

		}
		if (test1 < 0) {
			lblError.setText("dobbeltVærelsepris er tom/forkert");
			return;
		}

		// Call controller methods
		Hotel hotel;
		hotel = Controller.createHotel(txfNavn.getText().trim(),
				Integer.parseInt(txfPris.getText().trim()),
				Integer.parseInt(txfDpris.getText().trim()));
		Controller.tilføjHotel(konference, hotel);
		lblError.setText("");
		lvwHotel.getItems().setAll(konference.getHoteller());

	}

}
