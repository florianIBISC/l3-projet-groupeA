package vue;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FenetreAuthentification{


	public static Scene showWindow(Group group) {
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
		
		group.getChildren().add(l);
		group.getChildren().add(tf);
		group.getChildren().add(l2);
		group.getChildren().add(pf);
		group.getChildren().add(b);

		return scene;
	}

}
