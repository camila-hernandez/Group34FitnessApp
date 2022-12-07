package application;

import java.io.FileInputStream;
import java.net.URL;
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

public class StepsController implements Initializable {
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
    
    /**
     * This ActionEvent will display the user's overall steps taken count for the month in the main window.
     * @param updateStepsEvent
     * @throws InvalidUserInputException
     */
    @FXML
    void updateStepsNumber(ActionEvent updateStepsEvent) throws InvalidUserInputException {
    	try {
    		user.fitness.setStepsCount(Integer.parseInt(stepsTextField.getText()));
    	user.fitness.updateMonthlySteps(dayOfMonth.getValue(), stepsTextField.getText());
    	}catch(InvalidUserInputException e) {stepsErrorLabel.setText(e.getMessage());}
    	 catch(NullPointerException npe) {dayOfMonthErrorLabel.setText("Please select a day");}
    	
    	//stepsProgressBar;
    	
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
	   
 	   
 	 