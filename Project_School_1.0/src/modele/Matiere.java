package modele;

public enum Matiere {

	Tamoul,Malgache,Anglais;
	
	private Matiere() {}
	
	//Retourne le type en string
	public String value() {
		return name();
	}
	
	
	//Transforme un string en objet Option
	public static Matiere fromValue(String s) {
		return valueOf(s);
	}
	
}
