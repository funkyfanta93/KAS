package gui;

import java.time.LocalDate;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Konference;
import model.Udflugt;

public class UdflugtWindow extends Stage {

	public UdflugtWindow(String title, Konference konference) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public UdflugtWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------

	private TextField txfNavn;
	private TextField txfPris;
	private CheckBox cbxFrokost;
	private DatePicker dpcDato;

	private Label lblError = new Label("");

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label lblUdflugt = new Label("Tilføj Udflugt");
		pane.add(lblUdflugt, 0, 0);

		Label lblNavn = new Label("Navn:");
		pane.add(lblNavn, 0, 3);

		txfNavn = new TextField();
		pane.add(txfNavn, 0, 4, 2, 1);

		Label lblPris = new Label("Pris for udflugt");
		pane.add(lblPris, 0, 5);

		txfPris = new TextField();
		pane.add(txfPris, 0, 6);

		Label lblFrokost = new Label("Frokost inkluderet?");
		pane.add(lblFrokost, 0, 7);

		cbxFrokost = new CheckBox();
		pane.add(cbxFrokost, 0, 8);

		Label lblDatePicker = new Label("Dato for udflugt:");
		pane.add(lblDatePicker, 0, 9);

		dpcDato = new DatePicker();
		pane.add(dpcDato, 0, 10, 2, 1);

		HBox vbox = new HBox();

		Button btnTilføjUdflugt = new Button("Tilføj");
		vbox.getChildren().add(btnTilføjUdflugt);
		btnTilføjUdflugt.setOnAction(event -> okAction());

		Button btnFortrydUdflugt = new Button("Luk");
		vbox.getChildren().add(btnFortrydUdflugt);
		btnFortrydUdflugt.setOnAction(event -> close());

		pane.add(vbox, 0, 11);

	}

	private void okAction() {
		String name = txfNavn.getText().trim();
		if (name.length() == 0) {
			lblError.setText("Navn er tomt");
			return;
		}

		int test1 = -1;
		try {
			test1 = Integer.parseInt(txfPris.getText().trim());
		} catch (NumberFormatException ex) {
			// do nothing

		}

		LocalDate dato = dpcDato.getValue();

		if (dato == null) {
			lblError.setText("Der er ikke valgt nogen dato");
			return;
		}

		Udflugt udflugt;
		udflugt = Controller.createUdflugt(txfNavn.getText().trim(), Integer.parseInt(txfPris.getText().trim()),
				cbxFrokost.isSelected(), dpcDato.getValue());
	}

}
