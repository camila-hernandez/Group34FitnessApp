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
	private Label sleepProgressLabel;
	
	@FXML
	private ProgressBar sleepProgressBar; 
	
	//double totalSleepHours;
	double hours;
	
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
	@FXML
	void setSleep(ActionEvent trackSleepEvent) {
		if (Storage.storage.getSleepAmount() != null) {
			hours = Double.parseDouble(hoursSleep.getText()) + Double.parseDouble(Storage.storage.getSleepAmount());
		}
		if (Storage.storage.getSleepAmount() == null) { hours = Double.parseDouble(hoursSleep.getText());
		}
			
		double sleepGoal = Double.parseDouble(Storage.storage.getSleepGoals());
		int progressPercent = (int) ((hours/sleepGoal)* 100);
		updateSleepProgressLabel(String.valueOf(hours));
		sleepProgressBar.setProgress((hours)/sleepGoal);
		setSleepAmount(String.valueOf(hours));
		
		if (sleepGoal - hours == 0 || sleepGoal - hours < 0) {
			sleepProgressLabel.setText("You have reached" + '\n' + "your sleep goal.");
		}
		
		if (sleepGoal - hours > 0) {
			sleepProgressLabel.setText( "You have reached " + progressPercent + "%" + '\n' + "of your sleep goal.");
		}
		
	}
	
	public void updateSleepProgressLabel(String sleep) {
		if (sleep == null) {
			sleepProgressLabel.setText("You have not entered hours of sleep.");
		}
		if (sleep != null) {
			sleepProgressLabel.setText("You have entered " + sleep + " hours of sleep.");
		}
		
    	Storage.storage.setSleepProgressLabel(sleep);
    }
	
	public void updateSleepValues() {
    	if (sleepProgressLabel != null) {
    		updateSleepProgressLabel(storage.sleepProgressLabel);
    	}
	}
	
	public void setSleepAmount(String sleep) {
    	Storage.storage.setSleepAmount(sleep);
    }
	
	public String getSleepAmount() {
		return Storage.storage.getSleepAmount();
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
