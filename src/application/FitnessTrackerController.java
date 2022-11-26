package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FitnessTrackerController {
	Stage applicationStage;
	
	@FXML
	private TextField amountOfWater;
	
	@FXML 
	private Label waterProgress;
  
	@FXML
    private Label stepsGoalLabelDashboard;
	
	@FXML
	private Button goalsButton;
	
	Storage storage = new Storage();
	
	public void setStorage(Storage storage) {
    	this.storage = storage;
    }
	
    @FXML
    void openUserProfile(ActionEvent event) {
    }

	@FXML
	void trackSteps(ActionEvent event) {
    }

	@FXML
	void trackSleep(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(new FileInputStream("src/application/UserSleepTracker.fxml"));
			UserSleepTrackerController controller = (UserSleepTrackerController)loader.getController();
			controller.applicationStage = applicationStage;
			Scene scene = new Scene(root);
			applicationStage.setScene(scene);
			applicationStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}


	}

	@FXML
	void trackNutrition(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(new FileInputStream("src/application/NutritionTracker.fxml"));
			NutritionTrackerController controller = (NutritionTrackerController)loader.getController();
			controller.applicationStage = applicationStage;

			Scene scene = new Scene(root);
			applicationStage.setScene(scene);
			applicationStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void trackActivities(ActionEvent event) {
		try {
	   		   FXMLLoader loader = new FXMLLoader();
	   		   Pane root = loader.load(new FileInputStream("src/application/FitnessTrackerActivity.fxml"));
	   		   ActivitiesController controller = (ActivitiesController)loader.getController();
	   		   
	   		   controller.setStorage(Storage.storage);
			   controller.updateTodaysExerciseValues();  
	   		   
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
    void trackWaterIntake(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(new FileInputStream("src/application/UserWaterIntake.fxml"));
			UserWaterIntakeController controller = (UserWaterIntakeController)loader.getController();
			controller.applicationStage = applicationStage;
			Scene scene = new Scene(root);
			applicationStage.setScene(scene);
			applicationStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
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
		   
		   controller.setStorage(Storage.storage);
		   controller.updateGoalValues();
		   
		   controller.applicationStage = applicationStage;
		   
		   Scene scene = new Scene(root);
		   applicationStage.setScene(scene);
		   applicationStage.show();
	   } catch(Exception e) {
		   e.printStackTrace();
	   }  
   }
}
