package fr.isika.cda23.TP_JAVAFX_formulaire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FirstPan extends GridPane {
	static List<Stagiaire> sta = new ArrayList<>();
	private Label nom;
	private Label prenom;
	private Label dateDeNaissance;
	private Label genre;
	private Label formation;
	private Label localisation;
	private Button btn;

	public FirstPan() {
//	Nom:
		this.nom = new Label("Nom:");
		TextField name = new TextField();
		name.setPrefSize(150, 8);

		HBox hbUser = new HBox();

		hbUser.getChildren().addAll(this.nom, name);
		hbUser.setSpacing(10);
//		hbUser.setAlignment(Pos.BASELINE_RIGHT);
//PRENOM:
		this.prenom = new Label("PRENOM: ");
		TextField firstName = new TextField();
		firstName.setPrefSize(150, 8);

		HBox hbUserPrenom = new HBox();

		hbUser.getChildren().addAll(this.prenom, firstName);
		hbUser.setSpacing(10);
//		hbUser.setAlignment(Pos.BASELINE_RIGHT);

//Date de naissance:
		this.dateDeNaissance = new Label("DATE DE NAISSANCE: ");
		DatePicker datePicker = new DatePicker();
		HBox hbDate = new HBox();
		hbDate.getChildren().addAll(dateDeNaissance, datePicker);
		hbDate.setSpacing(10);
//		hbDate.setAlignment(Pos.BASELINE_RIGHT);

//genre:
		this.genre = new Label("GENRE: ");
		ToggleGroup group = new ToggleGroup();
		// Creating new Toggle buttons.
		ToggleButton maleButton = new ToggleButton("Male");
		ToggleButton femaleButton = new ToggleButton("Female");

		maleButton.setSelected(true);

		// Set toggle group
		// In a group, maximum only one button is selected
		maleButton.setToggleGroup(group);
		maleButton.setUserData("Male");
		femaleButton.setToggleGroup(group);
		femaleButton.setUserData("Female");

		HBox hbGenre = new HBox();
		hbGenre.getChildren().addAll(this.genre, maleButton, femaleButton);
		hbGenre.setSpacing(10);
//		hbDate.setAlignment(Pos.BASELINE_RIGHT);
//Formation:
		this.formation = new Label("FORMATION: ");
		// Group
		ToggleGroup groupFormation = new ToggleGroup();

		// Radio 1:
		RadioButton button1 = new RadioButton("CDA");
		button1.setUserData("CDA");
		button1.setToggleGroup(groupFormation);
		button1.setSelected(true);

		// Radio 2:
		RadioButton button2 = new RadioButton("AL");
		button2.setUserData("AL");
		button2.setToggleGroup(groupFormation);

		HBox hbFormation = new HBox();
		hbFormation.getChildren().addAll(this.formation, button1, button2);
		hbFormation.setSpacing(10);

//		Localisation

		Localisation paris = new Localisation("Paris");
		Localisation lyon = new Localisation("Lyon");
		Localisation ny = new Localisation("New York");
		this.localisation = new Label("Localisation:");

		ObservableList<Localisation> list = FXCollections.observableArrayList(paris, ny, lyon);
		ChoiceBox<Localisation> choiceBox = new ChoiceBox<Localisation>(list);

		HBox hbLocalisation = new HBox();
		hbLocalisation.getChildren().addAll(this.localisation, choiceBox);
		hbLocalisation.setSpacing(10);

//		création button
		this.btn = new Button("Ajouter au formulaire");
//		création Boxbutton
		HBox hbBtn = new HBox();

		hbBtn.getChildren().add(btn);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
//				System.out.println(name.getText() + "-" + firstName.getText() + "-" + datePicker.getValue() + "-"
//						+ group.getSelectedToggle().getUserData() + '-'
//						+ groupFormation.getSelectedToggle().getUserData() + "-"
//						+ choiceBox.getSelectionModel().getSelectedItem());
				Stagiaire stagiaire = new Stagiaire(name.getText(), firstName.getText(),
						datePicker.getValue().toString(), group.getSelectedToggle().getUserData().toString(),
						groupFormation.getSelectedToggle().getUserData().toString(),
						choiceBox.getSelectionModel().getSelectedItem().toString());
				Collections.addAll(sta, stagiaire);
//				 Iterator<Stagiaire> ite = sta.iterator();
//			        while (ite.hasNext()){
//			            System.out.println(ite.next());
//			        }
				SecondePan secondePan = new SecondePan();
				Scene scene = new Scene(secondePan);
				Stage stage = (Stage) FirstPan.this.getScene().getWindow();
				stage.setScene(scene);
			}
		});

		this.addRow(0, hbUser);
		this.addRow(1, hbUserPrenom);
		this.addRow(2, hbDate);
		this.addRow(3, hbGenre);
		this.addRow(4, hbFormation);
		this.addRow(5, hbLocalisation);
		this.addRow(5, hbBtn);

		this.setVgap(10);
		this.setHgap(10);

		this.setAlignment(Pos.CENTER);

		this.setPadding(new Insets(10, 10, 10, 10));
	}
}
