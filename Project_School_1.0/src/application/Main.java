package application;

import bd.controlleur.ChargementDonnees;
import controlleur.ControllerAuthentification;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vue.FenetreAuthentification;

public class Main extends Application{

	public static void main(String[] args) {
		ChargementDonnees cd= new ChargementDonnees();
		launch(args);

	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			FenetreAuthentification fa = new FenetreAuthentification ();
		    primaryStage.setTitle("Authentification");
		    Scene scene=fa.showWindow();
		    primaryStage.setScene(scene);
	    	primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}
