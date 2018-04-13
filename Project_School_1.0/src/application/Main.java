package application;

import bd.controlleur.ChargementDonnees;
import controlleur.ControllerAuthentification;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		ChargementDonnees cd= new ChargementDonnees();
		launch(args);

	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../controlleur/AuthentificationFXML.fxml"));
		    Parent root = (Parent)loader.load();

		    primaryStage.setTitle("Authentification");
		    ControllerAuthentification ca=new ControllerAuthentification();
		    Scene scene=new Scene(root);
		    primaryStage.setScene(scene);
	    	primaryStage.show();
		   /* while(!ControllerAuthentification.isSwitchWindow()) {
		    	primaryStage.setScene(scene);
		    	primaryStage.show();
		    }*/
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}
