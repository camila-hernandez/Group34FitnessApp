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

	private double intakeAmount;

	private double goalAmount;

	User user;

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
		if (user.health.getWaterIntakeAmount() != 0.0) {
			setWaterIntakeAmount(Double.parseDouble(amountOfWater.getText()) + user.health.getWaterIntakeAmount());
		}
		if (user.health.getWaterIntakeAmount() == 0.0) { 
			setWaterIntakeAmount(Double.parseDouble(amountOfWater.getText()));
		}

		double waterGoal = user.health.getWaterIntakeGoals();
		double waterProgress = waterGoal - getWaterIntakeAmount();
		
		updateWaterProgressLabel(String.valueOf(getWaterIntakeAmount()));
		
		user.health.setWaterIntakeAmount(getWaterIntakeAmount());

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
			waterProgressLabel.setText("You have not set a goal.");
		}
		user.health.setWaterProgressLabel(water);

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
	
	public double getGoalAmount() {
		if(user.health.getWaterIntakeGoals() != 0) {
			goalAmount = user.health.getWaterIntakeGoals();
		}
		return goalAmount;
	}

	public void setGoalAmount(double goalAmount) {
		this.goalAmount = goalAmount;
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

			Scene scene = new Scene(root);
			applicationStage.setScene(scene);
			applicationStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
