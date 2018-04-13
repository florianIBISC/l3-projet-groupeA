package modele;

import java.time.LocalDate;

public class Agent extends Individu {
	private int numeroSecurit�Sociale;
	
	
	public Agent(int id, String nom, String prenom, char genre, Adresse adresse, String lieuNaissance,
			LocalDate datedenaissance, String numTel, String email, int numeroSecurit�Sociale) {
		super(id, nom, prenom, genre, adresse, lieuNaissance, datedenaissance, numTel, email);
		this.numeroSecurit�Sociale = numeroSecurit�Sociale;
	}
	
	public int getNumeroSecurit�Sociale() {
		return numeroSecurit�Sociale;
	}
	public void setNumeroSecurit�Sociale(int numeroSecurit�Sociale) {
		this.numeroSecurit�Sociale = numeroSecurit�Sociale;
	}
}
