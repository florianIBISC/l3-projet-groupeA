package controlleur;

import java.util.ArrayList;
import java.util.Iterator;

import modele.Compte;

public class ControllerAuthentification implements IControllerAuthentification{

	private ArrayList<Compte> compte;
	
	//Sert de pointeur vers le compte sélectionné dans notre arraylist
	private int position;
	
	public ControllerAuthentification(ArrayList<Compte> compte) {
		super();
		this.compte = compte;
		this.position=0;
	}

	@Override
	public boolean id_correct(String login) {
		Iterator<Compte>it = this.compte.iterator();
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

	@Override
	public boolean mdp_correct(String mdp) {
		if(this.compte.get(position).getMdp().equals(mdp))
			return true;
		
		return false;
	}

	@Override
	public boolean compte_bloque() {
		// TODO Auto-generated method stub
		if(this.compte.get(position).getNbr_tentative()<1)
			return true;
		decrementerNbrTentative();
		return false;
	}

	@Override
	public void decrementerNbrTentative() {
		// TODO Auto-generated method stub
		this.compte.get(position).setNbr_tentative(this.compte.get(position).getNbr_tentative()-1);
	}
	
}
