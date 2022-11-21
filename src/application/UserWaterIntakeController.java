package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserWaterIntakeController {
	@FXML
	private TextField amountOfWater;

	@FXML 
	private Label waterProgress;

	public Stage applicationStage;
	
	@FXML
	void calculateAmountWater(ActionEvent progressWaterEvent) {
		Double liters = Double.parseDouble(amountOfWater.getText());
		Double waterGoal = 7.0;
		waterProgress.setText("You are " + (waterGoal - liters) + " L away from your goal.");


	}

}
