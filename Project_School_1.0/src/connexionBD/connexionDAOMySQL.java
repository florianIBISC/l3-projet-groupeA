package connexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connexionDAOMySQL {
	private static String url = "jdbc:mysql://localhost:3306/projetschool1.0?autoReconnect=true&useSSL=false";
	private static String utilisateur = "root";
	private static String motDePasse = "ss489137";
	private static Connection connexion;
	
	public static Connection getInstance(){
		if(connexion==null){
			try{
				connexion=DriverManager.getConnection(url,utilisateur,motDePasse);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return connexion;
	}
}
