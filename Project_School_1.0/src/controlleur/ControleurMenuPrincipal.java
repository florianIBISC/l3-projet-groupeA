package controlleur;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControleurMenuPrincipal {
	@FXML
	Button buttonGestionEtudiant;
	public void gestionEtudiant(){
		Stage gestionEtudiant = (Stage) buttonGestionEtudiant.getScene().getWindow();
		try {
			// Localisation du fichier FXML.
			final URL url = getClass().getClassLoader().getResource("vue/GestionEtudiant.fxml");

			// Création du loader.
			final FXMLLoader fxmlLoader = new FXMLLoader(url);

			// Chargement du FXML.
			final AnchorPane root = (AnchorPane) fxmlLoader.load();

			// Création de la scène.
			final Scene scene = new Scene(root,785,554);
			gestionEtudiant.setScene(scene);
			gestionEtudiant.show();
		} catch (IOException ex) {
			System.err.println("Erreur au chargement: " + ex);
		}
	}
	
	public void gestionGroupe(){
		Stage gestionGroupe = (Stage) buttonGestionEtudiant.getScene().getWindow();
		try {
			// Localisation du fichier FXML.
			final URL url = getClass().getClassLoader().getResource("vue/GestionGroupe.fxml");

			// Création du loader.
			final FXMLLoader fxmlLoader = new FXMLLoader(url);

			// Chargement du FXML.
			final AnchorPane root = (AnchorPane) fxmlLoader.load();

			// Création de la scène.
			final Scene scene = new Scene(root,750,600);
			gestionGroupe.setScene(scene);
			gestionGroupe.show();
		} catch (IOException ex) {
			System.err.println("Erreur au chargement: " + ex);
		}
	}
}
