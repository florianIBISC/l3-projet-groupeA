package modele;

import java.time.LocalDate;

public class Agent extends Individu {
	private int numeroSecuritéSociale;
	
	
	public Agent(int id, String nom, String prenom, char genre, Adresse adresse, String lieuNaissance,
			LocalDate datedenaissance, String numTel, String email, int numeroSecuritéSociale) {
		super(id, nom, prenom, genre, adresse, lieuNaissance, datedenaissance, numTel, email);
		this.numeroSecuritéSociale = numeroSecuritéSociale;
	}
	
	public int getNumeroSecuritéSociale() {
		return numeroSecuritéSociale;
	}
	public void setNumeroSecuritéSociale(int numeroSecuritéSociale) {
		this.numeroSecuritéSociale = numeroSecuritéSociale;
	}
}
