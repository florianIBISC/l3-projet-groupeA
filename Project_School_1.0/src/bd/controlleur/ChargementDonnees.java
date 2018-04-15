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
//classe qui charge toutes les donn�es de la base de donn�es et les ajoute dans des ArrayList 
//qu'on pourra r�cuperer en temps voulu

public class ChargementDonnees {
	private static ArrayList<Compte> compteCharg�s=new ArrayList<Compte>();
	private static ArrayList<Agent> agentEnregistr�s = new ArrayList<Agent>();
	private static ObservableList<Etudiant> etudiantEnregistr�s= FXCollections.observableArrayList();
	
	public ChargementDonnees(){
		try {
			//On r�cup�re une connexion � la BDD
			Connection conn= (Connection) connexionDAOMySQL.getInstance();
			//On va r�cup�rer les donn�es de la BDD pour en faire de nouveaux objets
			PreparedStatement state = (PreparedStatement) conn.prepareStatement("SELECT * FROM compte");
			PreparedStatement state2 = (PreparedStatement) conn.prepareStatement("SELECT * FROM administrateur");
			PreparedStatement state3= (PreparedStatement) conn.prepareStatement("SELECT * FROM etudiant");
			//On �x�cute les requ�tes sql
			ResultSet res = state.executeQuery();		
			//On va r�cup�rer tous les comptes de la base de donn�es et les rentrer dans notre ArrayList
			
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
				ChargementDonnees.getCompteCharg�s().add(temp);
			}
			
			ResultSet res2= state2.executeQuery();
			//On r�cupere tous les agents enregistr�s dans la base de donn�es
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
			
			
			ResultSet res3=state3.executeQuery();
			//on recupere tous les etudiants enregistr�s dans la base de donn�es
			while(res3.next()) {
				etudiantEnregistr�s.add(new Etudiant(Integer.toString(res3.getInt(1)),res3.getString(2),res3.getString(3),res3.getString(4),"0"+res3.getString(5),res3.getString(6)));

			}

			res.close();
			res2.close();
			res3.close();
			state.close();
			state2.close();
			state3.close();
			//conn.close();
			}catch(Exception e){
				System.out.print("erreur chargement de donn�es");
				e.printStackTrace();
			}
		for(int i=0;i<etudiantEnregistr�s.size();i++){
			System.out.println(etudiantEnregistr�s.get(i).getNom()+" izi money ");
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


	public static ObservableList<Etudiant> getEtudiantEnregistr�s() {
		return etudiantEnregistr�s;
	}


	public static void setEtudiantEnregistr�s(ObservableList<Etudiant> etudiantEnregistr�s) {
		ChargementDonnees.etudiantEnregistr�s = etudiantEnregistr�s;
	}
	
	
	
}

