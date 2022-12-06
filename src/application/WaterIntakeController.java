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
 * The WaterIntakeController will store the characters entered by the user as cups of water.
 * It will check if the characters are valid, and display an error message. Then compare the amount of 
 * cups entered, to the goal set by the user, and display the progress. 
 * 
 * @author Camila Hernandez, Mariam Masri & Enes Gisi
 *
 */
public class WaterIntakeController{
	Stage applicationStage;

	@FXML
	private TextField amountOfWater;

	@FXML
	private Label waterProgressLabel;
	
	@FXML
	private Label waterErrorLabel;

	User user;
	
	private double intakeAmount;
	
	/**
	 * This method will allow for the same User object to be passed between different controllers.
	 * The user can access the same properties in each scene.
	 * @param user This is the User object.
	 */
	public void setUser(User user) {
		this.user = user;
	}

	// when the water window is opened again, the values previously entered are updated. 
	public void updateWaterValues() {
		if (waterProgressLabel != null) {
			updateWaterProgressLabel(user.health.getWaterProgressLabel());
		}
	}

	/**
	 * 
	 * @param progressWaterEvent - when update water button is pressed, user is shown how far away they are from the goal set.
	 */
	@FXML
	void calculateAmountWater(ActionEvent progressWaterEvent){
		try {
			// Checks user input
			user.health.checkInput(amountOfWater.getText());
		} catch (InvalidUserInputException e){
			waterErrorLabel.setText(e.getMessage());
		}
		
		// if the user input is valid, the amount of water entered in textField will be used to set the variable.
		// the amount the user inputs will be added to the previous total they have inputed.
		intakeAmount = Double.parseDouble(amountOfWater.getText()) + user.health.getWaterIntakeAmount();
		
		// the goal user has set for water, stored in health.
		double waterGoal = user.health.getWaterIntakeGoals();
		
		//the amount of cups user entered compared to goal.
		double waterProgress = waterGoal - getWaterIntakeAmount();
		
		updateWaterProgressLabel(String.valueOf(getWaterIntakeAmount()));
		
		user.health.setWaterIntakeAmount(getWaterIntakeAmount());

		// displays to the user how close they are to their goal.
		if (waterProgress == 0 || waterProgress < 0) {
			waterProgressLabel.setText("You have reached your water goal.");
		}
		
		if (waterProgress > 0) {
			waterProgressLabel.setText( "You are " + waterProgress + " cups away from your goal.");
		}

	}

	// the user is shown how many cups they have entered in total when the user reopens the water window. 
	public void updateWaterProgressLabel(String water) {
		if (water != null) {
			waterProgressLabel.setText("You have entered " + water + " cups of water.");
		}
		if (water == null) {
			waterProgressLabel.setText("You have not entered your water intake.");
		}
		user.health.setWaterProgressLabel(water);

	}
	
	// stores the progress label in health, to be accessed when window is reopened.
	public void setWaterProgressLabel(String water) {
		user.health.setWaterProgressLabel(water);
	}

	public String getWaterProgressLabel() {
		return user.health.getWaterProgressLabel();
	}

	// setter, getter methods for amount of water entered by user in text field.
	public void setWaterIntakeAmount(double water) {
		this.intakeAmount = water;
	}

	public double getWaterIntakeAmount() {
		return intakeAmount;
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
			controller.applicationStage = applicationStage;
			controller.setDisplayLabel(event);
			controller.setNameLabel();
			controller.setGoalsCompletedLabel();

			Scene scene = new Scene(root);
			applicationStage.setScene(scene);
			applicationStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
