
package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controleur {
	
	@FXML
	private Button btnSimuler;
	
	@FXML
	private TextArea zoneText;
	
	@FXML
	private void initialize() {
	}
	
	public Controleur() {
	}
	
	@FXML
	private void actionBouton() {
		zoneText.appendText("le truc a ajouter au texte voila\n");
	}

}
