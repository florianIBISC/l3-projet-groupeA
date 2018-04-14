package modele;

import java.util.ArrayList;

public class Groupe {

	private int idGroupe;
	private ArrayList<Etudiant> listeEtudiant;
	private int capacite;
	private SessionSchool session;
	private Matiere[] matiere;
	
	
	public Groupe(int idGroupe, ArrayList<Etudiant> listeEtudiant, int capacite, SessionSchool session,
			Matiere[] matiere) {
		super();
		this.idGroupe = idGroupe;
		this.listeEtudiant = listeEtudiant;
		this.capacite = capacite;
		this.session = session;
		this.matiere = matiere;
	}
	
	public int getIdGroupe() {
		return idGroupe;
	}
	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}
	public ArrayList<Etudiant> getListeEtudiant() {
		return listeEtudiant;
	}
	public void setListeEtudiant(ArrayList<Etudiant> listeEtudiant) {
		this.listeEtudiant = listeEtudiant;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public SessionSchool getSession() {
		return session;
	}
	public void setSession(SessionSchool session) {
		this.session = session;
	}
	public Matiere[] getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere[] matiere) {
		this.matiere = matiere;
	}
	
}
