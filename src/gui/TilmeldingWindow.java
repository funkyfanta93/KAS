package gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Firma;
import model.Hotel;
import model.Tilvalg;
import model.Udflugt;

public class TilmeldingWindow extends Stage {

	public TilmeldingWindow(String title) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);

	}

	// -------------------------------------------------------------------------

	private TextField txfNavn, txfAdresse, txfBy, txfAnkomst, txfTelefon,
			txfAfrejse, txfFirma, txfHotel;

	private ListView<Hotel> lvwHoteller = new ListView<>();
	private ListView<Tilvalg> lvwTilvalg = new ListView<>();
	private ListView<Tilvalg> lvwTilvalgValgte = new ListView<>();
	private ListView<Firma> lvwFirma = new ListView<>();
	private ListView<Udflugt> lvwUdflugt = new ListView<>();
	private ListView<Udflugt> lvwUdflugterValgte = new ListView<>();

	private void initContent(GridPane pane) {

		// show or hide grid lines
		pane.setGridLinesVisible(false);
		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		// add a label to the pane (at col=0, row=0)
		// Label lblName = new Label("Name:");
		// pane.add(lblName, 0, 0);
		//
		// // add a label to the pane (at col=0, row=1)
		// Label lblNames = new Label("Names:");
		// pane.add(lblNames, 0, 1);
		// GridPane.setValignment(lblNames, VPos.TOP);

		// add a text field to the pane (at col=1, row=0)
		txfNavn = new TextField();
		pane.add(txfNavn, 1, 2);

		txfAdresse = new TextField();
		pane.add(txfAdresse, 1, 3);

		txfBy = new TextField();
		pane.add(txfBy, 1, 4);

		txfAnkomst = new TextField();
		pane.add(txfAnkomst, 3, 3);

		txfTelefon = new TextField();
		pane.add(txfTelefon, 3, 2);

		txfAfrejse = new TextField();
		pane.add(txfAfrejse, 3, 4);

		txfFirma = new TextField();
		pane.add(txfFirma, 1, 6);
		txfFirma.setEditable(false);

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

		Label lblLedsager = new Label("Ledsager");
		pane.add(lblLedsager, 0, 8);

		Label lblValgteUdflugter = new Label("Valgte Udflugter");
		pane.add(lblValgteUdflugter, 1, 9);

		Label lblTilbudteUdflugter = new Label("Tilbudte Udflugter");
		pane.add(lblTilbudteUdflugter, 3, 9);

		Label lblHotel = new Label("Hotel");
		pane.add(lblHotel, 0, 13);

		Label lblValgteTilvalg = new Label("Valgte Tilvalg");
		pane.add(lblValgteTilvalg, 1, 14);

		Label lblTilbudteTilvalg = new Label("Tilbudte Tilvalg");
		pane.add(lblTilbudteTilvalg, 3, 14);

		CheckBox cbForedragsholder = new CheckBox("");
		pane.add(cbForedragsholder, 1, 5);

		CheckBox cbLedsager = new CheckBox("");
		pane.add(cbLedsager, 1, 8);

		Button btnTilføjFirma = new Button("Tilføj");
		pane.add(btnTilføjFirma, 1, 6);
		GridPane.setMargin(btnTilføjFirma, new Insets(60, 0, 0, 0));
		GridPane.setHalignment(btnTilføjFirma, HPos.RIGHT);

		Button btnRydFirma = new Button("Ryd");
		pane.add(btnRydFirma, 1, 6);
		GridPane.setMargin(btnRydFirma, new Insets(60, 0, 0, 0));
		GridPane.setHalignment(btnRydFirma, HPos.LEFT);

		Button btnOpretFirma = new Button("Opret");
		pane.add(btnOpretFirma, 3, 7);
		GridPane.setHalignment(btnOpretFirma, HPos.LEFT);

		Button btnSletFirma = new Button("Slet");
		pane.add(btnSletFirma, 3, 7);
		GridPane.setHalignment(btnSletFirma, HPos.RIGHT);

		Button btnRedigerFirma = new Button("Rediger");
		pane.add(btnRedigerFirma, 3, 7);
		GridPane.setHalignment(btnRedigerFirma, HPos.CENTER);

		Button btnTilføjUdflugt = new Button("Tilføj");
		pane.add(btnTilføjUdflugt, 1, 11);
		GridPane.setHalignment(btnTilføjUdflugt, HPos.RIGHT);

		Button btnRydUdflugt = new Button("Ryd");
		pane.add(btnRydUdflugt, 1, 11);
		GridPane.setHalignment(btnRydUdflugt, HPos.LEFT);

		Button btnTilføjHotel = new Button("Tilføj");
		pane.add(btnTilføjHotel, 1, 13);
		GridPane.setMargin(btnTilføjHotel, new Insets(60, 0, 0, 0));
		GridPane.setHalignment(btnTilføjHotel, HPos.RIGHT);

		Button btnRydHotel = new Button("Ryd");
		pane.add(btnRydHotel, 1, 13);
		GridPane.setMargin(btnRydHotel, new Insets(60, 0, 0, 0));
		GridPane.setHalignment(btnRydHotel, HPos.LEFT);

		Button btnRydTilvalg = new Button("Ryd");
		pane.add(btnRydTilvalg, 1, 16);
		GridPane.setHalignment(btnRydTilvalg, HPos.LEFT);

		Button btnTilføjTilvalg = new Button("Tilføj");
		pane.add(btnTilføjTilvalg, 1, 16);
		GridPane.setHalignment(btnTilføjTilvalg, HPos.RIGHT);

		Button btnTilmeldDeltager = new Button("Tilmeld");
		pane.add(btnTilmeldDeltager, 0, 18);

		lvwFirma = new ListView<>();
		lvwFirma.setPrefWidth(200);
		lvwFirma.setPrefHeight(100);
		pane.add(lvwFirma, 3, 6);

		lvwUdflugterValgte = new ListView<>();
		lvwUdflugterValgte.setPrefWidth(200);
		lvwUdflugterValgte.setPrefHeight(100);
		pane.add(lvwUdflugterValgte, 1, 10);

		lvwUdflugt = new ListView<>();
		lvwUdflugt.setPrefWidth(200);
		lvwUdflugt.setPrefHeight(100);
		pane.add(lvwUdflugt, 3, 10);

		lvwHoteller = new ListView<>();
		lvwHoteller.setPrefWidth(200);
		lvwHoteller.setPrefHeight(100);
		pane.add(lvwHoteller, 3, 13);

		lvwTilvalgValgte = new ListView<>();
		lvwTilvalgValgte.setPrefWidth(200);
		lvwTilvalgValgte.setPrefHeight(100);
		pane.add(lvwTilvalgValgte, 1, 15);

		lvwTilvalg = new ListView<>();
		lvwTilvalg.setPrefWidth(200);
		lvwTilvalg.setPrefHeight(100);
		pane.add(lvwTilvalg, 3, 15);

	}

}
