package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UserSleepTrackerController{
	Stage applicationStage;
	Storage storage;
	
	@FXML
	private TextField hoursSleep;

	@FXML
	private TextField minutesSleep;
	
	@FXML
	private Label sleepProgress;
	
	@FXML
	private ProgressBar sleepProgressBar; 
	
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
	@FXML
	void setSleep(ActionEvent trackSleepEvent) {
		double hours = Double.parseDouble(hoursSleep.getText());
		double minutes = Double.parseDouble(minutesSleep.getText());
		double sleepGoal = Double.parseDouble(Storage.storage.getSleepGoals());
		int progressPercent = (int) ((hours/sleepGoal)* 100);
		
		if (sleepGoal - hours == 0 || sleepGoal - hours < 0) {
			sleepProgress.setText("You have reached" + '\n' + "your sleep goal.");
		}
		
		if (sleepGoal - hours > 0) {
			sleepProgress.setText( "You have reached " + progressPercent + "%" + '\n' + "of your sleep goal.");
		}
		
		sleepProgressBar.setProgress(hours/sleepGoal);
		
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
