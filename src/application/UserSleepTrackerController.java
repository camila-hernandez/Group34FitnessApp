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

public class UserSleepTrackerController {
	Stage applicationStage;
	
	@FXML
	private TextField hoursSleep;

	@FXML
	private TextField minutesSleep;
	
	@FXML
	private Label sleepProgress;
	
	void setSleep(ActionEvent trackSleepEvent) {
		double hours = Double.parseDouble(hoursSleep.getText());
		double minutes = Double.parseDouble(minutesSleep.getText());
	}
	
	void returnToMain(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerController.fxml"));
			UserSleepTrackerController controller = (UserSleepTrackerController)loader.getController();
			controller.applicationStage = applicationStage;
			Scene scene = new Scene(root);
			applicationStage.setScene(scene);
			applicationStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
