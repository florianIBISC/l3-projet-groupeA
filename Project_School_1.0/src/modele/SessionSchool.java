package modele;

import java.time.LocalDate;
import java.util.ArrayList;

public class SessionSchool {
	private int idSession;
	private LocalDate dateDebutSession;
	private LocalDate dateFinSession;
	//N'a pas besoin de figurer dans le constructeur, sera la différence des dates de début et de fin
	private int duree;
	private ArrayList<Groupe> groupes;
	//Le type de session on le fait en string ou en énumération ? 
	private String typeSession;
	
	
	
	public SessionSchool(int idSession, LocalDate dateDebutSession, LocalDate dateFinSession, int duree,
			ArrayList<Groupe> groupes, String typeSession) {
		super();
		this.idSession = idSession;
		this.dateDebutSession = dateDebutSession;
		this.dateFinSession = dateFinSession;
		this.duree = duree;
		this.groupes = groupes;
		this.typeSession = typeSession;
	}
	
	
	public int getIdSession() {
		return idSession;
	}
	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}
	public LocalDate getDateDebutSession() {
		return dateDebutSession;
	}
	public void setDateDebutSession(LocalDate dateDebutSession) {
		this.dateDebutSession = dateDebutSession;
	}
	public LocalDate getDateFinSession() {
		return dateFinSession;
	}
	public void setDateFinSession(LocalDate dateFinSession) {
		this.dateFinSession = dateFinSession;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public ArrayList<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(ArrayList<Groupe> groupes) {
		this.groupes = groupes;
	}
	public String getTypeSession() {
		return typeSession;
	}
	public void setTypeSession(String typeSession) {
		this.typeSession = typeSession;
	}
	
}
