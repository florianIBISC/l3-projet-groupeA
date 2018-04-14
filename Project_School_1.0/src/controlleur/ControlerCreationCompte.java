package controlleur;

import java.util.ArrayList;

import bd.controlleur.ChargementDonnees;
import bd.controlleur.compteBD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Agent;
import modele.Compte;

public class ControlerCreationCompte {
	private ArrayList<Agent> agents= new ArrayList<Agent>();
	@FXML
	private TextField sécu;
	
	@FXML
	private Label statutajoutcompte;
	
	@FXML
	private TextField loginCreationcompte;
	
	@FXML
	private TextField mdpCreationcompte;
	
	@FXML 
	private Button closeButton;
	
	public ControlerCreationCompte(){
		this.agents=ChargementDonnees.getAgentEnregistrés();
		System.out.print(agents.get(0).getNumeroSecuritéSociale());
	}
	
	public void creationCompte(ActionEvent event){
		int numSecu = Integer.parseInt(sécu.getText());
		String login = loginCreationcompte.getText();
		String mdp= mdpCreationcompte.getText();
		
		
		if(verifsiagentexiste(numSecu)){
			Compte newCompte= new Compte(login,numSecu,mdp);
			compteBD cbd = new compteBD();
			if(cbd.ajouterCompte(newCompte)){
				statutajoutcompte.setText("Compte ajouté avec succès !");
			}
		}
	}
	
	public void annulerCreationCompte(ActionEvent event2){
		  // get a handle to the stage
	    Stage stage = (Stage) closeButton.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	public boolean verifsiagentexiste(int numSecu){
		for(int i=0;i<this.agents.size();i++){
			if(this.agents.get(i).getNumeroSecuritéSociale() == numSecu){
				return true;
			}
		}
		return false;
	}
	

}
