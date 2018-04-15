package modele;

import java.time.LocalDate;

public class Agent extends Individu {
	private int numeroSecuritÚSociale;
	
	
	public Agent(int numeroSecuritÚSociale,String nom, String prenom, char genre, String adresse, String lieuNaissance,
			LocalDate datedenaissance, String numTel, String email) {
		super(nom, prenom, genre, adresse, lieuNaissance, datedenaissance, numTel, email);
		this.numeroSecuritÚSociale = numeroSecuritÚSociale;
	}
	
	public int getNumeroSecuritÚSociale() {
		return numeroSecuritÚSociale;
	}
	public void setNumeroSecuritÚSociale(int numeroSecuritÚSociale) {
		this.numeroSecuritÚSociale = numeroSecuritÚSociale;
	}
}
