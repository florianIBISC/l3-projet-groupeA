package application;

import java.net.URL;

import bd.controlleur.ChargementDonnees;
import controlleur.ControllerAuthentification;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		ChargementDonnees cd= new ChargementDonnees();
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {

		ControllerAuthentification ca=new ControllerAuthentification();
		
		try {
		      // Localisation du fichier FXML.
		      final URL url = getClass().getClassLoader().getResource("vue/AuthentificationFXML.fxml");
		      
		      // Création du loader.
		      final FXMLLoader fxmlLoader = new FXMLLoader(url);
		      
		      // Chargement du FXML.
		      final AnchorPane root = (AnchorPane) fxmlLoader.load();
			
		      final Scene scene = new Scene(root);
		      primaryStage.setTitle("Authentification");
		      primaryStage.setScene(scene);
		      primaryStage.show();
	    	
		} catch(Exception e) {
			System.err.println("Erreur au chargement: " + e);
		}
	}


}
