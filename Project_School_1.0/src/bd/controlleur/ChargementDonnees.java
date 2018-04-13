package bd.controlleur;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import connexionBD.connexionDAOMySQL;
import modele.*;
//classe qui charge toutes les donn�es de la base de donn�es et les ajoute dans des ArrayList 
//qu'on pourra r�cuperer en temps voulu

public class ChargementDonnees {
	private static ArrayList<Compte> compteCharg�s=new ArrayList<Compte>();
	private static ArrayList<Agent> agentEnregistr�s = new ArrayList<Agent>();
	
	public ChargementDonnees(){
		try {
			//On r�cup�re une connexion � la BDD
			Connection conn= (Connection) connexionDAOMySQL.getInstance();
			//On va r�cup�rer les donn�es de la BDD pour en faire de nouveaux objets
			PreparedStatement state = (PreparedStatement) conn.prepareStatement("SELECT * FROM compte");
			PreparedStatement state2 = (PreparedStatement) conn.prepareStatement("SELECT * FROM secretaire");
			//On �x�cute les requ�tes sql
			ResultSet res = state.executeQuery();		
			ResultSet res2= state2.executeQuery();
			//On va r�cup�rer tous les comptes de la base de donn�es et les rentrer dans notre ArrayList
			while(res.next()) {
				String login = res.getString("login");
				int numSecu = res.getInt("numeroSecu");
				String passwd = res.getString("mdp");
				Compte temp = new Compte(login,numSecu,passwd);
				ChargementDonnees.getCompteCharg�s().add(temp);
			}
			
			while(res2.next()) {
				int numSecu= res2.getInt("numSecu");
			}
			
			res.close();
			state.close();
			conn.close();
			}catch(Exception e){
				System.out.print("erreur chargement de donn�es");
				e.printStackTrace();
			}
	}


	public static ArrayList<Compte> getCompteCharg�s() {
		return compteCharg�s;
	}


	public static void setCompteCharg�s(ArrayList<Compte> compteCharg�s) {
		ChargementDonnees.compteCharg�s = compteCharg�s;
	}


	public static ArrayList<Agent> getAgentEnregistr�s() {
		return agentEnregistr�s;
	}


	public static void setAgentEnregistr�s(ArrayList<Agent> agentEnregistr�s) {
		ChargementDonnees.agentEnregistr�s = agentEnregistr�s;
	}
	
	
}

