package controlleur;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ListIterator;

import bd.controlleur.ChargementDonnees;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modele.Compte;

public class ControllerAuthentification {

	private ArrayList<Compte> compte=new ArrayList<Compte>();
	//Sert de pointeur vers le compte sÈlectionnÈ dans notre arraylist
	private int position;
	
	@FXML
	private TextField logintextfield;
	
	@FXML
	private TextField mdptextfield;
	
	@FXML
	private Label statutlabel;

	
	public ControllerAuthentification() {
		this.compte=ChargementDonnees.getCompteChargÈs();
		//this.id_correct();
	}


	public void Login(ActionEvent event){
		//on vÈrifie d'abord si le compte est bloquÈ
		if(compte_bloque()) {
			String message = " Compte bloquÈ";
			statutlabel.setText(message);
			return ;
		}
		if(id_correct()) {
			if(mdp_correct()) {
				statutlabel.setText("Login + mdp correct");
				Stage menuPrincipal = new Stage();
				try {
					// Localisation du fichier FXML.
					final URL url = getClass().getClassLoader().getResource("vue/MenuPrincipal.fxml");

					// Cr√©ation du loader.
					final FXMLLoader fxmlLoader = new FXMLLoader(url);

					// Chargement du FXML.
					final AnchorPane root = (AnchorPane) fxmlLoader.load();

					// Cr√©ation de la sc√®ne.
					final Scene scene = new Scene(root);
					menuPrincipal.setScene(scene);
					menuPrincipal.show();
				} catch (IOException ex) {
					System.err.println("Erreur au chargement: " + ex);
				}
				return ;
			}
			else {
				System.out.println("Mauvais mdp");
				String message = " Mot de passe incorrect\n Il vous reste : "+compte.get(position).getNbr_tentative()+" tentatives";
				statutlabel.setText(message);
				return ;
			}
		}
		else {
			System.out.println("Login inconnue !");
			String message = " Login inconnu";
			statutlabel.setText(message);
			return ;
		}
		
	}
	
	//fonction appelÈ pour le bouton crÈer un nouveau un compte
	public void creercompte(ActionEvent event){
		Stage creationCompteStage = new Stage();
		try {
			// Localisation du fichier FXML.
			final URL url = getClass().getClassLoader().getResource("vue/CreationCompte.fxml");

			// Cr√©ation du loader.
			final FXMLLoader fxmlLoader = new FXMLLoader(url);

			// Chargement du FXML.
			final AnchorPane root = (AnchorPane) fxmlLoader.load();

			// Cr√©ation de la sc√®ne.
			final Scene scene = new Scene(root);
			creationCompteStage.setScene(scene);
			creationCompteStage.show();
		} catch (IOException ex) {
			System.err.println("Erreur au chargement: " + ex);
		}
	}
	
	public void inscriptionEtudiant(){
		Stage creationCompteEtudiant = new Stage();
		try {
			// Localisation du fichier FXML.
			final URL url = getClass().getClassLoader().getResource("vue/EtudiantFXML.fxml");

			// Cr√©ation du loader.
			final FXMLLoader fxmlLoader = new FXMLLoader(url);

			// Chargement du FXML.
			final AnchorPane root = (AnchorPane) fxmlLoader.load();

			// Cr√©ation de la sc√®ne.
			final Scene scene = new Scene(root);
			creationCompteEtudiant.setScene(scene);
			creationCompteEtudiant.show();
		} catch (IOException ex) {
			System.err.println("Erreur au chargement: " + ex);
		}
	}
	


	public ControllerAuthentification(ArrayList<Compte> compte) {
		super();
		this.compte = compte;
		this.position=0;
	}

	public boolean id_correct() {
		int i=0;
		for(int j=0;j<this.compte.size();j++){
			System.out.print(this.compte.get(j).getLogin());
			if(this.compte.get(j).getLogin().equals(logintextfield.getText())){
				this.position=i;
				return true;
			}
			i++;
		}
		
		return false;
	}

	public boolean mdp_correct() {
		if(this.compte.get(position).getMdp().equals(mdptextfield.getText()))
			return true;
		
		return false;
	}
	
	public boolean compte_bloque() {
		if(this.compte.get(position).getNbr_tentative()<1)
			return true;
		decrementerNbrTentative();
		return false;
	}

	//Une erreur = une tentative en moins
	public void decrementerNbrTentative() {
		this.compte.get(position).setNbr_tentative(this.compte.get(position).getNbr_tentative()-1);
	}
	
}
