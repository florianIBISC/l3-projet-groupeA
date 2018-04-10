package modele;

public class Adresse {
	private int idAdresse;
	private int numRue;
	private String nomRue;
	private int CP;
	private int Arrondissement;
	private String nomVille;
	private String complementAdresse;
	
	public int getNumRue() {
		return numRue;
	}
	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}
	public String getNomRue() {
		return nomRue;
	}
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}
	public int getCP() {
		return CP;
	}
	public void setCP(int cP) {
		CP = cP;
	}
	public int getArrondissement() {
		return Arrondissement;
	}
	public void setArrondissement(int arrondissement) {
		Arrondissement = arrondissement;
	}
	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public String getComplementAdresse() {
		return complementAdresse;
	}
	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}
	
	
}
