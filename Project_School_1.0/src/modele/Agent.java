package modele;

import java.time.LocalDate;

public class Agent extends Individu {
	private int numeroSecuritÚSociale;
	
	
	public Agent(int id, String nom, String prenom, char genre, Adresse adresse, String lieuNaissance,
			LocalDate datedenaissance, String numTel, String email, int numeroSecuritÚSociale) {
		super(id, nom, prenom, genre, adresse, lieuNaissance, datedenaissance, numTel, email);
		this.numeroSecuritÚSociale = numeroSecuritÚSociale;
	}
	
	public int getNumeroSecuritÚSociale() {
		return numeroSecuritÚSociale;
	}
	public void setNumeroSecuritÚSociale(int numeroSecuritÚSociale) {
		this.numeroSecuritÚSociale = numeroSecuritÚSociale;
	}
}
