package modele;

import java.time.LocalDate;

public class Individu {
	private String nom;
	private String prenom;
	private char genre;
	private Adresse adresse;
	private String lieuNaissance;
	private LocalDate datedenaissance;
	private String numTel;
	private String email;
	
	public Individu(String nom, String prenom, char genre, Adresse adresse, String lieuNaissance,
			LocalDate datedenaissance, String numTel, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.adresse = adresse;
		this.lieuNaissance = lieuNaissance;
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
	public char getGenre() {
		return genre;
	}
	public void setGenre(char genre) {
		this.genre = genre;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
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
	
	
	
}
