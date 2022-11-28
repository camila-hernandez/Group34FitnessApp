package application;
	
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;



public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerView.fxml"));
			FitnessTrackerController controller = (FitnessTrackerController)loader.getController();
			controller.applicationStage = primaryStage;
		
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Health and Fitness Tracker");
			primaryStage.show();  
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {		
		
		
		File f = new File("C:\\Users\\CS219-user\\Documents\\FitnessTrackerFile.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		//String words[] = line.split("=");
		while (line != null) {
			String words[] = line.split("=");
			System.out.println(line);
			line = br.readLine();
		
			// Sets goal values in storage when the program starts
			if (words[0].contentEquals("Steps goal ")) {
				Storage.storage.setStepsGoals(words[1]);
			}
			if (words[0].contentEquals("Sleep goal ")) {
				Storage.storage.setSleepGoals(words[1]);
			}
			if (words[0].contentEquals("Water intake goal ")) {
				Storage.storage.setWaterIntakeGoals(words[1]);
			}
			if (words[0].contentEquals("Weight goal ")) {
				Storage.storage.setWeightGoals(words[1]);
			}
			if (words[0].contentEquals("Calories burned goal ")) {
				Storage.storage.setCaloriesGoals(words[1]);
			}
			if (words[0].contentEquals("Exercise goal ")) {
				Storage.storage.setExerciseGoals(words[1]);
			}	
		}
		br.close();
		fr.close();
		// if (currentDate == Monday) 
		// Testing out if it values are stored in storage
		System.out.println("Steps: " + Storage.storage.getStepsGoals());
		System.out.println("Sleep: " + Storage.storage.getSleepGoals());
		System.out.println(" Water: " + Storage.storage.getWaterIntakeGoals());
		System.out.println("Weight: " + Storage.storage.getWeightGoals());
		System.out.println("Calories: " + Storage.storage.getCaloriesGoals());
		System.out.println("Exercise: " + Storage.storage.getExerciseGoals());
		
		launch(args);
	}
	// line.split(" ");
}
