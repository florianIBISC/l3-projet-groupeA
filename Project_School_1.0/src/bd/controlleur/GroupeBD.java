package bd.controlleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connexionBD.connexionDAOMySQL;
import modele.Groupe;

public class GroupeBD {

	public boolean ajoutGroupeBD(Groupe grp){
		//ajout du compte dans la base de donnée
		Connection conn=connexionDAOMySQL.getInstance();
		try{
			PreparedStatement ps=conn.prepareStatement("Insert into groupe values(?,?,?)");
			ps.setInt(1, Integer.parseInt(grp.getIdGroupe()));
			ps.setInt(2, Integer.parseInt(grp.getCapacite()));
			ps.setString(3, grp.getMatiere());
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
