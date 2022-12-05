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

public class WaterIntakeController{
	Stage applicationStage;

	@FXML
	private TextField amountOfWater;

	@FXML
	private Label waterProgressLabel;

	User user;
	
	private double intakeAmount;
	
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
		
		// the amount of water entered in textField
		intakeAmount = Double.parseDouble(amountOfWater.getText()) + user.health.getWaterIntakeAmount();
		
		double waterGoal = user.health.getWaterIntakeGoals();
		
		//the amount of cups user entered compared to goal.
		double waterProgress = waterGoal - getWaterIntakeAmount();
		
		updateWaterProgressLabel(String.valueOf(getWaterIntakeAmount()));
		
		user.health.setWaterIntakeAmount(getWaterIntakeAmount());

		// tells user how close they are to their goal. 
		if (waterProgress == 0 || waterProgress < 0) {
			waterProgressLabel.setText("You have reached your water goal.");
		}
		
		if (waterProgress > 0) {
			waterProgressLabel.setText( "You are " + waterProgress + " cups away from your goal.");
		}

	}

	// the user is shown how many cups they have entered in total. 
	public void updateWaterProgressLabel(String water) {
		if (water != null) {
			waterProgressLabel.setText("You have entered " + water + " cups of water.");
		}
		if (water == null) {
			waterProgressLabel.setText("You have not entered your water intake.");
		}
		user.health.setWaterProgressLabel(water);

	}
	public void setWaterProgressLabel(String water) {
		user.health.setWaterProgressLabel(water);
	}

	public String getWaterProgressLabel() {
		return user.health.getWaterProgressLabel();
	}

	// setter, getter methods for amount of water entered by user.
	public void setWaterIntakeAmount(double water) {
		this.intakeAmount = water;
	}

	public double getWaterIntakeAmount() {
		return intakeAmount;
	}

	// takes user back to main window when return to main button is pressed. 
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
