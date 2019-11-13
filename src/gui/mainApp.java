package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Konference;
import storage.Storage;

public class mainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() {
		Controller.init();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Arcitecture Demo");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// ---------------------------------------------------------------------------------------------------------

	private final TextField Deltagere = new TextField();

	private final ListView<Konference> lvwKonferancer = new ListView<>();

	private void initContent(BorderPane pane) {
		// pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(10));
		pane.setPrefSize(800, 600);
		GridPane gridpaneTop = new GridPane();
		GridPane gridpaneCenter = new GridPane();

		// -----------------------------TOP-----------------------------------------------------

		pane.setTop(gridpaneTop);

		Label titel = new Label("KAS");
		titel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		gridpaneTop.setAlignment(Pos.CENTER);
		gridpaneTop.add(titel, 0, 0);
		gridpaneTop.setPadding(new Insets(20));

		// ------------------------------------Center-----------------------------------------

		pane.setCenter(gridpaneCenter);

		gridpaneCenter.setGridLinesVisible(false);

		gridpaneCenter.setPadding(new Insets(10));

		Label konferance = new Label("Konferancer:  ");
		konferance.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		gridpaneCenter.setAlignment(Pos.TOP_CENTER);

		gridpaneCenter.add(konferance, 0, 0);

		gridpaneCenter.add(lvwKonferancer, 1, 0, 1, 2);
		lvwKonferancer.setPrefWidth(200);
		lvwKonferancer.setPrefHeight(200);
		lvwKonferancer.getItems().setAll(Storage.getKonference());

		// ----------------------------------- Left
		// -------------------------------

		VBox vbox = new VBox();

		pane.setLeft(vbox);
		vbox.setPadding(new Insets(10));
		vbox.setSpacing(8);

		vbox.setPrefWidth(120);

		Text title = new Text("Tildmeldinger");
		title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		vbox.getChildren().add(title);

		Button biler = new Button("Tildmeld");
		vbox.getChildren().add(biler);

		// ---------------------------- Right ----------------------------------

		VBox vbox2 = new VBox();
		pane.setRight(vbox2);
		vbox2.setPrefWidth(120);
		vbox2.setPadding(new Insets(10));
		vbox.setSpacing(8);

		Text title2 = new Text("Deltagere:");
		title2.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		vbox2.getChildren().add(title2);

		vbox2.getChildren().add(Deltagere);

		// --------------------------bottom
		// ----------------------------------------

		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);
		hbox.setPadding(new Insets(10));

		pane.setBottom(hbox);

		Button buttonHotel = new Button("Hoteller");
		buttonHotel.setPrefSize(100, 20);

		Button buttonUdflugt = new Button("Udflugter");
		buttonUdflugt.setPrefSize(100, 20);

		hbox.getChildren().addAll(buttonHotel, buttonUdflugt);

	}

}
