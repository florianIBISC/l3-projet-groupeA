package modele;

import java.time.LocalDate;

public class Enseignant extends Agent{
	private Cours[] cours;
	private Matiere[] matiere;
	
	
	public Enseignant(int id, String nom, String prenom, char genre, Adresse adresse, String lieuNaissance,
			LocalDate datedenaissance, String numTel, String email,int numeroSecurit�Sociale) {
		super(id, nom, prenom, genre, adresse, lieuNaissance, datedenaissance, numTel, email,numeroSecurit�Sociale);
		// TODO Auto-generated constructor stub
	}

	

	public Enseignant(int id, String nom, String prenom, char genre, Adresse adresse, String lieuNaissance,
			LocalDate datedenaissance, String numTel, String email, int numeroSecurit�Sociale, Cours[] cours,
			Matiere[] matiere) {
		super(id, nom, prenom, genre, adresse, lieuNaissance, datedenaissance, numTel, email, numeroSecurit�Sociale);
		this.cours = cours;
		this.matiere = matiere;
	}



	public Cours[] getCours() {
		return cours;
	}

	public void setCours(Cours[] cours) {
		this.cours = cours;
	}

	public Matiere[] getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere[] matiere) {
		this.matiere = matiere;
	}
	
}
