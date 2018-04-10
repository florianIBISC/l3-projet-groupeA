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
	private boolean inscris;

	public Inscription(int idInscription, LocalDate dateInscription, LocalDate dateAbandon, Matiere[] matiere,
			SessionSchool[] sessionSchool, Groupe[] groupe, boolean inscris) {
		super();
		this.idInscription = idInscription;
		this.dateInscription = dateInscription;
		this.dateAbandon = dateAbandon;
		this.matiere = matiere;
		this.sessionSchool = sessionSchool;
		this.groupe = groupe;
		this.inscris = inscris;
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

	public boolean getInscris() {
		return inscris;
	}

	public void setInscris(boolean inscris) {
		this.inscris = inscris;
	}
	
	
	
}
