package modele;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Groupe {

	private StringProperty idGroupe;
	private ArrayList<Etudiant> listeEtudiant=new ArrayList<Etudiant>();
	private StringProperty capacite;
	private StringProperty matiere;
	
	
	
	public Groupe(String idGroupe, ArrayList<Etudiant> listeEtudiant, String capacite, 
			String matiere) {
		super();
		this.idGroupe = new SimpleStringProperty(idGroupe);
		this.listeEtudiant = listeEtudiant;
		this.capacite = new SimpleStringProperty(capacite);
		this.matiere = new SimpleStringProperty(matiere);
	}
	
	public Groupe(String idGroupe, String capacite, 
			String matiere) {
		super();
		this.idGroupe = new SimpleStringProperty(idGroupe);
		this.capacite = new SimpleStringProperty(capacite);
		this.matiere = new SimpleStringProperty(matiere);
	}
	
	public String getIdGroupe() {
		return idGroupe.get();
	}
	
	public StringProperty getIdGroupeProperty() {
		return idGroupe;
	}
	
	public void setIdGroupe(StringProperty idGroupe) {
		this.idGroupe = idGroupe;
	}

	public ArrayList<Etudiant> getListeEtudiant() {
		return listeEtudiant;
	}
	public void setListeEtudiant(ArrayList<Etudiant> listeEtudiant) {
		this.listeEtudiant = listeEtudiant;
	}
	public String getCapacite() {
		return capacite.get();
	}
	public void setCapacite(StringProperty capacite) {
		this.capacite = capacite;
	}
	public String getMatiere() {
		return matiere.get();
	}
	public void setMatiere(StringProperty matiere) {
		this.matiere = matiere;
	}

}
