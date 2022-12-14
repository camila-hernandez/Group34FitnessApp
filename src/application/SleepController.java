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

/**
 * The SleepController will verify and store a set of characteristics that are related to sleep
 * that are unique to the user based on the values entered by the user. 
 * The SleepController will compare and display the users input as hours to their set goal. 
 * Also, this controller will check and display errors entered by the user, such as invalid characters 
 * or those out of acceptable range.
 * 
 * @author Camila Hernandez, Mariam Masri & Enes Gisi
 *
 */
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
  
	/**
	 * This method will allow for the same User object to be passed between different controllers.
	 * The user can access the same properties in each scene.
	 * @param user This is the User object.
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * This method will display how many hours of sleep the user got throughout the night.
	 * The user can enter this information in the Sleep window.
	 * @param sleep This string is how much hours of sleep the user entered, taken from the Health class.
	 */
	public void updateSleepProgressLabel(String sleep) {
		// Updates the user's sleep progress label
		if (sleep == null) {
			sleepProgressLabel.setText("You have not entered any hours " + '\n' + "of sleep for today.");
		}
		if (sleep != null) {
			sleepProgressLabel.setText("You have entered " + sleep + " hours" + '\n' +  "of sleep for today.");
		}
		// Sets and stores the label in Health class
		user.health.setSleepProgressLabel(sleep);
	}

	/**
	 * This method will call a method that will update the user's hours slept label in the Sleep window.
	 */
	public void updateSleepValues() {
		if (sleepProgressLabel != null) {
			updateSleepProgressLabel(user.health.getSleepProgressLabel());
		}
	}
	
	/**
	 * This method will verify and store the amount of hours of sleep the user has entered and compare
	 * the value entered by the user to their sleep duration goal entered in the Goals window.
	 * @param trackSleepEvent This ActionEvent will display the amount of hours that the user slept throughout the night.
	 * @throws InvalidUserInputException This is the exception that will be thrown if the information is invalid.
	 */
	@FXML
	void setSleep(ActionEvent trackSleepEvent) throws InvalidUserInputException {
		// Initialize label to empty
		sleepErrorLabel.setText("");
		
		// sleepGoal is the goal entered by user, which is in health.
		double sleepGoal = user.health.getSleepGoals();
		
		try {
			//Checks user input
			user.health.checkInput(hoursSleep.getText());
		
			//Hours are set to be the string entered in the hoursSleep TextField.
			setSleepAmount(Double.parseDouble(hoursSleep.getText()));
		
			// Calculates and stores sleep progress
			int progressPercent = (int) ((getSleepAmount()/sleepGoal) * 100);

			// The label changes when the user enters a different value.
			updateSleepProgressLabel(String.valueOf(getSleepAmount()));
			sleepProgressBar.setProgress((getSleepAmount())/sleepGoal);

			// If the sleepGoal - getHours() == 0 or is <0, that means the user has reached their goal
			// and the label changes to let the user know.
			if (((sleepGoal - getSleepAmount()) == 0) || (((sleepGoal - getSleepAmount()) < 0))) {
				sleepProgressLabel.setText("You have reached your sleep goal!");
			}

			// If the sleepGoal - getHours() > 0, that means the user has not reached their goal, 
			// and is given a percent of how close they are. 
			if (sleepGoal - getSleepAmount() > 0) {
				sleepProgressLabel.setText( "You have reached " + progressPercent + "%" + " of your sleep goal.");
			}
		} catch (InvalidUserInputException e) {
			sleepErrorLabel.setText(e.getMessage());	
		}
	}
   /**
   	* This method will store the amount of sleep the user got through the night in the Fitness class.
	* @param sleep This is the number of hours user enters in hoursSleepTextField, and is stored in user.
	*/
	public void setSleepAmount(double sleep) {
		user.health.setSleepDuration(sleep);
	}

	/**
	 * This method is called to compare the hours to the goal, and update the label when user reopens the window.
	 * @return This getter method returns the number of hours the user has slept for.
	 */
	 public double getSleepAmount() {
		 return user.health.getSleepDuration();
	 }
	
	/**
	 * This ActionEvent changes the scene back to the main page while passing the same User
	 * object and setting various labels in the main page.
	 * @param returnToMainEvent Changes the scene back to the main page.
	 */
	@FXML
	void returnToMain(ActionEvent returnToMainEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerView.fxml"));
			FitnessTrackerController controller = (FitnessTrackerController)loader.getController();

			controller.applicationStage = applicationStage;
			controller.setUser(user);
			controller.setNameLabel();
			controller.setGoalsCompletedLabel();
			controller.setDisplayLabel();

			Scene scene = new Scene(root);
			applicationStage.setScene(scene);
			applicationStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}