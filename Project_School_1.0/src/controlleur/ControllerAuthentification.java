package controlleur;

public class ControllerAuthentification implements IControllerAuthentification{

	private ArrayList<Compte> compte;
	@Override
	public boolean id_correct(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mdp_correct(String mdp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean compte_bloque() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int nbrTentative() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
