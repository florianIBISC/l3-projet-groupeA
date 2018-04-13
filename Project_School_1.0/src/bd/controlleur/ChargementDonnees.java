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
	
	
	public ChargementDonnees(){
		try {
			//On r�cup�re une connexion � la BDD
			Connection conn= (Connection) connexionDAOMySQL.getInstance();
			//On va r�cup�rer les donn�es de la BDD pour en faire de nouveaux objets
			PreparedStatement state = (PreparedStatement) conn.prepareStatement("SELECT * FROM compte");
			
			//On �x�cute les requ�tes sql
			ResultSet res = state.executeQuery();		
			
			//On va r�cup�rer tous les comptes de la base de donn�es et les rentrer dans notre ArrayList
			while(res.next()) {
				String login = res.getString("login");
				int id = res.getInt("idCompte");
				String passwd = res.getString("mdp");
				Compte temp = new Compte(login,id,passwd);
				this.getCompteCharg�s().add(temp);
			}

			res.close();
			state.close();
			conn.close();
			}catch(Exception e){
				System.out.print("erreur chargement de donn�es");
			}
	}


	public static ArrayList<Compte> getCompteCharg�s() {
		return compteCharg�s;
	}


	public static void setCompteCharg�s(ArrayList<Compte> compteCharg�s) {
		ChargementDonnees.compteCharg�s = compteCharg�s;
	}
}

