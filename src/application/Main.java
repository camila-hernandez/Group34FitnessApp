package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	private static User user = new User();

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerView.fxml"));
			FitnessTrackerController controller = (FitnessTrackerController)loader.getController();
			controller.applicationStage = primaryStage;
			controller.setUser(user);
			controller.setNameLabel();
			controller.setGoalsCompletedLabel();
			System.out.println("Setting user for fitness controller from main");
		
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Health and Fitness Tracker");
			primaryStage.show();  
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void readFile() throws IOException, InvalidUserInputException {
		File f = new File("FitnessTrackerFile.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while (line != null) {
			String words[] = line.split("=");
			System.out.println(line);
			line = br.readLine();
			
			// Sets user properties
			if (words[0].contentEquals("Name ")) {
				user.setName(words[1]);
			}
			if (words[0].contentEquals("Age ")) {
				user.setAge(Integer.parseInt(words[1].trim()));
			}
			if (words[0].contentEquals("Gender ")) {
				user.setGender(words[1]);
			}
			if (words[0].contentEquals("Height ")) {
				user.health.setHeight(Double.parseDouble(words[1]));
			}
			if (words[0].contentEquals("Weight ")) {
				user.health.setStartingWeight(Double.parseDouble(words[1]));
			}

			// Sets goal values in Health and Fitness classes when the program starts
			///if (words[0].contentEquals("Steps goal ")) {
				//user.fitness.setStepsGoals(Integer.parseInt(words[1].trim()));
			//}
			
			if (words[0].contentEquals("Sleep goal ")) {
				user.health.setSleepGoals(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Water intake goal ")) {
				user.health.setWaterIntakeGoals(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Weight goal ")) {
				user.health.setWeightGoals(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Calories burned goal ")) {
				user.fitness.setCaloriesGoals(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Exercise goal ")) {
				user.fitness.setExerciseGoals(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Monday exercise duration ")) {
				user.fitness.setMondayExerciseInfo(Double.parseDouble(words[1]));
				user.fitness.setProgress(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Tuesday exercise duration ")) {
				user.fitness.setTuesdayExerciseInfo(Double.parseDouble(words[1]));
				user.fitness.setProgress(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Wednesday exercise duration ")) {
				user.fitness.setWednesdaydayExerciseInfo(Double.parseDouble(words[1]));
				user.fitness.setProgress(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Thursday exercise duration ")) {
				user.fitness.setThursdayExerciseInfo(Double.parseDouble(words[1]));
				user.fitness.setProgress(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Friday exercise duration ")) {
				user.fitness.setFridayExerciseInfo(Double.parseDouble(words[1]));
				user.fitness.setProgress(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Saturday exercise duration ")) {
				user.fitness.setSaturdayExerciseInfo(Double.parseDouble(words[1]));
				user.fitness.setProgress(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Sunday exercise duration ")) {
				user.fitness.setSundayExerciseInfo(Double.parseDouble(words[1]));
				user.fitness.setProgress(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Monday calories burned ")) {
				user.fitness.setMondayCaloriesBurnedInfo(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Tuesday calories burned ")) {
				user.fitness.setTuesdayCaloriesBurnedInfo(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Wednesday calories burned ")) {
				user.fitness.setWednesdayCaloriesBurnedInfo(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Thursday calories burned ")) {
				user.fitness.setThursdayCaloriesBurnedInfo(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Friday calories burned ")) {
				user.fitness.setFridayCaloriesBurnedInfo(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Saturday calories burned ")) {
				user.fitness.setSaturdayCaloriesBurnedInfo(Double.parseDouble(words[1]));
			}
			
			if (words[0].contentEquals("Sunday calories burned ")) {
				user.fitness.setSundayCaloriesBurnedInfo(Double.parseDouble(words[1]));
			}
			//if (words[0].contentEquals("Daily progress ")) {
				//user.fitness.setProgress(Double.parseDouble(words[1]));
			//}
		}
		br.close();
		fr.close();	
	}

	public static void main(String[] args) throws IOException, InvalidUserInputException {		
		readFile();
		launch(args);
	}
	
}