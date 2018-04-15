package bd.controlleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connexionBD.connexionDAOMySQL;
import modele.Compte;

public class compteBD {

	public boolean ajouterCompte(Compte newCompte) {
		//ajout du compte dans la base de donnée
		Connection conn=connexionDAOMySQL.getInstance();
		try{
			PreparedStatement ps=conn.prepareStatement("Insert into compte values(?,?,?)");
			ps.setString(1, newCompte.getLogin());
			ps.setInt(3, newCompte.getnuméroSecu());
			ps.setString(2, newCompte.getMdp());
			ps.executeUpdate();
			ps.close();
			return true;
		}catch(Exception e){
			System.out.print("impossible d'ajouter un compte");
			e.printStackTrace();
		}		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
