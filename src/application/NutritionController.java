package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

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
	private Label servingRatioLabel;
	
	@FXML
	private Label CalorieIntakeDisplay;
	
	@FXML
	private Label bmiDisplayLabel;
	
	@FXML
	private Label bfpDisplayLabel;
	
	@FXML
	private Label userWeightLabel;
	
	User user;
	
	public void setUser(User user) {
    	this.user = user;
    }
	
	@FXML
	void setCalorieIntake(ActionEvent setCalorieIntakeEvent) {
		double calorieAmount = Double.parseDouble(CalorieIntake.getText());
		
		if (user.getGender().equalsIgnoreCase("female")) {
			if (calorieAmount < 2000) {
				CalorieIntakeDisplay.setText("Your Calorie intake of " + calorieAmount + '\n' 
			+ " is less than the average amount required daily for an adult female.");
			}
			
			if (calorieAmount >= 2000 && calorieAmount < 2500) {
				CalorieIntakeDisplay.setText("You have consumed the average " + '\n'
						+ "amount of calories needed for an adult female.");
			}
			
			if (calorieAmount > 2500) {
				CalorieIntakeDisplay.setText("Your Calorie intake of " + calorieAmount + '\n' +
			" is greater than the average amount required daily for an adult female.");
			}
		}
		
		if (user.getGender().equalsIgnoreCase("male")) {
			if (calorieAmount < 2500) {
				CalorieIntakeDisplay.setText("Your Calorie intake of " + calorieAmount + '\n' +
						" is less than the average amount required daily for an adult male.");
			}
			
			if (calorieAmount >= 2500 && calorieAmount < 3000) {
				CalorieIntakeDisplay.setText("You have consumed the average " + '\n'
						+ "amount of calories needed for an adult male.");
			}
			
			if (calorieAmount > 3000) {
				CalorieIntakeDisplay.setText("Your Calorie intake of " 
			+ calorieAmount + '\n' + " is greater than the average amount required daily for an adult.");
			}
		}
		
		
	}
	
	@FXML
	void calculateBMI(ActionEvent calculateBMIevent) {
		double bmi = user.health.calculateBMI();
		if (bmi < 18.5) {
			bmiDisplayLabel.setText(String.format("Your bmi is: %.2f " + '\n' + "This displays low weight.", bmi));	
		}
		if (bmi > 18.5 && bmi < 25) {
			bmiDisplayLabel.setText(String.format("Your bmi is: %.2f " + '\n' + "This is a healthy weight.", bmi));	
		}
		
		if (bmi > 25) {
			bmiDisplayLabel.setText(String.format("Your bmi is: %.2f " + '\n' + "This displays a high weight.", bmi));	
		}
		
	}

	@FXML
	void updateServingRatio(ActionEvent event) {
		user.health.setCarbs(Double.parseDouble(carbsTextField.getText()));
		user.health.setFat(Double.parseDouble(fatTextField.getText()));
		user.health.setProtein(Double.parseDouble(proteinTextField.getText()));	
	}
	
	@FXML
	void calculateServingRatio(ActionEvent event) {
		double carbs = user.health.calculateCarbs();
		double fat = user.health.calculateFat();
		double protein = user.health.calculateProtein();
		
		servingRatioLabel.setText(String.format("ratio: %.1f carbs, %.1f fat, %.1f fiber.", carbs,fat,protein));
	}
	
	@FXML
	void compareWeight(ActionEvent event) {
		double userWeight = user.health.getCurrentWeight();
		double weightGoal = user.health.getWeightGoals();
		
		if(weightGoal == 0.0) {
			userWeightLabel.setText("You have not set a weight goal.");
		}
		
		if(userWeight == 0.0) {
			userWeightLabel.setText("There is no weight entered in user profile.");
		}
		
		if (weightGoal - userWeight == 0) {
			userWeightLabel.setText("You have reached your weight goal.");
		}
		
		if (weightGoal - userWeight < 0) {
			userWeightLabel.setText("You are " + (userWeight - weightGoal) + " kg away from your weight goal.");
		}
		if (weightGoal - userWeight > 0) {
			userWeightLabel.setText("You are " + (weightGoal - userWeight) + " kg away from your weight goal.");
		}
	}

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
