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
	private Label sleepErrorLabel;

	@FXML
	private Label sleepProgressLabel;

	@FXML
	private ProgressBar sleepProgressBar; 

	private double hours;

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * When user opens sleep window, the program will first look to see if any sleep was previously entered.  
	 * @param sleep is how much hours the user entered.
	 */
	public void updateSleepProgressLabel(String sleep) {

		if (sleep == null) {
			sleepProgressLabel.setText("You have not entered any hours " + '\n' + "of sleep for today.");
		}

		if (sleep != null) {
			sleepProgressLabel.setText("You have entered " + sleep + " hours" + '\n' +  "of sleep for today.");
		}

		user.health.setSleepProgressLabel(sleep);
	}

	public void updateSleepValues() {
		if (sleepProgressLabel != null) {
			updateSleepProgressLabel(user.health.getSleepProgressLabel());
		}
	}
	
	
	/**
	 * when the button is pressed the method set sleep gets the value entered, and compares it to the goal. 
	 * @param trackSleepEvent when the button update sleep is pressed.
	 */
	@FXML
	void setSleep(ActionEvent trackSleepEvent) {

		// sleepGoal is the goal entered by user, which is in health.
		double sleepGoal = user.health.getSleepGoals();
		
		//hours are set to be the string entered in the hoursSleep text field.
		setHours(Double.parseDouble(hoursSleep.getText()));
		
		int progressPercent = (int) ((getHours()/sleepGoal) * 100);
		setSleepAmount(getHours());

		// the label changes when the user enters a different value.
		updateSleepProgressLabel(String.valueOf(getHours()));
		sleepProgressBar.setProgress((getHours())/sleepGoal);

		// if the sleepGoal - getHours() == 0 or is <0, that means the user has reached their goal, and the label changes to let the user know.
		if (((sleepGoal - getHours()) == 0) || (((sleepGoal - getHours()) < 0))) {
			sleepProgressLabel.setText("You have reached your sleep goal!");
		}

		// if the sleepGoal - getHours() > 0, that means the user has not reached their goal, and is given a percent of how close they are. 
		if (sleepGoal - getHours() > 0) {
			sleepProgressLabel.setText( "You have reached " + progressPercent + "%" + " of your sleep goal.");
		}	
	}

	/**
	 * 
	 * @param hours is the number the user enters in the hoursSleep text field.
	 */
	private void setHours(double hours) {
		this.hours = hours;
	}
	
	private double getHours() {
		return hours;
	}

	/**
	 * 
	 * @param sleep stores the number of hours the user enters for sleep in user. 
	 */
	public void setSleepAmount(double sleep) {
		user.health.setSleepDuration(sleep);
	}

	public double getSleepAmount() {
		return user.health.getSleepDuration();
	}
	
	// when button return to main is pressed, the user is taken back to the main window.
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

}