package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FitnessTrackerController {
	Stage applicationStage;
	
	@FXML

	private TextField amountOfWater;
	
	@FXML 
	private Label waterProgress;
  
  @FXML
	private Button goalsButton;

	
    @FXML
    void openUserProfile(ActionEvent event) {

    }

    @FXML
    void trackSteps(ActionEvent event) {

    }

    @FXML
    void trackSleep(ActionEvent event) {

    }
    
    @FXML
    void trackWaterIntake(ActionEvent event) {
    
	}

    @FXML
    void trackNutrition(ActionEvent event) {

    }

    @FXML
    void trackActivities(ActionEvent event) {
    	try {
   		   FXMLLoader loader = new FXMLLoader();
   		   Pane root = loader.load(new FileInputStream("src/application/FitnessTrackerActivity.fxml"));
   		   ActivitiesController controller = (ActivitiesController)loader.getController();
   		   controller.applicationStage = applicationStage;
   		   
   		   Scene scene = new Scene(root);
   		   applicationStage.setScene(scene);
   		   applicationStage.show();
   	   } catch(Exception e) {
   		   e.printStackTrace();
   	   }
    }

    @FXML
    void showHealthyRecipes(ActionEvent event) {
    	
    }
    

    @FXML
    void calculateAmountWater(ActionEvent progressWaterEvent) {
    	Double liters = Double.parseDouble(amountOfWater.getText());
    	Double waterGoal = 7.0;
    	waterProgress.setText("You are " + (waterGoal - liters) + " L away from your goal.");
    	
    	
    }
    
    @FXML
    void trackWaterIntake(ActionEvent setWaterIntakeEvent) {

    	try {
			FXMLLoader loader = new FXMLLoader();
    	    BorderPane root = loader.load(new FileInputStream("src/application/UserWaterIntake.fxml"));
    	    FitnessTrackerController controller = (FitnessTrackerController)loader.getController();
    	    controller.applicationStage = applicationStage;
    	    Scene scene = new Scene(root);
    	    applicationStage.setScene(scene);
    	    applicationStage.show();
    	  } catch (IOException e) {
    		  
    	  }
    	
    }

    @FXML
    void showRecommendations(ActionEvent event) {

    }
    
    
   @FXML
   void showUserFitnessGoals(ActionEvent event) {
	   try {
		   FXMLLoader loader = new FXMLLoader();
		   AnchorPane root = loader.load(new FileInputStream("src/application/FitnessTrackerGoalsView.fxml"));
		   UserGoalsDisplay controller = (UserGoalsDisplay)loader.getController();
		   controller.applicationStage = applicationStage;
		   
		   Scene scene = new Scene(root);
		   applicationStage.setScene(scene);
		   applicationStage.show();
	   } catch(Exception e) {
		   e.printStackTrace();
	   }
	   
   }
}
    	