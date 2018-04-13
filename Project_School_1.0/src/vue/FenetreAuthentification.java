package vue;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;;


public class FenetreAuthentification {

	public  Scene showWindow() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../controlleur/AuthentificationFXML.fxml"));
		Scene scene = null;
		try {
			//Nous r�cup�rons notre conteneur qui contiendra les donn�es
			//Pour rappel, c'est un AnchorPane...
			AnchorPane conteneurPersonne = (AnchorPane) loader.load();
			scene = new Scene(conteneurPersonne);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return scene;
	}


}
