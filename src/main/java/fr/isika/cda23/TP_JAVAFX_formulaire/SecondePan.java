package fr.isika.cda23.TP_JAVAFX_formulaire;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SecondePan extends BorderPane {
	private Label label = new Label("deuxième scène");
	private Button btn = new Button();

	public SecondePan() {
		super();
		this.setPrefSize(500, 500);
		this.setStyle("-fx-background-color:teal");
		AnchorPane anchorPane = new AnchorPane();
		ObservableList<Stagiaire> list = FXCollections.observableArrayList(FirstPan.sta);
		TableView<Stagiaire> tableView = new TableView<>(list);
		TableColumn<Stagiaire, String> colNom = new TableColumn("Nom");
		
		colNom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("Nom"));
		TableColumn colPrenom = new TableColumn("Prénom");
		colPrenom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("Prenom"));
		TableColumn colDate = new TableColumn("Date de naissance");
		colDate.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("Naissance"));
		TableColumn colGenre = new TableColumn("Genre");
		colGenre.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("Genre"));
		TableColumn colFormation = new TableColumn("Formation");
		colFormation.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("Formation"));
		TableColumn colLocal = new TableColumn("Localisation");
		colLocal.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("Location"));
		tableView.getColumns().addAll(colNom, colPrenom, colDate, colGenre, colFormation, colLocal);

		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		anchorPane.getChildren().add(tableView);
		anchorPane.setPrefSize(500, 500);

//		création button
		this.btn = new Button("RETOUR");
//		création Boxbutton
		HBox hbBtn = new HBox();

		hbBtn.getChildren().add(btn);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				FirstPan firstPan = new FirstPan();
				Scene scene = new Scene(firstPan);
				Stage stage = (Stage) SecondePan.this.getScene().getWindow();
				stage.setScene(scene);
			}
		});
		GridPane hb = new GridPane();
		hb.addRow(0, anchorPane);
		hb.addRow(1, hbBtn);
		getChildren().addAll(hb);
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

}
