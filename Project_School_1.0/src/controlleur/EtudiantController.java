package controlleur;

import java.net.URL;
import java.util.ResourceBundle;
import bd.controlleur.EtudianBD;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import modele.Etudiant;

public class EtudiantController implements Initializable{

	@FXML
	private TextField nom;
	@FXML
	private TextField prenom;
	@FXML
	private TextField email;	
	@FXML
	private TextField telephone;	
	@FXML
	private ComboBox<Matiere> matiere;
	@FXML
	private DatePicker date;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.matiere.setItems(FXCollections.observableArrayList(Matiere.values()));
	}
	
	
	@FXML
	private void ajoutEtudiant(ActionEvent e) {
		try {
			Etudiant newEtudiant =new Etudiant(new Integer((int)(Math.random() * ((10000) + 1))).toString(),this.prenom.getText(),this.nom.getText(),this.email.getText(),this.telephone.getText(),this.date.getEditor().getText(),this.matiere.getValue().toString());
			EtudianBD etbd= new EtudianBD();
			etbd.ajoutEtudiant(newEtudiant);

		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			Alert probleme = new Alert(AlertType.ERROR);
			probleme.setTitle("Inscription validé");
			probleme.setHeaderText("Votre inscription est maintenant valider, nous reviendrons vers vous dans les plus bref délai");
			probleme.showAndWait();
			System.exit(1);
		}
	}
}
