package controlleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bd.controlleur.ChargementDonnees;
import bd.controlleur.EtudianBD;
import bd.controlleur.GroupeBD;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modele.Etudiant;
import modele.Groupe;

public class ControllerGestionGroupe implements Initializable{
	
	@FXML
	private TextField idGroupe;
	
	@FXML
	private TextField capacite;
	@FXML
	private TableView<Groupe> groupeTable;
	
	@FXML
	private TableView<Etudiant> etudiantenattente;
	
	@FXML
	private ComboBox<Matiere> comboMatiere;
	
	@FXML
	private TableColumn<Groupe,String> idColumn;
	
	@FXML
	private TableColumn<Groupe,String> columnCapacite;
	@FXML
	private TableColumn<Groupe,String> nbEtudiantColumn;
	@FXML
	private TableColumn<Groupe,String> matiereColumn;
	
	@FXML
	private TableColumn<Etudiant,String> id;
	@FXML
	private TableColumn<Etudiant,String> matiere;
	
	@FXML
	private TableColumn<Etudiant,String> nom;
	
	@FXML
	private Button retour;
	
	private ObservableList<Groupe> data;
	private ObservableList<Etudiant> data2;
	
	//@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		this.comboMatiere.setItems(FXCollections.observableArrayList(Matiere.values()));
	}
	
	
	public void retour(){
		Stage menuPrincipal = (Stage) retour.getScene().getWindow();
		try {
			// Localisation du fichier FXML.
			final URL url = getClass().getClassLoader().getResource("vue/MenuPrincipal.fxml");

			// CrÃ©ation du loader.
			final FXMLLoader fxmlLoader = new FXMLLoader(url);

			// Chargement du FXML.
			final AnchorPane root = (AnchorPane) fxmlLoader.load();

			// CrÃ©ation de la scÃ¨ne.
			final Scene scene = new Scene(root,785,554);
			menuPrincipal.setScene(scene);
			menuPrincipal.show();
		} catch (IOException ex) {
			System.err.println("Erreur au chargement: " + ex);
		}
	}
	
	public void ajouterGroupe(ActionEvent e){
		String idGroupe=this.idGroupe.getText();
		String capacite=this.capacite.getText();
		String matiere=this.comboMatiere.getValue().toString();
		Groupe newGroupe=new Groupe(idGroupe,capacite,matiere);
		GroupeBD gbd=new GroupeBD();
		if(gbd.ajoutGroupeBD(newGroupe)){
			Alert probleme = new Alert(AlertType.ERROR);
			probleme.setTitle("Groupe ajouté avec succés");
			probleme.setHeaderText("Succès");
			probleme.showAndWait();
		}
	}
	public void chargerDonnees(ActionEvent e){
		try {
			
			this.data = FXCollections.observableArrayList();
			this.data=ChargementDonnees.getGroupeEnregistrés();
		}catch(Exception ex) {
			ex.printStackTrace();

		}
		this.idColumn.setCellValueFactory(new PropertyValueFactory<Groupe,String>("idGroupe"));
		this.columnCapacite.setCellValueFactory(new PropertyValueFactory<Groupe,String>("capacite"));
		this.matiereColumn.setCellValueFactory(new PropertyValueFactory<Groupe,String>("matiere"));
		this.groupeTable.setItems(this.data);
	}
	
	
	public void chargerEtudiant(ActionEvent e){
		ObservableList<Etudiant> etudiantnoninscrit= FXCollections.observableArrayList();
		for(int i=0;i<ChargementDonnees.getEtudiantEnregistrés().size();i++){
			if(ChargementDonnees.getEtudiantEnregistrés().get(i).getGroupe().equals("null"))
				etudiantnoninscrit.add(ChargementDonnees.getEtudiantEnregistrés().get(i));
		}
		try {	
			this.data2 = FXCollections.observableArrayList();
			this.data2=etudiantnoninscrit;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		try{
			this.id.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
			this.nom.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());
			this.matiere.setCellValueFactory(cellData -> cellData.getValue().getMatiereProperty());
			this.etudiantenattente.setItems(this.data2);
		}catch(Exception e1){
			System.out.print("erreur icii");
			e1.getMessage();
		}
	}

	@FXML
	public void affecterGroupe(ActionEvent e){
		int selectedGroupe = groupeTable.getSelectionModel().getSelectedIndex();
		StringProperty idgroupeselectionné=groupeTable.getItems().get(selectedGroupe).getIdGroupeProperty();
		int selectedEtudiant = etudiantenattente.getSelectionModel().getSelectedIndex();
		System.out.println((groupeTable.getItems().get(selectedGroupe).getMatiere()));
		System.out.println(etudiantenattente.getItems().get(selectedEtudiant).getMatiere());
		if(!groupeTable.getItems().get(selectedGroupe).getMatiere().equals(etudiantenattente.getItems().get(selectedEtudiant).getMatiere())){
			Alert probleme = new Alert(AlertType.ERROR);
			probleme.setTitle("Echec");
			probleme.setHeaderText("La matière choisie par l'étudiant est différente du groupe !");
			probleme.showAndWait();
			return;
		}
		etudiantenattente.getItems().get(selectedEtudiant).setGroupe(idgroupeselectionné);
		
		EtudianBD ebd=new EtudianBD();
		if(ebd.majGroupe(etudiantenattente.getItems().get(selectedEtudiant))){
			Alert probleme = new Alert(AlertType.ERROR);
			probleme.setTitle("Succès");
			probleme.setHeaderText("Etudiant affecté avec succès !");
			probleme.showAndWait();
		};
		
	}
	

}
