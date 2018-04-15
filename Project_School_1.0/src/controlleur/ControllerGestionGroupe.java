package controlleur;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ControllerGestionGroupe implements Initializable{
	@FXML
	private TextField idGroupe;
	
	@FXML
	private TextField capacite;
	
	@FXML
	private ComboBox<optionSession> comboSession;
	
	
	public void voirEtudiants(){
		System.out.println("test");
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.comboSession.setItems(FXCollections.observableArrayList(optionSession.values()));
		
	}
}
