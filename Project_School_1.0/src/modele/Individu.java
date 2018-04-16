package modele;

import java.time.LocalDate;

public class Individu {
	private String nom;
	private String prenom;
	private String adresse;
	private LocalDate datedenaissance;
	private String numTel;
	private String email;
	
	public Individu(String nom, String prenom, char genre,String adresse,String lieuNaissance,
			LocalDate datedenaissance, String numTel, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.setAdresse(adresse);
		this.datedenaissance = datedenaissance;
		this.numTel = numTel;
		this.email = email;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDatedenaissance() {
		return datedenaissance;
	}
	public void setDatedenaissance(LocalDate datedenaissance) {
		this.datedenaissance = datedenaissance;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
