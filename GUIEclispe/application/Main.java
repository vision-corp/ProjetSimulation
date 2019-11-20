package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		try {
			BorderPane root = FXMLLoader.load(getClass().getResource("interfaceV0.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException err) {
			System.out.println(err);
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
