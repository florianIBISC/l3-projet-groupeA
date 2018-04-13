package modele;

import java.time.LocalDate;

public class Etudiant extends Individu{
	private Groupe groupe;

	
	
	public Etudiant(String nom, String prenom, char genre, Adresse adresse, String lieuNaissance,
			LocalDate datedenaissance, String numTel, String email, Groupe groupe) {
		super(nom, prenom, genre, adresse, lieuNaissance, datedenaissance, numTel, email);
		this.groupe = groupe;
	}
	
	//Constructeur pour un étudiant qui n'a pas encore de groupe
	public Etudiant(String nom, String prenom, char genre, Adresse adresse, String lieuNaissance,
			LocalDate datedenaissance, String numTel, String email) {
		super(nom, prenom, genre, adresse, lieuNaissance, datedenaissance, numTel, email);
		this.groupe=null;
	}


	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	
}
