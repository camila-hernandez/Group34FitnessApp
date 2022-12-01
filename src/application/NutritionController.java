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

public class NutritionTrackerController {

	public Stage applicationStage;

	public TextField CalorieIntake;
	
	public Label CalorieIntakeDisplay;
	
	public Label bmiDisplay;
	
	
	
	
	@FXML
	void setCalorieIntake(ActionEvent setCalorieIntakeEvent) {
		double calorieAmount = Double.parseDouble(CalorieIntake.getText());
		
		if (calorieAmount < 2000) {
			CalorieIntakeDisplay.setText("Your Calorie intake of " 
		+ calorieAmount + " is less than the average "
				+ "amount required daily for an adult.");
		}
		
		if (calorieAmount >= 2000 && calorieAmount < 3000) {
			CalorieIntakeDisplay.setText("You have consumed the average "
					+ "amount of calories needed for an adult");
		}
		
		if (calorieAmount > 3000) {
			CalorieIntakeDisplay.setText("Your Calorie intake of " 
		+ calorieAmount + " is greater than the average "
				+ "amount required daily for an adult.");
		}
	}
	
	void setBMI(ActionEvent event) {
		bmiDisplay.setText("this is your bmi");
	}
	@FXML
    void returnToMain(ActionEvent event) {
    	 try {
  		   FXMLLoader loader = new FXMLLoader();
  		   BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerView.fxml"));
  		   FitnessTrackerController controller = (FitnessTrackerController)loader.getController();
  		   controller.applicationStage = applicationStage;
  		   
  		   Scene scene = new Scene(root);
  		   applicationStage.setScene(scene);
  		   applicationStage.show();
  	   } catch(Exception e) {
  		   e.printStackTrace();
  	   }
	}

}
