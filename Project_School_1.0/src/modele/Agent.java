package modele;

import java.time.LocalDate;

public class Agent extends Individu {
	
	public Agent(int id, String nom, String prenom, char genre, Adresse adresse, String lieuNaissance,
			LocalDate datedenaissance, String numTel, String email) {
		super(id, nom, prenom, genre, adresse, lieuNaissance, datedenaissance, numTel, email);
		// TODO Auto-generated constructor stub
	}
}
