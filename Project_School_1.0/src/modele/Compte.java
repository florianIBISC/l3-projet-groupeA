package modele;

public class Compte {

	private String login;
	private String mdp;
	private int id;
	//Permets d'incrémenter l'id du compte
	private static int nbr_compte=0;
	
	
	public Compte(String login, int id, String mdp) {
		super();
		this.login = login;
		nbr_compte++;
		this.id = nbr_compte;
		this.mdp = mdp;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	
	
	
	
}
