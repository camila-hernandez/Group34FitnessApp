package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StepsController{
	Stage applicationStage;
    
    //@FXML
    //private Label stepsCountLabel;
    
    @FXML
    private ChoiceBox<Integer> dayOfMonth;
    
    @FXML
    private TextField stepsTextField;
   
    @FXML
    private Label stepsErrorLabel;
    
    private boolean isNumeric = false;
    
    User user;
    
    public void setUser(User user) {
    	this.user = user;
    }
    
    @FXML
    void updateStepsNumber(ActionEvent event) throws InvalidUserInputException {
    	try {
    	user.fitness.updateMonthlySteps(dayOfMonth.getValue(), stepsTextField.getText());
    	isNumeric = true;
    	}catch(InvalidUserInputException e) {stepsErrorLabel.setText(e.getMessage());}

    	
    }
    
    @FXML
    void returnToMainPage(ActionEvent event) {
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

}
	   
 	   
 	 