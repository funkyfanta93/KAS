package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HotelWindow extends Stage {

	public HotelWindow(Stage stage, String title) {
		this.initOwner(stage);
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setMinHeight(400);
		this.setMinWidth(200);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);
		Scene scene = new Scene(pane);
		stage.setScene(scene);

	}

	// ------------------------------------------------------------------

	private TextField tfxNavn;
	private TextField tfxEnkeltPris;
	private TextField tfxDobbeltPris;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label lblHotel = new Label("Tilføj Hotel");
		pane.add(lblHotel, 0, 0);

		Label lblNavn = new Label("Navn:");
		pane.add(lblNavn, 1, 1);

		tfxNavn = new TextField();
		pane.add(tfxNavn, 2, 1, 2, 1);

		Label lblEnkeltPris = new Label("Pris for enkeltværelse");
		pane.add(lblEnkeltPris, 3, 1);

		tfxEnkeltPris = new TextField();
		pane.add(tfxEnkeltPris, 4, 1, 2, 1);

		Label lblDobbeltPris = new Label("Pris for dobbeltværelse");
		pane.add(lblDobbeltPris, 5, 1);

		tfxDobbeltPris = new TextField();
		pane.add(tfxDobbeltPris, 6, 1, 2, 1);

		Button btnTilføjHotel = new Button("Tilføj");
		pane.add(btnTilføjHotel, 7, 1);

		Button btnFortrydHotel = new Button("Fortryd");
		pane.add(btnFortrydHotel, 7, 2);

	}

}
