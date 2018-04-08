package modele;

import java.time.LocalDate;

public class Inscription {
	private int idInscription;
	private LocalDate dateInscription;
	private LocalDate dateAbandon;
	
	private Matiere[] matiere;
	private SessionSchool[] sessionSchool;
	private Groupe[] groupe;

	//Pareil type string ou énuméré ?
	private String statut;

	public Inscription(int idInscription, LocalDate dateInscription, LocalDate dateAbandon, Matiere[] matiere,
			SessionSchool[] sessionSchool, Groupe[] groupe, String statut) {
		super();
		this.idInscription = idInscription;
		this.dateInscription = dateInscription;
		this.dateAbandon = dateAbandon;
		this.matiere = matiere;
		this.sessionSchool = sessionSchool;
		this.groupe = groupe;
		this.statut = statut;
	}

	public int getIdInscription() {
		return idInscription;
	}

	public void setIdInscription(int idInscription) {
		this.idInscription = idInscription;
	}

	public LocalDate getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(LocalDate dateInscription) {
		this.dateInscription = dateInscription;
	}

	public LocalDate getDateAbandon() {
		return dateAbandon;
	}

	public void setDateAbandon(LocalDate dateAbandon) {
		this.dateAbandon = dateAbandon;
	}

	public Matiere[] getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere[] matiere) {
		this.matiere = matiere;
	}

	public SessionSchool[] getSessionSchool() {
		return sessionSchool;
	}

	public void setSessionSchool(SessionSchool[] sessionSchool) {
		this.sessionSchool = sessionSchool;
	}

	public Groupe[] getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe[] groupe) {
		this.groupe = groupe;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	
	
}
