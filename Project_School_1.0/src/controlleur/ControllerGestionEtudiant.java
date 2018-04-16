package controlleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bd.controlleur.ChargementDonnees;
import bd.controlleur.EtudianBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modele.Etudiant;

public class ControllerGestionEtudiant implements Initializable {
	@FXML
	private TextField id;
	
	@FXML
	private TextField prenom;
	
	@FXML
	private TextField nom;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField telephone;

	@FXML
	private DatePicker date;

	@FXML
	private TableView<Etudiant> etudiantTable;
	
	@FXML
	private TableColumn<Etudiant,String> idcolumn;
	
	@FXML
	private TableColumn<Etudiant,String> prenomcolumn;
	@FXML
	private TableColumn<Etudiant,String> nomcolumn;
	@FXML
	private TableColumn<Etudiant,String> emailcolumn;
	@FXML
	private TableColumn<Etudiant,String> telephonecolumn;
	@FXML
	private TableColumn<Etudiant,String> datecolumn;
	@FXML 
	private Button retour;
	private ObservableList<Etudiant> data;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
	}
	
	public void retour(){
		Stage menuPrincipal = (Stage) retour.getScene().getWindow();
		try {
			// Localisation du fichier FXML.
			final URL url = getClass().getClassLoader().getResource("vue/MenuPrincipal.fxml");

			// Création du loader.
			final FXMLLoader fxmlLoader = new FXMLLoader(url);

			// Chargement du FXML.
			final AnchorPane root = (AnchorPane) fxmlLoader.load();

			// Création de la scène.
			final Scene scene = new Scene(root,785,554);
			menuPrincipal.setScene(scene);
			menuPrincipal.show();
		} catch (IOException ex) {
			System.err.println("Erreur au chargement: " + ex);
		}
	}
	
	@FXML
	private void chargerDonnees(ActionEvent e) {
		try {
			
			this.data = FXCollections.observableArrayList();
			this.data=ChargementDonnees.getEtudiantEnregistr�s();
			System.out.print(this.data);
		}catch(Exception ex) {
			ex.printStackTrace();

		}
		this.idcolumn.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("id"));
		this.prenomcolumn.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("prenom"));
		this.nomcolumn.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nom"));
		this.emailcolumn.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("email"));
		this.telephonecolumn.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("telephone"));
		this.datecolumn.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("date"));

		this.etudiantTable.setItems(this.data);
			
	}

	@FXML
	private void ajoutEtudiant(ActionEvent e) {
		Etudiant newEtudiant = new Etudiant(this.id.getText(),this.prenom.getText(),this.nom.getText(),this.email.getText(),this.telephone.getText(),this.date.getEditor().getText(),"matiere");
		EtudianBD et= new EtudianBD();
		et.ajoutEtudiant(newEtudiant);

	}

}
