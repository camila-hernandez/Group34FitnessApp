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

public class UserWaterIntakeController{
	Storage storage;

	@FXML
	private TextField amountOfWater;

	@FXML 
	private Label waterProgress;

	public Stage applicationStage;

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	@FXML
	void calculateAmountWater(ActionEvent progressWaterEvent) {
		Double IntakeAmount = Double.parseDouble(amountOfWater.getText());
		Double goalAmount = Double.parseDouble(Storage.storage.getWaterIntakeGoals());

		if (goalAmount - IntakeAmount > 0) {
			waterProgress.setText("You are " + (goalAmount - IntakeAmount) + " cups away from your goal.");
		}

		if (goalAmount - IntakeAmount == 0 || goalAmount - IntakeAmount < 0) {
			waterProgress.setText("You have reached your water intake goal");
		}
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
