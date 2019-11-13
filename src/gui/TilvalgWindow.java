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

public class TilvalgWindow extends Stage {

	public TilvalgWindow(Stage stage, String title) {
		this.initOwner(stage);
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setMinHeight(200);
		this.setMinWidth(200);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
	}

	private TextField txfNavn;
	private TextField txfPris;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label lblTilvalg = new Label("Tilføj mulige tilvalg");
		pane.add(lblTilvalg, 0, 0);

		Label lblNavn = new Label("Navn:");
		pane.add(lblNavn, 1, 1);

		txfNavn = new TextField();
		pane.add(txfNavn, 2, 1, 2, 1);

		Label lblPris = new Label("Pris:");
		pane.add(lblPris, 3, 1);

		txfPris = new TextField();
		pane.add(txfPris, 4, 1, 2, 1);

		Button btnTilføjTilvalg = new Button("Tilføj");
		pane.add(btnTilføjTilvalg, 5, 1);

		Button btnFortrydTilvalg = new Button("Fortryd");
		pane.add(btnFortrydTilvalg, 5, 2);
	}
}
