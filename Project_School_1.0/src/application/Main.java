package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vue.FenetreAuthentification;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			/*BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());*/
			
			Group root = new Group();
			Scene scene = FenetreAuthentification.showWindow(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		System.out.println("Oh yeah je suis Florian pas aussi beau que Vignesh !!");
		System.out.println("Oh yeah je suis Nico pas aussi beau que Vignesh !!");

	}
}
