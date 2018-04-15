package bd.controlleur;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import connexionBD.connexionDAOMySQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.*;
//classe qui charge toutes les données de la base de données et les ajoute dans des ArrayList 
//qu'on pourra récuperer en temps voulu

public class ChargementDonnees {
	private static ArrayList<Compte> compteChargés=new ArrayList<Compte>();
	private static ArrayList<Agent> agentEnregistrés = new ArrayList<Agent>();
	private static ObservableList<Etudiant> etudiantEnregistrés= FXCollections.observableArrayList();
	
	public ChargementDonnees(){
		try {
			//On récupère une connexion à la BDD
			Connection conn= (Connection) connexionDAOMySQL.getInstance();
			//On va récupérer les données de la BDD pour en faire de nouveaux objets
			PreparedStatement state = (PreparedStatement) conn.prepareStatement("SELECT * FROM compte");
			PreparedStatement state2 = (PreparedStatement) conn.prepareStatement("SELECT * FROM administrateur");
			PreparedStatement state3= (PreparedStatement) conn.prepareStatement("SELECT * FROM etudiant");
			//On éxécute les requêtes sql
			ResultSet res = state.executeQuery();		
			//On va récupérer tous les comptes de la base de données et les rentrer dans notre ArrayList
			
			while(res.next()) {
				System.out.println(res.getString("login")+"bd");
				System.out.println(res.getString("mdp")+"bd");
				System.out.println(res.getString("numSecu")+"bd");
				String login = res.getString("login");
				int numSecu = res.getInt("numSecu");
				String passwd = res.getString("mdp");
				Compte temp = new Compte(login,numSecu,passwd);
				System.out.println(temp.getLogin()+"class");
				System.out.println(temp.getMdp()+"class");
				ChargementDonnees.getCompteChargés().add(temp);
			}
			
			ResultSet res2= state2.executeQuery();
			//On récupere tous les agents enregistrés dans la base de données
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
				agentEnregistrés.add(agent);
	
				
			}
			
			
			ResultSet res3=state3.executeQuery();
			//on recupere tous les etudiants enregistrés dans la base de données
			while(res3.next()) {
				etudiantEnregistrés.add(new Etudiant(Integer.toString(res3.getInt(1)),res3.getString(2),res3.getString(3),res3.getString(4),"0"+res3.getString(5),res3.getString(6)));

			}

			res.close();
			res2.close();
			res3.close();
			state.close();
			state2.close();
			state3.close();
			//conn.close();
			}catch(Exception e){
				System.out.print("erreur chargement de données");
				e.printStackTrace();
			}
		for(int i=0;i<etudiantEnregistrés.size();i++){
			System.out.println(etudiantEnregistrés.get(i).getNom()+" izi money ");
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


	public static ObservableList<Etudiant> getEtudiantEnregistrés() {
		return etudiantEnregistrés;
	}


	public static void setEtudiantEnregistrés(ObservableList<Etudiant> etudiantEnregistrés) {
		ChargementDonnees.etudiantEnregistrés = etudiantEnregistrés;
	}
	
	
	
}

