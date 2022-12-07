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
	
	private double intakeAmount;

	@FXML
	private TextField amountOfWater;

	@FXML
	private Label waterProgressLabel;
	
	@FXML
	private Label waterErrorLabel;

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
	 * This method updates the values in the progress label when the Water In-take window 
	 * are opened again by the user.
	 */
	public void updateWaterValues() {
		if (waterProgressLabel != null) {
			updateWaterProgressLabel(getWaterProgressLabel());
		}
	}

	/**
	 * This method calculates how far away the user is from reaching their water in-take goal.
	 * This method will also display the user's progress in the window depending on their water in-take amount.
	 * @param progressWaterEvent - This ActionEvent will display the user's progress in the window.
	 * @throws InvalidUserInputException This is the custom exception that is thrown if the user's input is invalid.
	 * @throws EmptyInputException 
	 */
	@FXML
	void calculateAmountWater(ActionEvent progressWaterEvent) throws InvalidUserInputException, EmptyInputException {
		// Initialize label to empty
		waterErrorLabel.setText("");
		
		try {
			// Checks user input
			user.health.checkInput(amountOfWater.getText());
			
			// the amount of water entered in textField
			intakeAmount = Double.parseDouble(amountOfWater.getText()) + user.health.getWaterIntakeAmount();
			
			double waterGoal = user.health.getWaterIntakeGoals();
			
			//the amount of cups user entered compared to goal.
			double waterProgress = waterGoal - getWaterIntakeAmount();
			
			updateWaterProgressLabel(String.valueOf(getWaterIntakeAmount()));
			setWaterProgressLabel(String.valueOf(getWaterIntakeAmount()));
			
			user.health.setWaterIntakeAmount(getWaterIntakeAmount());

			// tells user how close they are to their goal. 
			if (waterProgress == 0 || waterProgress < 0) {
				waterProgressLabel.setText("You have reached your water goal.");
			}
			
			if (waterProgress > 0) {
				waterProgressLabel.setText( "You are " + waterProgress + " cups away from your goal.");
			}
		} catch (InvalidUserInputException e) {
			waterErrorLabel.setText(e.getMessage());
		} catch (EmptyInputException e) {waterErrorLabel.setText("Input cannot be empty");}
	}

	/**
	 * This method will display how many cups of water the user has entered in total in the Water In-take window.
	 * @param water This string is the amount of water the user drank today.
	 */
	public void updateWaterProgressLabel(String water) {
		if (water != null) {
			waterProgressLabel.setText("You have entered " + water + " cups of water.");
		}
		if (water == null) {
			waterProgressLabel.setText("You have not entered your water intake.");
		}
	}

	/**
	 * This method will store the water in-take progress label in the Health class.
	 * @param water This string is the amount of water the user drank today.
	 */
	public void setWaterProgressLabel(String water) {
		user.health.setWaterProgressLabel(water);
	}

	/**
	 * This method is used to retrieve the same label after the user opens the Water In-take window
	 * multiple times.
	 * @return This getter method returns the water in-take progress label with the amount of water the user entered.
	 */
	public String getWaterProgressLabel() {
		return user.health.getWaterProgressLabel();
	}

	/**
	 * This method stores the user's water in-take amount that the user has entered in the window.
	 * @param water This double is the amount of water the user drank today.
	 */
	public void setWaterIntakeAmount(double water) {
		this.intakeAmount = water;
	}

	/**
	 * This method is used to display the user's progress in the Water In-take window.
	 * @return This getter method retrieves the user's water in-take amount for today.
	 */
	public double getWaterIntakeAmount() {
		return intakeAmount;
	}

	/**
	 * This ActionEvent changes the scene back to the main page while passing the same User
	 * object and setting various labels in the main page.
	 * @param returnToMainPageEvent Changes the scene back to the main page.
	 */
	@FXML
	void returnToMain(ActionEvent returnToMainPageEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerView.fxml"));
			FitnessTrackerController controller = (FitnessTrackerController)loader.getController();

			controller.setUser(user);
			controller.applicationStage = applicationStage;
			controller.setDisplayLabel();
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
