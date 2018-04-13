package vue;

import java.io.IOException;

import application.Main;
import controlleur.ControllerAuthentification;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;;


public class FenetreAuthentification {
	
	public FenetreAuthentification(){
		
	}
	
	public  Scene showWindow() {
		FXMLLoader loader = new FXMLLoader();
		ControllerAuthentification ca=new ControllerAuthentification();
		loader.setLocation(Main.class.getResource("../controlleur/AuthentificationFXML.fxml"));
		Scene scene = null;
		try {
			//Nous récupérons notre conteneur qui contiendra les données
			//Pour rappel, c'est un AnchorPane...
			AnchorPane conteneurPersonne = (AnchorPane) loader.load();
			scene = new Scene(conteneurPersonne);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return scene;
	}


}
