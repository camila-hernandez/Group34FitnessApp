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

/**
 * The Main class will run the application for user interaction. 
 * This class will also read a file that saves the user's inputs.
 * @author Camila Hernandez, Mariam Masri & Enes Gisi
 *
 */
public class Main extends Application {
	private static User user = new User();

	/**
	 * This method loads the application for the user to interact with.
	 */
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
		
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Health and Fitness Tracker");
			primaryStage.show();  
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will read the contents of a file and import them into the application.
	 * @throws IOException This is the exception that will be thrown if there were issues reading the file.
	 * @throws InvalidUserInputException This is the exception that will be thrown if the information is invalid.
	 */
	private static void readFile() throws IOException, InvalidUserInputException {
		File f = new File("FitnessTrackerFile.txt");
		// If the file doesn't exist, we will create the file
		if (f.exists())  {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			
			Calendar cal = Calendar.getInstance();
	    	Date today = new Date();
			cal.setTime(today); 
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			
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
				if (words[0].contentEquals("Starting weight ")) {
					user.health.setStartingWeight(Double.parseDouble(words[1]));
					System.out.print("lll" + user.health.getStartingWeight());
				}
	
				// Sets goal values in Health and Fitness classes when the program starts
				//if (words[0].contentEquals("Steps goal ")) {
				//	user.fitness.setStepsGoals(Integer.parseInt(words[1].trim()));
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
					if (dayOfWeek == cal.get(Calendar.MONDAY)) {
						user.fitness.setProgress(Double.parseDouble(words[1]));
					}
				}
				
				if (words[0].contentEquals("Tuesday exercise duration ")) {
					user.fitness.setTuesdayExerciseInfo(Double.parseDouble(words[1]));
					if (dayOfWeek == cal.get(Calendar.TUESDAY)) {
						user.fitness.setProgress(Double.parseDouble(words[1]));
					}
				}
				
				if (words[0].contentEquals("Wednesday exercise duration ")) {
					user.fitness.setWednesdaydayExerciseInfo(Double.parseDouble(words[1]));
					if (dayOfWeek == cal.get(Calendar.WEDNESDAY)) {
						user.fitness.setProgress(Double.parseDouble(words[1]));
					}
				}
				
				if (words[0].contentEquals("Thursday exercise duration ")) {
					user.fitness.setThursdayExerciseInfo(Double.parseDouble(words[1]));
					if (dayOfWeek == cal.get(Calendar.THURSDAY)) {
						user.fitness.setProgress(Double.parseDouble(words[1]));
					}
				}
				
				if (words[0].contentEquals("Friday exercise duration ")) {
					user.fitness.setFridayExerciseInfo(Double.parseDouble(words[1]));
					if (dayOfWeek == cal.get(Calendar.FRIDAY)) {
						user.fitness.setProgress(Double.parseDouble(words[1]));
					}
				}
				
				if (words[0].contentEquals("Saturday exercise duration ")) {
					user.fitness.setSaturdayExerciseInfo(Double.parseDouble(words[1]));
					if (dayOfWeek == cal.get(Calendar.SATURDAY)) {
						user.fitness.setProgress(Double.parseDouble(words[1]));
					}
				}
				
				if (words[0].contentEquals("Sunday exercise duration ")) {
					user.fitness.setSundayExerciseInfo(Double.parseDouble(words[1]));
					if (dayOfWeek == cal.get(Calendar.SUNDAY)) {
						user.fitness.setProgress(Double.parseDouble(words[1]));
					}
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
			}
			br.close();
			fr.close();	
		}
	}

	/**
	 * This method will read the contents of the file and launch the application.
	 * @param args This is the command line arguments.
	 * @throws IOException This is the exception that will be thrown if there were issues reading the file.
	 * @throws InvalidUserInputException This is the exception that will be thrown if the information is invalid.
	 */
	public static void main(String[] args) throws IOException, InvalidUserInputException {		
		readFile();
		launch(args);
	}
	
}