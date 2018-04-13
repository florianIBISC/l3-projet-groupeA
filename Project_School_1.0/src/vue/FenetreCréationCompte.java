package vue;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class FenetreCréationCompte {
	
	public  Scene showWindow() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../controlleur/CreationCompte.fxml"));
		Scene scene = null;
		try {
			//Nous récupérons notre conteneur qui contiendra les données
			//Pour rappel, c'est un AnchorPane...
			AnchorPane conteneur = (AnchorPane) loader.load();
			scene = new Scene(conteneur);
			return scene;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return scene;
	}
}
