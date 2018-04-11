package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vue.FenetreAuthentification;
import vue.InscriptionVue;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		try {
			/*BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());*/
			
			Group root = new Group();
			FenetreAuthentification fen= new FenetreAuthentification();
			Scene scene = fen.showWindow();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Authentification");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	}


