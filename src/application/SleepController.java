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
	
	private double hours;
	
	public void setUser(User user) {
    	this.user = user;
    }
	
	@FXML
	void setSleep(ActionEvent trackSleepEvent) {

		double sleepGoal = user.health.getSleepGoals();
		setHours(Double.parseDouble(hoursSleep.getText()));
		int progressPercent = (int) ((getHours()/sleepGoal) * 100);
		setSleepAmount(getHours());
		
		updateSleepProgressLabel(String.valueOf(getHours()));
		sleepProgressBar.setProgress((getHours())/sleepGoal);
		
		// Setting progress label
		if (((sleepGoal - getHours()) == 0) || (((sleepGoal - getHours()) < 0))) {
			sleepProgressLabel.setText("You have reached" + '\n' + "your sleep goal!");
		}
		
		if (sleepGoal - getHours() > 0) {
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
  		   controller.setNameLabel();
  		   controller.setGoalsCompletedLabel();
  		   controller.setDisplayLabel(event);
  		   
  		   Scene scene = new Scene(root);
  		   applicationStage.setScene(scene);
  		   applicationStage.show();
  		   
  	   } catch(Exception e) {
  		   e.printStackTrace();
  	   }
    }

	private double getHours() {
		return hours;
	}

	private void setHours(double hours) {
		this.hours = hours;
	}

}