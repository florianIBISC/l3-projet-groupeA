package controlleur;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import bd.controlleur.ChargementDonnees;
import bd.controlleur.EtudianBD;
import connexionBD.connexionDAOMySQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
	
	private Connection conn;
	private ObservableList<Etudiant> data;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
	}
	
	
	@FXML
	private void chargerDonnees(ActionEvent e) {
		System.out.print("chargement données");
		try {
			
			this.data = FXCollections.observableArrayList();
			this.data=ChargementDonnees.getEtudiantEnregistrés();
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
		Etudiant newEtudiant = new Etudiant(this.id.getText(),this.prenom.getText(),this.nom.getText(),this.email.getText(),this.telephone.getText(),this.date.getEditor().getText());
		EtudianBD et= new EtudianBD();
		et.ajoutEtudiant(newEtudiant);
				/*String sql = "INSERT INTO etudiant (idEtudiant,nom,prenom,dateNaissance,email,numTel) VALUES (?,?,?,?,?,?)";
		try {
			Connection conn = connexionDAOMySQL.getInstance();
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, Integer.parseInt(this.id.getText()));
			state.setString(2, this.prenom.getText());
			state.setString(3, this.nom.getText());
			state.setString(4, this.email.getText());
			state.setString(5, this.telephone.getText());
			state.setString(6, this.date.getEditor().getText());
			state.executeUpdate();
			
			state.close();
			conn.close();

			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}*/
	}

}
