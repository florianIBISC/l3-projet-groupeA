package bd.controlleur;

import java.sql.ResultSet;
import java.time.LocalDate;
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
			PreparedStatement state2 = (PreparedStatement) conn.prepareStatement("SELECT * FROM administrateur");
			//On �x�cute les requ�tes sql
			ResultSet res = state.executeQuery();		
			ResultSet res2= state2.executeQuery();
			//On va r�cup�rer tous les comptes de la base de donn�es et les rentrer dans notre ArrayList
			
			while(res.next()) {
				System.out.print("erreur ou pas ?");
				String login = res.getString("login");
				int numSecu = res.getInt("numSecu");
				String passwd = res.getString("mdp");
				Compte temp = new Compte(login,numSecu,passwd);
				ChargementDonnees.getCompteCharg�s().add(temp);
			}
			
			while(res2.next()) {
				int numSecu= res2.getInt("numSecu");
				String nom=res2.getString("Nom");
				String prenom=res2.getString("Prenom");
				char genre= res2.getString("genre").charAt(0);
				String adresse=res2.getString("adresse");
				String numTel=res2.getString("numTel");
				String lieudenaissance=res2.getString("lieuNaissance");
				LocalDate dateNaiss=res2.getDate("dateNaissance").toLocalDate();
				String email=res2.getString("email");
				
				Agent agent = new Agent(numSecu, nom, prenom, genre, adresse,lieudenaissance, dateNaiss,numTel, email);
				agentEnregistr�s.add(agent);
				
				
			}
			
			res.close();
			state.close();
			//conn.close();
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

