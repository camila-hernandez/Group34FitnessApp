package application;

import java.io.FileInputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StepsController implements Initializable{
	Stage applicationStage;
    
    //@FXML
    //private Label stepsCountLabel;
    
    @FXML
    private ChoiceBox<Integer> dayOfMonth;
    
    @FXML
    private TextField stepsTextField;
   
    @FXML
    private Label stepsErrorLabel;
    
    @FXML
    private Label dayOfMonthErrorLabel;
    
    @FXML
    private Label progressLyrics;
    
    @FXML
    private Label percentageLabel;
    
    @FXML
    private Label stepGoalLabel;
    
    @FXML
    private ImageView stepsIcon;
    
    @FXML
    private ProgressBar stepsProgressBar;
    
    
    User user;
    
    /**
	 * This method will allow for the same User object to be passed between different controllers.
	 * The user can access the same properties in each scene.
	 * @param user This is the User object.
	 */
    public void setUser(User user) {
    	this.user = user;
    }
    
    private static final DecimalFormat df = new DecimalFormat("0.00");
    
    /**
     * This ActionEvent will display the user's overall steps taken count for the month in the main window.
     * @param updateStepsEvent
     * @throws InvalidUserInputException
     */
    @FXML
    void updateStepsNumber(ActionEvent event) throws InvalidUserInputException {
    	try {
        	if(dayOfMonth.getValue()!=null)
            	dayOfMonthErrorLabel.setText("");
    	user.fitness.updateMonthlySteps(dayOfMonth.getValue(), stepsTextField.getText());
    	stepsErrorLabel.setText("");

    	}catch(InvalidUserInputException e) {stepsErrorLabel.setText(e.getMessage());}
    	 catch(NullPointerException npe) {dayOfMonthErrorLabel.setText("Please select a day");}
    	updateProgressBar(event);
    }
    
    void updateProgressBar(ActionEvent event) {
    	if (user.fitness.getStepsGoals() != 0) {
    		stepsProgressBar.setProgress((double)user.fitness.getStepsCount()/user.fitness.getStepsGoals());
    		double goalPercentage = (double)user.fitness.getStepsCount()/user.fitness.getStepsGoals();
    		percentageLabel.setText(df.format(goalPercentage * 100) + "%");
	    	//0-20%
	    	if (goalPercentage < 0.2) {
	    		progressLyrics.setText(String.valueOf("Rising up straight to the top"));
	    	}
	    	//20-40%
	    	if (goalPercentage >= 0.2 && goalPercentage < 0.4) {
	    		progressLyrics.setText(String.valueOf("Had the guts, got the glory"));
	    	}
	    	//40-60%
	    	if (goalPercentage >= 0.4 && goalPercentage < 0.6) {
	    		progressLyrics.setText(String.valueOf("Went the distance, now I'm not going to stop"));
	    	}
	    	//60-80%
	    	if (goalPercentage >= 0.6 && goalPercentage < 0.8) {
	    		progressLyrics.setText(String.valueOf("Just a man and his will to survive"));
	    	}
	    	//80-infinity%
	    	if (goalPercentage >= 0.8) {
	    		progressLyrics.setText(String.valueOf("IT'S THE EYE OF THE TIGER"));
	    	}
    	}
    	else {percentageLabel.setText("Please set your monthly steps goal first.");
    		  progressLyrics.setText("");
    	}
    }
    
    public void setStepGoalLabel(String labelMessage) {
    	stepGoalLabel.setText(labelMessage);
    }
    
    /**
	 * This ActionEvent changes the scene back to the main page while passing the same User
	 * object and setting various labels in the main page.
	 * @param returnToMainPageEvent Changes the scene back to the main page.
	 */
    @FXML
    void returnToMainPage(ActionEvent returnToMainPageEvent) {
     	 try {
    		   FXMLLoader loader = new FXMLLoader();
    		   BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerView.fxml"));
    		   FitnessTrackerController controller = (FitnessTrackerController)loader.getController();
    		   
    		   controller.setUser(user);
    		   controller.setGoalsCompletedLabel();
    		   controller.setNameLabel();
    		   controller.stepsThisMonth.setText(String.valueOf(user.fitness.getStepsCount()));
    		   
    		   controller.applicationStage = applicationStage;
    		   
    		   Scene scene = new Scene(root);
    		   applicationStage.setScene(scene);
    		   applicationStage.show();
    		   
    		
    	   } catch(Exception e) {
    		   e.printStackTrace();
    	   }
    }
    
    /**
     * This method allows pictures imported from the same directory to appear in the Steps window.
     * This method allows imported pictures to appear in the Steps window.
     */
     @Override
 	public void initialize(URL location, ResourceBundle resources) {
    	 //Image attribute:
    	 //<a href="https://www.freepik.com/free-vector/modern-sport-sneakers-blue-color-with-white-shoelaces-realistic-single-image-white-background-isolated-illustration_7251220.htm#query=walking%20shoes&position=3&from_view=keyword">Image by macrovector</a> on Freepik

     	// Loads image onto steps rectangle
     	Image stepsIconVector = new Image(getClass().getResourceAsStream("shoessteps.jpg"));
     	stepsIcon.setImage(stepsIconVector);

 	}

}
	   
 	   
 	 