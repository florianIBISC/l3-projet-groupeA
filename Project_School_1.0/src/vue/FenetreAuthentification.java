package vue;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;;


public class FenetreAuthentification {
	private AnchorPane pane;
	private Stage stagePrincipal;

	public  Scene showWindow() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../controlleur/AuthentificationFXML.fxml"));
		Scene scene = null;
		try {
			//Nous récupérons notre conteneur qui contiendra les données
			//Pour rappel, c'est un AnchorPane...
			AnchorPane conteneurPersonne = (AnchorPane) loader.load();
			scene = new Scene(conteneurPersonne);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*Parent root;
		Scene scene = null;
		try {
		
			//recuperation du fichier fxml
			File file= new File ("/Project_School_1.0/src/controlleur/AuthentificationFXML.fxml");
			URL url_fxml = file.toURI().toURL();
			// Création du loader.
			FXMLLoader fxmlLoader = new FXMLLoader(url_fxml);
			//on charge le fichier fxml sur notre conteneur
			root = fxmlLoader.load();
		    scene= new Scene(root);
			return scene;

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*
	    Scene scene = new Scene(group,500,300,Color.ALICEBLUE);
		
		
		Label l = new Label("Saisissez votre identifiant : ");
		l.setLayoutX(48);
		l.setLayoutY(45);
		
		TextField tf = new TextField();
		tf.setLayoutX(266);
		tf.setLayoutY(40);
		
		Label l2 = new Label("Saississez votre mot de passe: ");
		l2.setLayoutX(48);
		l2.setLayoutY(90);
		
		PasswordField pf = new PasswordField();
		pf.setLayoutX(266);
		pf.setLayoutY(85);
		
		Button b = new Button("Valider");
		b.setLayoutX(218);
		b.setLayoutY(149);
		
		Label l3 = new Label("Vous n'êtes pas encore inscrit ?");
		l3.setLayoutX(220);
		l3.setLayoutY(200);
		l3.setTextFill(Color.RED);
		l3.setCursor(Cursor.CLOSED_HAND);
		l3.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                // TODO Auto-generated method stub
            	showOtherWindow();

            }
        });
		
		group.getChildren().add(l);
		group.getChildren().add(tf);
		group.getChildren().add(l2);
		group.getChildren().add(pf);
		group.getChildren().add(b);
		group.getChildren().add(l3);
*/
		return scene;
	}


}
