package controlleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modele.Compte;
import connexionBD.*;
//Va r�cup�rer toutes les donn�es de la base de donn�es pour les redistribuer
//Aux autres classes controller
public class ControllerGeneral {
	ArrayList<Compte> compte;

	public ControllerGeneral(ArrayList<Compte> compte) {
		super();
		try {
			//Commen�ons par r�cup�rer les donn�es des comptes pour les authentifications
			//On se connecte � notre BDD
			Connection conn = connexionDAOPostegresql.getConnection();
			
			//On r�cup�re les donn�es de la BDD pour en faire des objets
			PreparedStatement state = conn.prepareStatement("SELECT * FROM compte");
			
			//On �x�cute la requ�te SQL
			ResultSet res = state.executeQuery();
			
			//On va r�cup�rer tous les comptes de la base de donn�es et les rentrer dans notre ArrayList
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
