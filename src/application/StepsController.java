package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StepsController {
	Stage applicationStage;
	
    private Steps stepsCount;
    
    @FXML
    private Label stepsCountLabel;
    
    @FXML
    private TextField stepsTextField;
    
    User user;
    
    public void setUser(User user) {
    	this.user = user;
    }
    
    @FXML
    void updateStepsNumber(ActionEvent event) {
    	stepsCount.setStepsCount(stepsTextField.getText());  		
    	
    }
    
    @FXML
    void returnToMainPage(ActionEvent event) {
    	 //UPDATE MAIN PAGE STEPS LABEL HERE
    	//
    	//
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
	   
 	   
 	 