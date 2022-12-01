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
	private Label waterIntakeLabel;

	@FXML
	private Label waterProgressLabel;

	private double intakeAmount;

	private double goalAmount;

	private double totalWaterIntake;

	User user;

	public void setUser(User user) {
		this.user = user;
	}

	// when the water window is opened again, the values previously entered are updated. 
	public void updateWaterValues() {
		if (waterIntakeLabel != null) {
			updateWaterDrankLabel(user.health.getWaterIntakeAmountLabel());
		}
		if (waterProgressLabel != null) {
			updateWaterProgressLabel(user.health.getWaterProgressLabel());
		}
	}

	// when update progress button is pressed, the method calculateAmountWater calculates how far away you are from water goal. 
	@FXML
	void calculateAmountWater(ActionEvent progressWaterEvent) {
		//the in take is the value entered in the textField. 
		setIntakeAmount(Double.parseDouble(amountOfWater.getText()));
		totalWaterIntake = getIntakeAmount();

		//the goal to compare, is the goal set in the goals window. 
		setGoalAmount(getGoalAmount() + user.health.getWaterIntakeGoals());

		// the amount of water consumed compared to the goal.
		double waterProgress = getGoalAmount() - totalWaterIntake;

		// stores waterIntake and how much progress.
		updateWaterDrankLabel(String.valueOf(totalWaterIntake));
		setWaterIntake(totalWaterIntake);

		updateWaterProgressLabel(String.valueOf(waterProgress));
		setWaterProgress(String.valueOf(waterProgress));

		// tells user how close they are to their goal. 
		if (waterProgress > 0) {
			waterProgressLabel.setText("You are " + (waterProgress) + " cups away from your goal.");
		}

		if (waterProgress == 0 || waterProgress < 0) {
			waterProgressLabel.setText("You have reached your water intake goal.");
		}

	}

	// when the adds their in take, it updates the label. 
	public void updateWaterDrankLabel(String water) {

		if (water != null) {
			waterIntakeLabel.setText("You have consumed " + water + " cups of water.");
		}
		if (water == null) {
			waterIntakeLabel.setText("You have consumed 0 cups of water.");
		}
		user.health.setWaterIntakeAmountLabel(water);
	}

	public void setWaterIntake(double water) {
		user.health.setWaterIntakeAmount(water);
	}

	public double getWaterIntake() {
		return user.health.getWaterIntakeAmount();
	}

	// the user is shown how far away they are from their goal. 
	public void updateWaterProgressLabel(String water) {
		if (water != null) {
			waterProgressLabel.setText("You are " + water + " cups away from your goal.");
		}
		if (water == null) {
			if (getGoalAmount() == 0) {
				waterProgressLabel.setText("You have not set a goal.");
			}
			else {
				waterProgressLabel.setText("You are " + getGoalAmount() + " cups away from your goal." );
			}
		}
		user.health.setWaterProgressLabel(water);

		// to access the water in take from storage
	}
	public void setWaterProgress(String water) {
		user.health.setWaterProgressLabel(water);
	}

	public String getWaterProgress() {
		return user.health.getWaterProgressLabel();
	}

	@FXML
	void returnToMain(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerView.fxml"));
			FitnessTrackerController controller = (FitnessTrackerController)loader.getController();
			
			controller.setUser(user);
			controller.applicationStage = applicationStage;

			Scene scene = new Scene(root);
			applicationStage.setScene(scene);
			applicationStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public double getIntakeAmount() {
		intakeAmount = Double.parseDouble(amountOfWater.getText());
		return intakeAmount;
	}

	public void setIntakeAmount(double intakeAmount) {
		this.intakeAmount = intakeAmount;
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

}