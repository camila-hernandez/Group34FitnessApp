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
	
	double totalSleepHours;
	
	public void setUser(User user) {
    	this.user = user;
    }
	
	@FXML
	void setSleep(ActionEvent trackSleepEvent) {
		double hours = Double.parseDouble(hoursSleep.getText());
		totalSleepHours += hours;
		double sleepGoal = user.health.getSleepGoals();
		int progressPercent = (int) ((totalSleepHours/sleepGoal)* 100);
		
		updateSleepProgressLabel(String.valueOf(totalSleepHours));
		user.health.setSleepDuration(totalSleepHours);
		
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
		
		user.health.setSleepProgressLabel(sleep);
    }
	
	public void updateSleepValues() {
    	if (sleepProgressLabel != null) {
    		updateSleepProgressLabel(user.health.getSleepProgressLabel());
    	}
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
