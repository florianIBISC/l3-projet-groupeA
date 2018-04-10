package controlleur;

public interface IControllerAuthentification {
	public boolean id_correct(String id);
	public boolean mdp_correct(String mdp);
	public boolean compte_bloque();
	//D�cremente le nombre de tentative possible de d�verouillage du compte
	public void decrementerNbrTentative();
	
}
