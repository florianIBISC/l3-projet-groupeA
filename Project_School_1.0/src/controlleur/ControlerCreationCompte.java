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
	private TextField s�cu;
	
	@FXML
	private TextField loginCreationcompte;
	
	@FXML
	private TextField mdpCreationcompte;
	
	public ControlerCreationCompte(){
		this.agents=ChargementDonnees.getAgentEnregistr�s();
	}
	
	public void creationCompte(ActionEvent event){
		int numSecu = Integer.parseInt(s�cu.getText());
		String login = loginCreationcompte.getText();
		String mdp= mdpCreationcompte.getText();
		
		if(verifsiagentexiste(numSecu)){
			Compte newCompte= new Compte(login,numSecu,mdp);
			//ajout du compte dans la base de donn�e
			Connection conn=connexionDAOMySQL.getInstance();
			try{
				PreparedStatement ps=conn.prepareStatement("Insert into compte values(?,?,?)");
				ps.setString(1, newCompte.getLogin());
				ps.setInt(2, newCompte.getnum�roSecu());
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
			if(this.agents.get(i).getNumeroSecurit�Sociale() == numSecu){
				return true;
			}
		}
		return false;
	}
	

}
