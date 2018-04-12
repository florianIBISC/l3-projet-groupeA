package application;

import java.io.IOException;

import controlleur.ControllerAuthentification;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);

	}
	private Stage stage;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage=primaryStage;
		try {
			this.stage = primaryStage;
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("../controlleur/AuthentificationFXML.fxml"));
		    Parent root = (Parent)loader.load();

		    primaryStage.setTitle("Authentification");
		    while(!ControllerAuthentification.isSwitchWindow()) {
		    primaryStage.setScene(new Scene(root));
		    primaryStage.show();

		    }
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}
