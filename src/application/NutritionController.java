package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The NutritionController will verify and store a set of characteristics that are related to nutrition
 * that are unique to the user based on the values entered by the user.
 * The NutritionController will also calculate various nutritional information based on values entered
 * by the user. Also, this controller will check and display errors entered by the user, such as invalid characters
 * or those out of acceptable range.
 * 
 * @author Camila Hernandez, Mariam Masri & Enes Gisi
 *
 */
public class NutritionController {

	public Stage applicationStage;

	@FXML
	private TextField CalorieIntake;
	
	@FXML
	private TextField carbsTextField;
	
	@FXML
	private TextField fatTextField;
	
	@FXML
	private TextField proteinTextField;
	
	@FXML
	private TextField currentWeightTextField;
	
	@FXML
	private Label servingRatioLabel;
	
	@FXML
	private Label CalorieIntakeDisplay;
	
	@FXML
	private Label bmiDisplayLabel;
	
	@FXML
	private Label bfpDisplayLabel;
	
	@FXML
	private Label userWeightLabel;
	
	@FXML 
	private Label weightProgressLabel;
	
	@FXML
    private Label errorLabel;
	
	User user;
	
	
	/**
	 * This method will allow for the same User object to be passed between different controllers.
	 * The user can access the same properties in each scene.
	 * @param user This is the User object.
	 */
	public void setUser(User user) {
    	this.user = user;
    }
	
	/**
	 * This ActionEvent stores and verifies the calories in-take amount inputed by the user in the Nutrition window.
	 * @param setCalorieIntakeEvent This ActionEvent will allow the user to store their calorie in-take amount.
	 * @throws InvalidUserInputException This is the exception that will be thrown if the information is invalid.
	 */
	@FXML
	void setCalorieIntake(ActionEvent setCalorieIntakeEvent) throws InvalidUserInputException {
		// Initially set error label to nothing
		errorLabel.setText("");
		
		try {
			// Checks user input
			user.health.checkInput(CalorieIntake.getText());
			
			// Set the variable with the user input
			double calorieAmount = Double.parseDouble(CalorieIntake.getText());
			
			// Shows average for the typical female
			if (user.getGender().equalsIgnoreCase("Female")) {
				if (calorieAmount < 2000) {
					CalorieIntakeDisplay.setText("Your calorie intake of " + calorieAmount + '\n' 
				+ " is less than the average amount required daily for an adult female.");
				}
				
				if (calorieAmount >= 2000 && calorieAmount < 2500) {
					CalorieIntakeDisplay.setText("You have consumed the average " + '\n'
							+ "amount of calories needed for an adult female.");
				}
				
				if (calorieAmount > 2500) {
					CalorieIntakeDisplay.setText("Your calorie intake of " + calorieAmount + '\n' +
				" is greater than the average amount required daily for an adult female.");
				}
			}
			
			// Shows averages for the typical males
			if (user.getGender().equalsIgnoreCase("Male")) {
				if (calorieAmount < 2500) {
					CalorieIntakeDisplay.setText("Your calorie intake of " + calorieAmount + '\n' +
							" is less than the average amount required daily for an adult male.");
				}
				
				if (calorieAmount >= 2500 && calorieAmount < 3000) {
					CalorieIntakeDisplay.setText("You have consumed the average " + '\n'
							+ "amount of calories needed for an adult male.");
				}
				
				if (calorieAmount > 3000) {
					CalorieIntakeDisplay.setText("Your calorie intake of " 
				+ calorieAmount + '\n' + " is greater than the average amount required daily for an adult.");
				}
			}
			
		} catch (InvalidUserInputException e) {
				errorLabel.setText(e.getMessage());
		}
	}
	
	/**
	 * This ActionEvent calculates the user's body mass index (BMI) based on their current weight
	 * and their height which the user can input in the Nutrition window and User Profile window, respectively.
	 * This method will call the Health class to verify the user's input.
	 * @param calculateBMIevent This ActionEvent calls a method in the Health class which calculates the user's BMI.
	 */
	@FXML
	void calculateBMI(ActionEvent calculateBMIevent) {
		// Uses Health class to calculate BMI
		double BMI = user.health.calculateBMI(user.health.getCurrentWeight(), user.health.getHeight());
		if (user.health.getCurrentWeight() == 0) {
			BMI = user.health.calculateBMI(user.health.getStartingWeight(), user.health.getHeight());
		}
		
		// Displays different messages to user depending on their BMI
		if (BMI < 18.5) {
			bmiDisplayLabel.setText(String.format("Your BMI is: %.2f " + '\n' + "This displays low weight.", BMI));	
		}
		if (BMI > 18.5 && BMI < 25) {
			bmiDisplayLabel.setText(String.format("Your BMI is: %.2f " + '\n' + "This is a healthy weight.", BMI));	
		}
		
		if (BMI > 25) {
			bmiDisplayLabel.setText(String.format("Your BMI is: %.2f " + '\n' + "This displays a high weight.", BMI));	
		}
		
	}
	
	/**
	 * This ActionEvent will store and verify the user's carbohydrate, fat and protein in-take for the day.
	 * The user can input this information in the Nutrition window.
	 * This method will call the Health class to verify the user's input.
	 * @param servingRatioEvent This ActionEvent sets the carbs, fat and protein variables in the Health class.
	 * @throws InvalidUserInputException This is the exception that will be thrown if the information is invalid.
	 */
	@FXML
	void updateServingRatio(ActionEvent servingRatioEvent) throws InvalidUserInputException {
		// Initially set error label to nothing
		errorLabel.setText("");
				
		try {
			// Checks user input
			user.health.checkInput(carbsTextField.getText());
			user.health.checkInput(fatTextField.getText());
			user.health.checkInput(proteinTextField.getText());
			
			// Sets the carbs, fat and protein the user consumed in Health class
			user.health.setCarbs(Double.parseDouble(carbsTextField.getText()));
			user.health.setFat(Double.parseDouble(fatTextField.getText()));
			user.health.setProtein(Double.parseDouble(proteinTextField.getText()));	
		} catch (InvalidUserInputException e){
			errorLabel.setText(e.getMessage());
		}
	}
	
	/**
	 * This ActionEvent will calculate the serving ratio of carbs, fat and protein.
	 * This method uses the information that the user inputed in the Nutrition window.
	 * @param calculateServingRatioEvent This ActionEvent will calculate the serving ratio based 
	 * on calculations performed in the Health class.
	 */
	@FXML
	void calculateServingRatio(ActionEvent calculateServingRatioEvent) {
		// Variables get defaulted to zero.
		double carbs = 0.0;
		double fat = 0.0;
		double protein = 0.0;
		
		// Sets variables with calculations found in the Health class
		carbs = user.health.calculateCarbs();
		fat = user.health.calculateFat();
		protein = user.health.calculateProtein();
		
		// Displays serving ratio to user
		servingRatioLabel.setText(String.format("Ratio: " + '\n' + "%.1f carbs, %.1f fat, %.1f protein." , carbs,fat,protein));
	}
	
	/**
	 * This ActionEvent will draw a comparison between the user's current weight and their weight goal.
	 * This comparison will get displayed to the user to see their progress.
	 * @param comparisonEvent This ActionEvent will display a comparison between weight goal and current weight.
	 */
	@FXML
	void compareWeight(ActionEvent comparisonEvent) {
		// Setting userWeight to zero
		double userWeight = 0.0;
		// Getting the user's weight goal
		double weightGoal = user.health.getWeightGoals();
		
		// Setting userWeight variable
		if (user.health.getCurrentWeight() != 0.0) {
			userWeight = user.health.getCurrentWeight();
		}
		else {
			userWeight = user.health.getStartingWeight();
		}
		
		// Displays label to the user
		if(weightGoal == 0.0) {
			userWeightLabel.setText("You have not set a weight goal.");
		}
		//if the user reaches the exact goal set.
		if (weightGoal - userWeight == 0) {
			userWeightLabel.setText("You have reached your weight goal.");
		}
		// if the user wants to loose weight. 
		if (weightGoal - userWeight < 0) {
			userWeightLabel.setText("You are " + (userWeight - weightGoal) + " kg away from" + '\n' + "your weight goal.");
		}
		// if the user wants to gain weight.
		if (weightGoal - userWeight > 0) {
			userWeightLabel.setText("You are " + (weightGoal - userWeight) + " kg away from" + '\n' + " your weight goal.");
		}
	}
	
	/**
	 * This ActionEvent will store and verify the user's current weight.
	 * The user can input this information in the Nutrition window.
	 * @param setCurrentWeightEvent This ActionEvent stores the user's weight.
	 * @throws InvalidUserInputException This is the exception that will be thrown if the information is invalid.
	 */
	@FXML
	void setCurrentWeight(ActionEvent setCurrentWeightEvent) throws InvalidUserInputException {
		// Initially set error label to nothing
		errorLabel.setText("");
		
		try {
			// Checks user input
			user.health.checkInput(currentWeightTextField.getText());
			
			// If the users input is valid, variables will be set
			double currentWeight = Double.parseDouble(currentWeightTextField.getText());
			double startWeight = user.health.getStartingWeight();
			
			// If the user has entered their most recent weight, it will set their current weight.
			// If the user has not entered their most recent weight, it will set their current weight as their starting weight.
			if (currentWeightTextField.getText() != null) {
				user.health.setCurrentWeight(currentWeight);
			}
			else {
				user.health.setCurrentWeight(startWeight);
			}
	    
			// Displays weight progress to user
			weightProgressLabel.setText("Your starting weight: " + startWeight + ". Your current weight: " + currentWeight + ".");
			
		} catch (InvalidUserInputException e) {
			errorLabel.setText(e.getMessage());
		}
	}
	
	/**
	 * This ActionEvent changes the scene back to the main page while passing the same User
	 * object and setting various labels in the main page.
	 * @param returnToMainPageEvent Changes the scene back to the main page.
	 */
	@FXML
    void returnToMain(ActionEvent event) {
    	 try {
  		   FXMLLoader loader = new FXMLLoader();
  		   BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerView.fxml"));
  		   FitnessTrackerController controller = (FitnessTrackerController)loader.getController();
  		   controller.setUser(user);
		   controller.setGoalsCompletedLabel();
  		   controller.setNameLabel();
  		   controller.applicationStage = applicationStage;
  		   
  		   Scene scene = new Scene(root);
  		   applicationStage.setScene(scene);
  		   applicationStage.show();
  	   } catch(Exception e) {
  		   e.printStackTrace();
  	   }
	}

}
