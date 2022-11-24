package application;
	
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;



public class Main extends Application {
	/*
	public static void readUsingBufferedReader() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("create a file"));
		String line = reader.readLine();
		while (line != null) {
			String[] w = line.split(" ");
			if (w[0] = "water goals") {
				setWaterGoals(w[2]);
			}
		}
	}
	*/
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			AnchorPane root = loader.load(new FileInputStream("src/application/Main.fxml"));
			FitnessController controller = (FitnessController)loader.getController();
			controller.applicationStage = primaryStage;
		
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Health and Fitness Tracker");
			primaryStage.show();  
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
