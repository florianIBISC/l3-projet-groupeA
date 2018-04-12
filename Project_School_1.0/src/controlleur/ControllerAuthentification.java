package controlleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;
import connexionBD.connexionDAOMySQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.Compte;

public class ControllerAuthentification {

	private ArrayList<Compte> compte=new ArrayList<Compte>();
	//Sert de pointeur vers le compte sélectionné dans notre arraylist
	private int position;
	private static boolean switchWindow=false;
	
	@FXML
	private TextField logintextfield;
	
	@FXML
	private TextField mdptextfield;
	
	@FXML
	private Label statutlabel;
	
	Connection conn;
	PreparedStatement state;
	ResultSet res;
	public ControllerAuthentification() {
		super();
		try {
			//On récupère une connexion à la BDD
			this.conn= connexionDAOMySQL.getInstance();
			//On va récupérer les données de la BDD pour en faire de nouveaux objets
			this.state = conn.prepareStatement("SELECT * FROM compte");
			
			//On éxécute les requêtes sql
			this.res = state.executeQuery();		
			
			//On va récupérer tous les comptes de la base de données et les rentrer dans notre ArrayList
			while(res.next()) {
				String login = res.getString("login");
				int id = res.getInt("idCompte");
				String passwd = res.getString("mdp");
				Compte temp = new Compte(login,id,passwd);
				this.compte.add(temp);
			}
			for(int i=0;i<this.compte.size();i++){
				System.out.print(this.compte.get(i).getLogin());
				System.out.print(this.compte.get(i).getMdp());
			}

	}catch(Exception e) {
		e.printStackTrace();
	}
}


	public void Login(ActionEvent event){
		
		/*if(logintextfield.getText().equals("login") && mdptextfield.getText().equals("mdp")){
			statutlabel.setText("OKKK");
			return;}
		statutlabel.setText("Login ou mot de passe incorrect");*/
		//statutlabel
		if(compte_bloque()) {
			System.out.println("Compte bloqué");
			String message = " Compte bloqué";
			statutlabel.setText(message);
			//On ferme toutes les connexions
			try {
				this.res.close();
				this.state.close();
				this.conn.close();
			} catch (SQLException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
			
		}
		if(id_correct()) {
			if(mdp_correct()) {
				System.out.println("Login + mdp correct");
				statutlabel.setText("Login + mdp correct");
				switchWindow=true;
				try {
					this.res.close();
					this.state.close();
					this.conn.close();
				} catch (SQLException e) {
						// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ;
			}
			else {
				System.out.println("Mauvais mdp");
				String message = " Mot de passe incorrect\n Il vous reste : "+compte.get(position).getNbr_tentative()+" tentatives";
				statutlabel.setText(message);
				try {
					this.res.close();
					this.state.close();
					this.conn.close();
				} catch (SQLException e) {
						// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ;
			}
		}
		else {
			System.out.println("Login inconnue !");
			String message = " Login inconnu";
			statutlabel.setText(message);
			try {
				this.res.close();
				this.state.close();
				this.conn.close();
			} catch (SQLException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
		}
		
	}
	
	public void creercompte(ActionEvent event){
		System.out.print("creation compte");
	}

	
	public static boolean isSwitchWindow() {
		return switchWindow;
	}


	public ControllerAuthentification(ArrayList<Compte> compte) {
		super();
		this.compte = compte;
		this.position=0;
	}

	public boolean id_correct() {
		ListIterator<Compte>it = this.compte.listIterator();
		int i=0;
		while(it.hasNext()) {
			if(it.next().getLogin().equals(logintextfield.getText())){
				this.position=i;
				return true;
			}
			i++;
		}
		return false;
	}

	public boolean mdp_correct() {
		if(this.compte.get(position).getMdp().equals(mdptextfield.getText()))
			return true;
		
		return false;
	}
	
	public boolean compte_bloque() {
		if(this.compte.get(position).getNbr_tentative()<1)
			return true;
		decrementerNbrTentative();
		return false;
	}

	//Une erreur = une tentative en moins
	public void decrementerNbrTentative() {
		this.compte.get(position).setNbr_tentative(this.compte.get(position).getNbr_tentative()-1);
	}
	
}
