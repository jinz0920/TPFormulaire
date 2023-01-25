package fr.isika.cda23.TP_JAVAFX_formulaire;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
	@Override
	public void start(Stage stage) {
		FirstPan root = new FirstPan();
		Scene scene = new Scene(root, 500, 500);
		stage.setScene(scene);
		stage.setTitle("Formulaire d'enregistrement");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}