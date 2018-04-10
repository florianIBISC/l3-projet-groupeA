package controlleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modele.Compte;
import connexionBD.*;
//Va récupérer toutes les données de la base de données pour les redistribuer
//Aux autres classes controller
public class ControllerGeneral {
	ArrayList<Compte> compte;

	public ControllerGeneral(ArrayList<Compte> compte) {
		super();
		try {
			//Commençons par récupérer les données des comptes pour les authentifications
			//On se connecte à notre BDD
			Connection conn = connexionDAOPostegresql.getConnection();
			
			//On récupère les données de la BDD pour en faire des objets
			PreparedStatement state = conn.prepareStatement("SELECT * FROM compte");
			
			//On éxécute la requête SQL
			ResultSet res = state.executeQuery();
			
			//On va récupérer tous les comptes de la base de données et les rentrer dans notre ArrayList
			while(res.next()) {
				//Compte(String login, int id, String mdp)
				String login = res.getString("login");
				int id = res.getInt("idCompte");
				String mdp = res.getString("mdp");
				Compte temp = new Compte(login,id,mdp);
				this.compte.add(temp);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
