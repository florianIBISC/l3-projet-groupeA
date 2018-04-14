package modele;

import java.time.LocalDate;

public class Enseignant extends Agent{
	private Cours[] cours;
	
	
	public Enseignant(int numeroSecuritÚSociale,String nom, String prenom, char genre, String adresse, String lieuNaissance,
			LocalDate datedenaissance, String numTel, String email) {
		super(numeroSecuritÚSociale,nom, prenom, genre, adresse, lieuNaissance, datedenaissance, numTel, email);
		// TODO Auto-generated constructor stub
	}

	

	public Enseignant(int numeroSecuritÚSociale, String nom, String prenom, char genre, String adresse, String lieuNaissance,
			LocalDate datedenaissance, String numTel, String email,  Cours[] cours) {
		super(numeroSecuritÚSociale, nom, prenom, genre, adresse, lieuNaissance, datedenaissance, numTel, email);
		this.cours = cours;
	}



	public Cours[] getCours() {
		return cours;
	}

	public void setCours(Cours[] cours) {
		this.cours = cours;
	}

	
}
