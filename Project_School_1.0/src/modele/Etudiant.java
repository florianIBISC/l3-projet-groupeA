package modele;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Etudiant {
	private StringProperty id;
	private StringProperty prenom;
	private StringProperty nom;
	private StringProperty email;
	private StringProperty telephone;
	private StringProperty date;
	
	public Etudiant(String id, String prenom, String nom, String email,
			String telephone, String date) {
		super();
		this.id = new SimpleStringProperty(id);
		this.prenom = new SimpleStringProperty(prenom);
		this.nom = new SimpleStringProperty(nom);
		this.email = new SimpleStringProperty(email);
		this.telephone = new SimpleStringProperty(telephone);
		this.date = new SimpleStringProperty(date);
	}

	public StringProperty getIdProperty() {
		return id;
	}
	
	public 	String getId() {
		return this.id.get();
	}

	public void setId(StringProperty id) {
		this.id = id;
	}

	public StringProperty getPrenomProperty() {
		return prenom;
	}
	public String getPrenom() {
		return this.prenom.get();
	}

	public void setPrenom(StringProperty prenom) {
		this.prenom = prenom;
	}

	public StringProperty getNomProperty() {
		return nom;
	}

	public String getNom() {
		return this.nom.get();
	}
	public void setNom(StringProperty nom) {
		this.nom = nom;
	}

	public StringProperty getEmailProperty() {
		return email;
	}
	
	public String getEmail() {
		return this.email.get();
	}

	public void setEmail(StringProperty email) {
		this.email = email;
	}

	public StringProperty getTelephoneProperty() {
		return telephone;
	}
	public String getTelephone() {
		return this.telephone.get();
	}

	public void setTelephone(StringProperty telephone) {
		this.telephone = telephone;
	}

	public StringProperty getDateProperty() {
		return date;
	}
	public String getDate() {
		return this.date.get();
	}

	public void setDate(StringProperty date) {
		this.date = date;
	}

}
