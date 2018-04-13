package modele;

public class Compte {

	private String login;
	private String mdp;
	//Clé étrangère avec la classe agents
	private int numéroSecu;
	
	//Nombre de tentative au compte
	private int nbr_tentative;
	
	//Permets de définir l'id unique du compte
	//Pour les nouveaux comptes
	private static int nbr_compte=0;
	
	
	//Constructeur pour les comptes récupéré de la BDD, donc les comptes déjà existants
	public Compte(String login, int numeroSecu, String mdp) {
		super();
		this.login = login;
		nbr_compte++;
		this.numéroSecu = numeroSecu;
		this.mdp = mdp;
		this.nbr_tentative=3;
	}
	//Constructeur pour les nouveaux comptes
	/*public Compte(String login,int numéroSecu, String mdp) {
		super();
		this.login = login;
		nbr_compte++;
		this.numéroSecu = numéroSecu;
		this.mdp = mdp;
		this.nbr_tentative=3;
	}*/
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getnuméroSecu() {
		return numéroSecu;
	}
	public void setId(int numéroSecu) {
		this.numéroSecu = numéroSecu;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public static int getNbr_compte() {
		return nbr_compte;
	}
	public int getNbr_tentative() {
		return nbr_tentative;
	}
	public void setNbr_tentative(int nbr_tentative) {
		this.nbr_tentative = (nbr_tentative>=0)? nbr_tentative:0;
	}
	
	
}
