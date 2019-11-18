package gui;

import java.time.LocalDate;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Konference;

public class KonferenceWindow extends Stage {

	public KonferenceWindow(String title, Konference konference) {

		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public KonferenceWindow(String title) {
		this(title, null);
	}

	// ------------------------------------------------------------------

	private TextField txfNavn;
	private TextField txfPris;
	private TextField txflængde;

	private DatePicker datePicker;

	private LocalDate date;
	private Label lblError = new Label("");

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label lblHotel = new Label("Tilføj Konferance");
		pane.add(lblHotel, 0, 0);

		Label lblNavn = new Label("Navn:");
		pane.add(lblNavn, 0, 1);

		txfNavn = new TextField();
		pane.add(txfNavn, 0, 2);

		Label lblPris = new Label("Pris:");
		pane.add(lblPris, 0, 3);

		txfPris = new TextField();
		pane.add(txfPris, 0, 4);

		Label lblLængde = new Label("Længde:");
		pane.add(lblLængde, 0, 5);

		txflængde = new TextField();
		pane.add(txflængde, 0, 6);

		Label lblDato = new Label("Dato:");
		pane.add(lblDato, 0, 7);

		pane.add(lblError, 0, 8);

		datePicker = new DatePicker();
		pane.add(datePicker, 0, 9);

		datePicker.setOnAction(event -> {
			date = datePicker.getValue();
		});

		HBox vbox = new HBox();

		Button btnTilføjHotel = new Button("Tilføj");
		vbox.getChildren().add(btnTilføjHotel);
		btnTilføjHotel.setOnAction(event -> okAction());

		Button btnFortrydHotel = new Button("Fortryd");
		vbox.getChildren().add(btnFortrydHotel);

		pane.add(vbox, 0, 10);

	}

	private void okAction() {
		String name = txfNavn.getText().trim();
		if (name.length() == 0) {
			lblError.setText("Navn er tom");
			return;
		}

		int wage = -1;
		try {
			wage = Integer.parseInt(txfPris.getText().trim());
		} catch (NumberFormatException ex) {
			// do nothing
		}
		if (wage < 0) {
			lblError.setText("Pris er tom/forkert");
			return;
		}

		int eYear = -1;
		try {
			eYear = Integer.parseInt(txflængde.getText().trim());
		} catch (NumberFormatException ex) {
			lblError.setText("Længde er tom/forkert");

		}
		if (eYear < 0) {
			lblError.setText("Længde er tom/forkert");
			return;
		}

		if (date == null) {
			lblError.setText("Dato ikke valgt");
			return;
		}

		// Call controller methods

		Controller.createKonference(txfNavn.getText().trim(), date,
				Integer.parseInt(txfPris.getText().trim()),
				Integer.parseInt(txflængde.getText().trim()));

		hide();
	}

}
