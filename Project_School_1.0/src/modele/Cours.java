package modele;

public class Cours {
	private int idCours;
	private Matiere matiere;
	private Salle salle;
	private int volumeHoraire;
	private Enseignant enseignant;
	private SessionSchool sessionducours;
	//Ajout de la liste des groupes 
	private Groupe[] groupe;
	
	
	public Cours(int idCours, Matiere matiere, Salle salle, int volumeHoraire, Enseignant enseignant,
			SessionSchool sessionducours, Groupe[] groupe) {
		super();
		this.idCours = idCours;
		this.matiere = matiere;
		this.salle = salle;
		this.volumeHoraire = volumeHoraire;
		this.enseignant = enseignant;
		this.sessionducours = sessionducours;
		this.groupe = groupe;
	}
	public int getIdCours() {
		return idCours;
	}
	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public int getVolumeHoraire() {
		return volumeHoraire;
	}
	public void setVolumeHoraire(int volumeHoraire) {
		this.volumeHoraire = volumeHoraire;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public SessionSchool getSessionducours() {
		return sessionducours;
	}
	public void setSessionducours(SessionSchool sessionducours) {
		this.sessionducours = sessionducours;
	}
	public Groupe[] getGroupe() {
		return groupe;
	}
	public void setGroupe(Groupe[] groupe) {
		this.groupe = groupe;
	}
	
}
