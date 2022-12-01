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
	
	double totalSleepHours;
	
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
	@FXML
	void setSleep(ActionEvent trackSleepEvent) {
		double hours = Double.parseDouble(hoursSleep.getText());
		totalSleepHours += hours;
		double sleepGoal = Double.parseDouble(Storage.storage.getSleepGoals());
		int progressPercent = (int) ((totalSleepHours/sleepGoal)* 100);
		
		updateSleepProgressLabel(String.valueOf(totalSleepHours));
		setSleepAmount(String.valueOf(totalSleepHours));
		
		if (sleepGoal - totalSleepHours == 0 || sleepGoal - totalSleepHours < 0) {
			sleepProgressLabel.setText("You have reached" + '\n' + "your sleep goal.");
		}
		
		if (sleepGoal - totalSleepHours > 0) {
			sleepProgressLabel.setText( "You have reached " + progressPercent + "%" + '\n' + "of your sleep goal.");
		}
		
		sleepProgressBar.setProgress((totalSleepHours)/sleepGoal);
		
	}
	
	public void updateSleepProgressLabel(String sleep) {
		if (sleep == null) {
			sleepProgressLabel.setText("You have no hours of sleep.");
		}
		if (sleep != null) {
			sleepProgressLabel.setText("You have entered " + sleep + " hours of sleep.");
		}
		
    	Storage.storage.setSleepProgressLabel(sleep);
    }
	
	public void updateSleepValues() {
    	if (sleepProgressLabel != null) {
    		updateSleepProgressLabel(storage.sleepProgressLabel);
    		getSleepAmount();
    	}
	}
	
	public void setSleepAmount(String sleep) {
    	Storage.storage.setSleepAmount(sleep);
    }
	
	public String getSleepAmount() {
		return storage.getSleepAmount();
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
