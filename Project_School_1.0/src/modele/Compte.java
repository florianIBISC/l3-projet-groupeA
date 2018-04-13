package modele;

public class Compte {

	private String login;
	private String mdp;
	//Cl� �trang�re avec la classe agents
	private int num�roSecu;
	
	//Nombre de tentative au compte
	private int nbr_tentative;
	
	//Permets de d�finir l'id unique du compte
	//Pour les nouveaux comptes
	private static int nbr_compte=0;
	
	
	//Constructeur pour les comptes r�cup�r� de la BDD, donc les comptes d�j� existants
	public Compte(String login, int numeroSecu, String mdp) {
		super();
		this.login = login;
		nbr_compte++;
		this.num�roSecu = numeroSecu;
		this.mdp = mdp;
		this.nbr_tentative=3;
	}
	//Constructeur pour les nouveaux comptes
	/*public Compte(String login,int num�roSecu, String mdp) {
		super();
		this.login = login;
		nbr_compte++;
		this.num�roSecu = num�roSecu;
		this.mdp = mdp;
		this.nbr_tentative=3;
	}*/
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getnum�roSecu() {
		return num�roSecu;
	}
	public void setId(int num�roSecu) {
		this.num�roSecu = num�roSecu;
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
