package bd.controlleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connexionBD.connexionDAOMySQL;
import modele.Etudiant;

public class EtudianBD {
	
	//fonction qui permet d'ajouter un nouvel etudiant dans la base de donnés
	
	public void ajoutEtudiant(Etudiant e) {
		String sql = "INSERT INTO etudiant (idEtudiant,prenom,nom,email,numTel,dateNaissance,matiere,idGroupe) VALUES (?,?,?,?,?,?,?,?)";
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
			state.setString(8,"null");
			state.executeUpdate();
			
			state.close();
			conn.close();

			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//fonction qui met à jour le groupe de l'etudiant lorsqu'il a été affecté
	public boolean majGroupe(Etudiant etudiant) {
		String sql = "UPDATE etudiant SET idGroupe=? WHERE idEtudiant = ?;";
		try {
			Connection conn = connexionDAOMySQL.getInstance();
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, etudiant.getGroupe());
			state.setString(2, etudiant.getId());

			state.executeUpdate();
			state.close();
			conn.close();

			return true;
			
		}catch(SQLException ex) {
			ex.printStackTrace();

			return false;
		}

	}
}
