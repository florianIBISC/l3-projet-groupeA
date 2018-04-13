package modele;

import java.time.LocalDate;

public class Enseignant extends Agent{
	private Cours[] cours;
	private Matiere[] matiere;
	
	
	public Enseignant(int id, String nom, String prenom, char genre, Adresse adresse, String lieuNaissance,
			LocalDate datedenaissance, String numTel, String email,int numeroSecuritÚSociale) {
		super(id, nom, prenom, genre, adresse, lieuNaissance, datedenaissance, numTel, email,numeroSecuritÚSociale);
		// TODO Auto-generated constructor stub
	}

	

	public Enseignant(int id, String nom, String prenom, char genre, Adresse adresse, String lieuNaissance,
			LocalDate datedenaissance, String numTel, String email, int numeroSecuritÚSociale, Cours[] cours,
			Matiere[] matiere) {
		super(id, nom, prenom, genre, adresse, lieuNaissance, datedenaissance, numTel, email, numeroSecuritÚSociale);
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
