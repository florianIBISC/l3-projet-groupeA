package bd.controlleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connexionBD.connexionDAOMySQL;
import javafx.event.ActionEvent;
import modele.Etudiant;

public class EtudianBD {
	
	public void ajoutEtudiant(Etudiant e) {
		String sql = "INSERT INTO etudiant (idEtudiant,prenom,nom,email,numTel,dateNaissance,matiere) VALUES (?,?,?,?,?,?,?)";
		try {
			Connection conn = connexionDAOMySQL.getInstance();
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, e.getId());
			state.setString(2, e.getPrenom());
			state.setString(3, e.getNom());
			state.setString(4, e.getEmail());
			state.setString(5, e.getTelephone());
			state.setString(6, e.getDate());
			state.setString(7, e.getMatiere());
			state.executeUpdate();
			
			state.close();
			conn.close();

			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
