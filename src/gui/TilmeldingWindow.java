package gui;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import model.Hotel;
import model.Konference;
import model.Tilmelding;
import model.Tilvalg;
import model.Udflugt;

public class TilmeldingWindow extends Stage {

	public TilmeldingWindow(String title, Konference konference) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);
		this.konferance = konference;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);

	}

	// -------------------------------------------------------------------------

	private TextField txfNavn, txfAdresse, txfBy, txfTelefon, txfFirma,
			txfFirmaCVR, txfHotel, txfLedsagerNavn, txfDeltagerPris;

	private DatePicker Ankomst, Afrejse;

	private Button btnTilmeldDeltager;

	private Konference konferance;

	private CheckBox cbLedsager, cbForedragsholder;

	private ListView<Hotel> lvwHoteller = new ListView<>();
	private ListView<Tilvalg> lvwTilvalg = new ListView<>();
	private ListView<Tilvalg> lvwTilvalgValgte = new ListView<>();

	private ListView<Udflugt> lvwUdflugt = new ListView<>();
	private ListView<Udflugt> lvwUdflugterValgte = new ListView<>();

	private ArrayList<Udflugt> udflugter = new ArrayList();
	private ArrayList<Tilvalg> tilvalg = new ArrayList();

	private void initContent(GridPane pane) {

		// show or hide grid lines
		pane.setGridLinesVisible(false);
		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

<<<<<<< HEAD
||||||| 64229ef
		// add a label to the pane (at col=0, row=0)
//				Label lblName = new Label("Name:");
//				pane.add(lblName, 0, 0);
		//
//				// add a label to the pane (at col=0, row=1)
//				Label lblNames = new Label("Names:");
//				pane.add(lblNames, 0, 1);
//				GridPane.setValignment(lblNames, VPos.TOP);

		// add a text field to the pane (at col=1, row=0)
=======
		// add a label to the pane (at col=0, row=0)
		// Label lblName = new Label("Name:");
		// pane.add(lblName, 0, 0);
		//
		// // add a label to the pane (at col=0, row=1)
		// Label lblNames = new Label("Names:");
		// pane.add(lblNames, 0, 1);
		// GridPane.setValignment(lblNames, VPos.TOP);

		// add a text field to the pane (at col=1, row=0)
>>>>>>> 4dce4a4ede5440816a66bc1bf53b5733843026df
		txfNavn = new TextField();
		pane.add(txfNavn, 1, 2);

		txfAdresse = new TextField();
		pane.add(txfAdresse, 1, 3);

		txfBy = new TextField();
		pane.add(txfBy, 1, 4);

		Ankomst = new DatePicker();
		pane.add(Ankomst, 3, 3);

		txfTelefon = new TextField();
		pane.add(txfTelefon, 3, 2);

		Afrejse = new DatePicker();
		pane.add(Afrejse, 3, 4);

		txfFirma = new TextField();
		pane.add(txfFirma, 1, 6);

		txfFirmaCVR = new TextField();
		pane.add(txfFirmaCVR, 1, 7);

		txfHotel = new TextField();
		pane.add(txfHotel, 1, 13);

		Label lblDeltagerinfo = new Label("Deltagerinformation");
		pane.add(lblDeltagerinfo, 0, 0);

		Label lblTelefon = new Label("Tlf.nr:");
		pane.add(lblTelefon, 2, 2);

		Label lblNavn = new Label("Navn:");
		pane.add(lblNavn, 0, 2);

		Label lblAdresse = new Label("Adresse:");
		pane.add(lblAdresse, 0, 3);

		Label lblBy = new Label("By/Land:");
		pane.add(lblBy, 0, 4);

		Label lblAnkomst = new Label("Ankomstdato:");
		pane.add(lblAnkomst, 2, 3);

		Label lblAfrejse = new Label("Afrejsedato:");
		pane.add(lblAfrejse, 2, 4);

		Label lblForedragsholder = new Label("Foredragsholder");
		pane.add(lblForedragsholder, 0, 5);

		Label lblFirma = new Label("Firma");
		pane.add(lblFirma, 0, 6);

		Label lblFirmaCVR = new Label("FirmaCVR");
		pane.add(lblFirmaCVR, 0, 7);

		Label lblLedsagerNavn = new Label("Ledsager Navn");
		pane.add(lblLedsagerNavn, 3, 7);

		txfLedsagerNavn = new TextField();
		pane.add(txfLedsagerNavn, 3, 8);
		txfLedsagerNavn.setDisable(true);

		Label lblLedsager = new Label("Ledsager");
		pane.add(lblLedsager, 0, 8);

		Label lblValgteUdflugter = new Label("Valgte Udflugter");
		pane.add(lblValgteUdflugter, 3, 9);

		Label lblTilbudteUdflugter = new Label("Tilbudte Udflugter");
		pane.add(lblTilbudteUdflugter, 1, 9);

		Label lblHotel = new Label("Hotel");
		pane.add(lblHotel, 0, 13);

		Label lblValgteTilvalg = new Label("Valgte Tilvalg");
		pane.add(lblValgteTilvalg, 3, 14);

		Label lblTilbudteTilvalg = new Label("Tilbudte Tilvalg");
		pane.add(lblTilbudteTilvalg, 1, 14);

		cbForedragsholder = new CheckBox("");
		pane.add(cbForedragsholder, 1, 5);

		cbLedsager = new CheckBox("");
		pane.add(cbLedsager, 1, 8);
		cbLedsager.setOnAction(event -> ledsagerCBX());

		Button btnTilføjUdflugt = new Button("Tilføj");
		pane.add(btnTilføjUdflugt, 1, 11);
		GridPane.setHalignment(btnTilføjUdflugt, HPos.CENTER);
		btnTilføjUdflugt.setOnAction(event -> addUdflugt());

		Button btnRydUdflugt = new Button("Ryd");
		pane.add(btnRydUdflugt, 3, 11);
		GridPane.setHalignment(btnRydUdflugt, HPos.CENTER);
		btnRydUdflugt.setOnAction(event -> removeUdflugt());

		Button btnRydTilvalg = new Button("Ryd");
		pane.add(btnRydTilvalg, 3, 16);
		GridPane.setHalignment(btnRydTilvalg, HPos.CENTER);
		btnRydTilvalg.setOnAction(event -> removeTilvalg());

		Button btnTilføjTilvalg = new Button("Tilføj");
		pane.add(btnTilføjTilvalg, 1, 16);
		GridPane.setHalignment(btnTilføjTilvalg, HPos.CENTER);
		btnTilføjTilvalg.setOnAction(event -> addHotel());

		Button btnLuk = new Button("Luk");
		pane.add(btnLuk, 3, 18);
		GridPane.setHalignment(btnLuk, HPos.LEFT);
		btnLuk.setOnAction(event -> hide());

		btnTilmeldDeltager = new Button("Tilmeld");
		pane.add(btnTilmeldDeltager, 0, 18);
		btnTilmeldDeltager.setOnAction(event -> addTildmelding());

		Label lblSamledePris = new Label("Ledsager");
		pane.add(lblSamledePris, 0, 19);

		txfDeltagerPris = new TextField();
		pane.add(txfDeltagerPris, 1, 19);
		txfDeltagerPris.setEditable(false);

		lvwUdflugterValgte = new ListView<>();
		lvwUdflugterValgte.setPrefWidth(200);
		lvwUdflugterValgte.setPrefHeight(100);
		pane.add(lvwUdflugterValgte, 3, 10);

		lvwUdflugt = new ListView<>();
		lvwUdflugt.setPrefWidth(200);
		lvwUdflugt.setPrefHeight(100);
		pane.add(lvwUdflugt, 1, 10);
		lvwUdflugt.getItems().setAll(konferance.getUdflugter());

		lvwUdflugt.setDisable(true);

		lvwHoteller = new ListView<>();
		lvwHoteller.setPrefWidth(200);
		lvwHoteller.setPrefHeight(100);
		pane.add(lvwHoteller, 1, 13);
		lvwHoteller.getItems().setAll(konferance.getHoteller());

		lvwTilvalgValgte = new ListView<>();
		lvwTilvalgValgte.setPrefWidth(200);
		lvwTilvalgValgte.setPrefHeight(100);
		pane.add(lvwTilvalgValgte, 3, 15);

		lvwTilvalg = new ListView<>();
		lvwTilvalg.setPrefWidth(200);
		lvwTilvalg.setPrefHeight(100);
		pane.add(lvwTilvalg, 1, 15);

		ChangeListener<Hotel> listener = (ov, o, n) -> this.hotelVælger();
		lvwHoteller.getSelectionModel().selectedItemProperty()
				.addListener(listener);

	}

	public void addUdflugt() {
		Udflugt udflugt = lvwUdflugt.getSelectionModel().getSelectedItem();
		if (!udflugter.contains(udflugt)) {
			udflugter.add(udflugt);
			lvwUdflugterValgte.getItems().setAll(udflugter);
		}

	}

	public void removeUdflugt() {
		Udflugt udflugt = lvwUdflugterValgte.getSelectionModel()
				.getSelectedItem();
		if (!(udflugt == null)) {
			udflugter.remove(udflugt);
			lvwUdflugterValgte.getItems().setAll(udflugter);
		}

	}

	public void addHotel() {
		Tilvalg tilvalg = lvwTilvalg.getSelectionModel().getSelectedItem();
		if (!this.tilvalg.contains(tilvalg)) {
			this.tilvalg.add(tilvalg);
			lvwTilvalgValgte.getItems().setAll(this.tilvalg);
		}

	}

	public void removeTilvalg() {
		Tilvalg tilvalg = lvwTilvalgValgte.getSelectionModel()
				.getSelectedItem();
		if (!(tilvalg == null)) {
			this.tilvalg.remove(tilvalg);
			lvwTilvalgValgte.getItems().setAll(this.tilvalg);
		}

	}

	private void hotelVælger() {

		Hotel selected = lvwHoteller.getSelectionModel().getSelectedItem();
		if (selected != null) {
			lvwTilvalg.getItems().setAll(selected.getTilvalg());
		} else {
			lvwTilvalgValgte.refresh();
		}
	}

	private void ledsagerCBX() {
		if (!cbLedsager.isSelected()) {
			lvwUdflugt.setDisable(true);
			txfLedsagerNavn.setDisable(true);
			udflugter.clear();
			lvwUdflugterValgte.getItems().setAll(udflugter);

		} else {

			lvwUdflugt.setDisable(false);
			txfLedsagerNavn.setDisable(false);

		}
	}

	private void addTildmelding() {

		String navn = txfNavn.getText().trim();
		String adresse = txfAdresse.getText().trim();
		int telefonnr = Integer.valueOf(txfTelefon.getText().trim());
		boolean fordragsholder = cbForedragsholder.isSelected();
		String by = txfBy.getText().trim();
		LocalDate ankomst = Ankomst.getValue();
		LocalDate afrejse = Afrejse.getValue();
		String firmanavn = txfFirma.getText().trim();
		int firmatlf = Integer.valueOf(txfFirmaCVR.getText().trim());
		String ledsagerNavn = txfLedsagerNavn.getText().trim();
		Konference konference = this.konferance;

		Tilmelding tilmelding = Controller.createTildmelding(navn, adresse,
				telefonnr, fordragsholder, by, ankomst, afrejse, firmanavn,
				firmatlf, ledsagerNavn, konference);
		for (Udflugt udflugt : udflugter) {
			tilmelding.addUdflugter(udflugt);
		}
		for (Tilvalg tilvalg : tilvalg) {
			tilmelding.addTilvalg(tilvalg);
		}

		txfDeltagerPris.setText(String.valueOf(tilmelding.beregnPris()));
		btnTilmeldDeltager.setDisable(true);

		System.out.println(tilmelding.getHotel());

	}
}
