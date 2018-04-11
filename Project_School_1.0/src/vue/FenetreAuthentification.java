package vue;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

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

		return scene;
	}

	
	public static void showOtherWindow() {
		System.out.println("Okok");
	}
}
