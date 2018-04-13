package controlleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import bd.controlleur.ChargementDonnees;
import connexionBD.connexionDAOMySQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import metier.Connexion;
import modele.Agent;
import modele.Compte;

public class ControlerCreationCompte {
	private ArrayList<Agent> agents= new ArrayList<Agent>();
	
	@FXML
	private TextField sécu;
	
	@FXML
	private TextField loginCreationcompte;
	
	@FXML
	private TextField mdpCreationcompte;
	
	public ControlerCreationCompte(){
		this.agents=ChargementDonnees.getAgentEnregistrés();
	}
	
	public void creationCompte(ActionEvent event){
		int numSecu = Integer.parseInt(sécu.getText());
		String login = loginCreationcompte.getText();
		String mdp= mdpCreationcompte.getText();
		
		if(verifsiagentexiste(numSecu)){
			Compte newCompte= new Compte(login,numSecu,mdp);
			//ajout du compte dans la base de donnée
			Connection conn=connexionDAOMySQL.getInstance();
			try{
				PreparedStatement ps=conn.prepareStatement("Insert into compte values(?,?,?)");
				ps.setString(1, newCompte.getLogin());
				ps.setInt(2, newCompte.getnuméroSecu());
				ps.setString(3, newCompte.getMdp());
				ps.executeUpdate();
				ps.close();
			}catch(Exception e){
				System.out.print("impossible d'ajouter un compte");
				e.printStackTrace();
			}
		}
	}
	
	public void annulerCreationCompte(ActionEvent event2){
		
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
