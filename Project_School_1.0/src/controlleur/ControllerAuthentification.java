package controlleur;



import java.util.ArrayList;
import java.util.ListIterator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.Compte;
import vue.*;

public class ControllerAuthentification {

	private ArrayList<Compte> compte;
	//Sert de pointeur vers le compte sélectionné dans notre arraylist
	private int position;
	@FXML
	private TextField logintextfield;
	
	@FXML
	private TextField mdptextfield;
	
	@FXML
	private Label statutlabel;
	
	public void Login(ActionEvent event){
		/*ListIterator<Compte>it = this.compte.listIterator();
		int i=0;
		while(it.hasNext()) {
			if(it.next().getLogin().equals(logintextfield.getText()) && it.next().getMdp().equals(mdptextfield.getText())){
				this.position=i;
				statutlabel.setText("Login réusi");
				return;
			}
			i++;
		}*/
		if(logintextfield.getText().equals("login") && mdptextfield.getText().equals("mdp")){
			statutlabel.setText("OKKK");
			return;}
		statutlabel.setText("Login ou mot de passe incorrect");
	}
	
	public void creercompte(ActionEvent event){
		System.out.print("creation compte");
	}
	public ControllerAuthentification() {
		super();
	}
	
	public ControllerAuthentification(ArrayList<Compte> compte) {
		super();
		this.compte = compte;
		this.position=0;
	}

	public boolean id_correct(String login) {
		ListIterator<Compte>it = this.compte.listIterator();
		int i=0;
		while(it.hasNext()) {
			if(it.next().getLogin().equals(login)){
				this.position=i;
				return true;
			}
			i++;
		}
		return false;
	}

	public boolean mdp_correct(String mdp) {
		if(this.compte.get(position).getMdp().equals(mdp))
			return true;
		
		return false;
	}
	
	public boolean compte_bloque() {
		if(this.compte.get(position).getNbr_tentative()<1)
			return true;
		decrementerNbrTentative();
		return false;
	}

	//Une erreur une tentative en moins
	public void decrementerNbrTentative() {
		this.compte.get(position).setNbr_tentative(this.compte.get(position).getNbr_tentative()-1);
	}
	
}
