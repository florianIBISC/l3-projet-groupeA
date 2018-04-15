package application;

import java.net.URL;

import bd.controlleur.ChargementDonnees;
import controlleur.ControllerAuthentification;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		ChargementDonnees cd= new ChargementDonnees();
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
<<<<<<< HEAD
		//Image icon = new Image("image/icon.png");
		//primaryStage.getIcons().add(icon);
		
=======
		Image icon = new Image("image/icon.png");
		primaryStage.getIcons().add(icon);
		

>>>>>>> 24a783ea5a0c9ecc6e768d3ce8dae03780113f38
		ControllerAuthentification ca=new ControllerAuthentification();
		
		try {
		      // Localisation du fichier FXML.
		      final URL url = getClass().getClassLoader().getResource("vue/LoginFXML.fxml");
		      
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
