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
 * that are unique to the user based on the values entered by the user. The SleepController will compare 
 * and display the users input as hours to their set goal. Also, this controller will check and 
 * display errors entered by the user, such as invalid characters or those out of acceptable range.
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
	 * This method willWhen user opens sleep window, the program will first look to see if any sleep was previously entered.  
	 * @param sleep is how much hours the user entered.
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

	// when the sleep window is opened, values will be updated if any were previously entered. 
	public void updateSleepValues() {
		if (sleepProgressLabel != null) {
			updateSleepProgressLabel(user.health.getSleepProgressLabel());
		}
	}
	
	
	/**
	 * when the button is pressed the method set sleep gets the value entered, and compares it to the goal. 
	 * @param trackSleepEvent when the button update sleep is pressed.
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
	 * 
	 * @param sleep is the number of hours user enters in hoursSleepTextField, and is stored in user.
	 */
	public void setSleepAmount(double sleep) {
		user.health.setSleepDuration(sleep);
	}

	// getSleep() is called to compare the hours to the goal, and update the label when user reopens the window. 
	public double getSleepAmount() {
		return user.health.getSleepDuration();
	}
	
	/**
	 * This ActionEvent changes the scene back to the main page while passing the same User
	 * object and setting various labels in the main page.
	 * @param returnToMainPageEvent Changes the scene back to the main page.
	 */
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