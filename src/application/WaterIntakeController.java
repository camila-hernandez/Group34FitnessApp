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
	private double waterGoal;
	private double waterProgress;

	public void setUser(User user) {
		this.user = user;
	}

	// when the water window is opened again, the values previously entered are updated. 
	public void updateWaterValues() {
		if (waterProgressLabel != null) {
			updateWaterProgressLabel(user.health.getWaterProgressLabel());
		}
	}

	// when update progress button is pressed, the method calculateAmountWater calculates how far away you are from water goal. 
	@FXML
	void calculateAmountWater(ActionEvent progressWaterEvent) {
		//the in take is the value entered in the textField. 
		waterGoal = user.health.getWaterIntakeGoals();
		intakeAmount = Double.parseDouble(amountOfWater.getText()) + user.health.getWaterIntakeAmount();
		waterProgress = waterGoal - intakeAmount;
		
		updateWaterProgressLabel(String.valueOf(intakeAmount));
		setWaterIntakeAmount(intakeAmount);
		
		user.health.setWaterIntakeAmount(intakeAmount);

		// tells user how close they are to their goal. 
		if (waterProgress == 0 || waterProgress < 0) {
			waterProgressLabel.setText("You have reached" + '\n' + "your water goal.");
		}
		
		if (waterProgress > 0) {
			waterProgressLabel.setText( "You are " + waterProgress + " cups away from your goal.");
		}

	}

	// the user is shown how far away they are from their goal. 
	public void updateWaterProgressLabel(String water) {
		if (water != null) {
			waterProgressLabel.setText("You have entered " + water + " cups of water.");
		}
		if (water == null) {
			waterProgressLabel.setText("You have not entered your water intake.");
		}
		user.health.setWaterProgressLabel(water);

		// to access the water in take from storage
	}
	public void setWaterProgressLabel(String water) {
		user.health.setWaterProgressLabel(water);
	}

	public String getWaterProgressLabel() {
		return user.health.getWaterProgressLabel();
	}

	public void setWaterIntakeAmount(double water) {
		this.intakeAmount = water;
	}

	public double getWaterIntakeAmount() {
		return intakeAmount;
	}

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
