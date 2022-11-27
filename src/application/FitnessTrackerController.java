package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FitnessTrackerController implements Initializable {
  Stage applicationStage;
  
	@FXML
	private TextField amountOfWater;
	
	@FXML 
	private Label waterProgress;
  
	@FXML
    private Label stepsGoalLabelDashboard;
	
	@FXML
	private Button goalsButton;
	
	@FXML
	private Label sleepDisplayLabel;
	
	@FXML
    private Button logOutButton;
	
	@FXML
    private Button userProfileButton;
	
	@FXML
    private ImageView profileImage;
	
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
		
		sleepDisplayLabel.setText(Storage.storage.getSleepGoals() + " h");


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
		try {
	   		   FXMLLoader loader = new FXMLLoader();
	   		   AnchorPane root = loader.load(new FileInputStream("src/application/Recipes.fxml"));
	   		   Recipes controller = (Recipes)loader.getController();
	   		  
	   		   controller.applicationStage = applicationStage;
	   		   
	   		   Scene scene = new Scene(root);
	   		   applicationStage.setScene(scene);
	   		   applicationStage.show();
	   	   } catch(Exception e) {
	   		   e.printStackTrace();
	   	   }
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
   
   @FXML
   void userLogOut(ActionEvent event) {
	   File f = new File("C:\\Users\\CS219-user\\Documents\\FitnessTrackerFile.txt");
		try {
			// If the file doesn't exist, we will create the file
			if (!f.exists()) {
				f.createNewFile();
			}
			// Write to the file
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Steps goal = " + Storage.storage.getStepsGoals());
			bw.write("Sleep goal = " + Storage.storage.getSleepGoals());
			bw.write("Water intake goal = " + Storage.storage.getWaterIntakeGoals());
			bw.write("Weight goal = " + Storage.storage.getWeightGoals());
			bw.write("Calories burned goal = " + Storage.storage.getCaloriesGoals());
			bw.write("Exercise goal = " + Storage.storage.getExerciseGoals());
			// Close BufferedWriter and FileWriter			
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("File cannot be created");
		}
	   applicationStage.close();

   }

   @Override
   public void initialize(URL location, ResourceBundle resources) {
	   //<a href="https://www.flaticon.com/free-icons/user" title="user icons">User icons created by Freepik - Flaticon</a>
   		Image userIconImage = new Image(getClass().getResourceAsStream("user.png"));
   		profileImage.setImage(userIconImage);
	   
}
}
