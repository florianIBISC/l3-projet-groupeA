package controlleur;

import javafx.event.ActionEvent;

public interface IControllerAuthentification {
	public void Login(ActionEvent event);
	public boolean id_correct(String id);
	public boolean mdp_correct(String mdp);
	public boolean compte_bloque();
	//Décremente le nombre de tentative possible de déverouillage du compte
	public void decrementerNbrTentative();
	
}
