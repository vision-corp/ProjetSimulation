/*
 * App.java		27 nov. 2019
 * Pas de droits, ni copyright ni copyleft
 */
package simulation;

import javafx.application.Application;
import javafx.stage.Stage;
import simulation.gui.InterfaceGraphique;

/**
 * 
 * @author Alban Olive
 */
public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		InterfaceGraphique interfaceGraphique = new InterfaceGraphique();
		primaryStage.setScene(interfaceGraphique.getScene());
		primaryStage.show();
		primaryStage.setMaximized(true);
	}

	public static void main(String[] args) {
		launch();
	}

}
