package bd.controlleur;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import connexionBD.connexionDAOMySQL;
import modele.*;
//classe qui charge toutes les données de la base de données et les ajoute dans des ArrayList 
//qu'on pourra récuperer en temps voulu

public class ChargementDonnees {
	private static ArrayList<Compte> compteChargés=new ArrayList<Compte>();
	private static ArrayList<Agent> agentEnregistrés = new ArrayList<Agent>();
	
	public ChargementDonnees(){
		try {
			//On récupère une connexion à la BDD
			Connection conn= (Connection) connexionDAOMySQL.getInstance();
			//On va récupérer les données de la BDD pour en faire de nouveaux objets
			PreparedStatement state = (PreparedStatement) conn.prepareStatement("SELECT * FROM compte");
			PreparedStatement state2 = (PreparedStatement) conn.prepareStatement("SELECT * FROM secretaire");
			//On éxécute les requêtes sql
			ResultSet res = state.executeQuery();		
			ResultSet res2= state2.executeQuery();
			//On va récupérer tous les comptes de la base de données et les rentrer dans notre ArrayList
			while(res.next()) {
				String login = res.getString("login");
				int numSecu = res.getInt("numeroSecu");
				String passwd = res.getString("mdp");
				Compte temp = new Compte(login,numSecu,passwd);
				ChargementDonnees.getCompteChargés().add(temp);
			}
			
			while(res2.next()) {
				int numSecu= res2.getInt("numSecu");
			}
			
			res.close();
			state.close();
			conn.close();
			}catch(Exception e){
				System.out.print("erreur chargement de données");
				e.printStackTrace();
			}
	}


	public static ArrayList<Compte> getCompteChargés() {
		return compteChargés;
	}


	public static void setCompteChargés(ArrayList<Compte> compteChargés) {
		ChargementDonnees.compteChargés = compteChargés;
	}


	public static ArrayList<Agent> getAgentEnregistrés() {
		return agentEnregistrés;
	}


	public static void setAgentEnregistrés(ArrayList<Agent> agentEnregistrés) {
		ChargementDonnees.agentEnregistrés = agentEnregistrés;
	}
	
	
}

