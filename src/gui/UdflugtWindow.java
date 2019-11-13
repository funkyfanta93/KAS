package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UdflugtWindow extends Stage {

	public UdflugtWindow(Stage stage, String title) {
		this.initOwner(stage);
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setMinHeight(300);
		this.setMinWidth(200);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
	}

	private TextField txfNavn;
	private CheckBox cbxFrokost;
	private DatePicker dpcDato;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label lblUdflugt = new Label("Tilføj Udflugt");
		pane.add(lblUdflugt, 0, 0);

		Label lblNavn = new Label("Navn:");
		pane.add(lblNavn, 1, 1);

		txfNavn = new TextField();
		pane.add(txfNavn, 2, 1, 2, 1);

		Label lblFrokost = new Label("Frokost inkluderet?");
		pane.add(lblFrokost, 3, 1);

		cbxFrokost = new CheckBox();
		pane.add(cbxFrokost, 4, 1);

		Label lblDatePicker = new Label("Dato for udflugt:");
		pane.add(lblDatePicker, 5, 1);

		dpcDato = new DatePicker();
		pane.add(dpcDato, 6, 1, 2, 1);

		Button btnTilføjUdflugt = new Button("Tilføj");
		pane.add(btnTilføjUdflugt, 7, 1);

		Button btnFortrydUdflugt = new Button("Fortryd");
		pane.add(btnFortrydUdflugt, 7, 2);

	}

}
