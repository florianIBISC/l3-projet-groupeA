package vue;

import com.jfoenix.controls.JFXTextField;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class InscriptionVue {
	
	public static Scene showWindow(Group root) {
		Scene scene = new Scene(root,600,400,Color.ALICEBLUE);
		
		JFXTextField j1 = new JFXTextField("Nom");
		j1.setLayoutX(133);j1.setLayoutY(92);
		
		JFXTextField j2 = new JFXTextField("Prénom");
		j2.setLayoutX(133);j2.setLayoutY(157);
		
		JFXTextField j3 = new JFXTextField("Adresse mail");
		j3.setLayoutX(133);j3.setLayoutY(283);
		
		JFXTextField j4 = new JFXTextField("Lieu de naissance");
		j4.setLayoutX(418);j4.setLayoutY(92);
		
		JFXTextField j5 = new JFXTextField("Numéro de téléphone");
		j5.setLayoutX(418);j5.setLayoutY(157);
		
		JFXTextField j6 = new JFXTextField("Adresse");
		j6.setLayoutX(418);j6.setLayoutY(283);
		
		root.getChildren().add(j1);		root.getChildren().add(j2);
		root.getChildren().add(j3);
		root.getChildren().add(j4);		root.getChildren().add(j5);
		root.getChildren().add(j6);


		return scene;
		
	}

}
