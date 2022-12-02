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

public class SleepController{
	Stage applicationStage;
	
	User user;
	
	@FXML
	private TextField hoursSleep;

	@FXML
	private TextField minutesSleep;
	
	@FXML
	private Label sleepProgressLabel;
	
	@FXML
	private ProgressBar sleepProgressBar; 
	
	double hours;
	
	public void setUser(User user) {
    	this.user = user;
    }
	
	@FXML
	void setSleep(ActionEvent trackSleepEvent) {
		if (user.health.getSleepDuration() != 0.0) {
			hours = Double.parseDouble(hoursSleep.getText()) + user.health.getSleepDuration();
		}
		if (user.health.getSleepDuration() == 0.0) { hours = Double.parseDouble(hoursSleep.getText());
		}

		double sleepGoal = user.health.getSleepGoals();
		int progressPercent = (int) ((hours/sleepGoal)* 100);
		
		updateSleepProgressLabel(String.valueOf(hours));
		sleepProgressBar.setProgress((hours)/sleepGoal);
		setSleepAmount(hours);
		
		updateSleepProgressLabel(String.valueOf(hours));
		user.health.setSleepDuration(hours);
		
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
		
		user.health.setSleepProgressLabel(sleep);
    }
	
	public void updateSleepValues() {
    	if (sleepProgressLabel != null) {
    		updateSleepProgressLabel(user.health.getSleepProgressLabel());
    	}
	}
	
	public void setSleepAmount(double sleep) {
    	user.health.setSleepDuration(sleep);
    }
	
	public double getSleepAmount() {
		return user.health.getSleepDuration();
	}

	@FXML
    void returnToMain(ActionEvent event) {
    	 try {
  		   FXMLLoader loader = new FXMLLoader();
  		   BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerView.fxml"));
  		   FitnessTrackerController controller = (FitnessTrackerController)loader.getController();
  		   controller.applicationStage = applicationStage;
  		   controller.setUser(user);
  		   Scene scene = new Scene(root);
  		   applicationStage.setScene(scene);
  		   applicationStage.show();
  		   
  	   } catch(Exception e) {
  		   e.printStackTrace();
  	   }
    }

}
