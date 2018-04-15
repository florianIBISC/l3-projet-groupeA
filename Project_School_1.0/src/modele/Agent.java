package modele;

import java.time.LocalDate;

public class Agent extends Individu {
	private int numeroSecuritéSociale;
	
	
	public Agent(int numeroSecuritéSociale,String nom, String prenom, char genre, String adresse, String lieuNaissance,
			LocalDate datedenaissance, String numTel, String email) {
		super(nom, prenom, genre, adresse, lieuNaissance, datedenaissance, numTel, email);
		this.numeroSecuritéSociale = numeroSecuritéSociale;
	}
	
	public int getNumeroSecuritéSociale() {
		return numeroSecuritéSociale;
	}
	public void setNumeroSecuritéSociale(int numeroSecuritéSociale) {
		this.numeroSecuritéSociale = numeroSecuritéSociale;
	}
}
