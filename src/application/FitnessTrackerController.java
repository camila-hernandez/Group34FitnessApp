package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
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

	private ProgressIndicator waterProgressIndicator;
  @FXML
    private Button userProfileButton;
	
	@FXML
    private ImageView profileImage;
	
	@FXML
	private Label dateLabel;
	
	Storage storage = new Storage();
	
	public void setStorage(Storage storage) {
    	this.storage = storage;
	}
	
    @FXML
    void openUserProfile(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			AnchorPane root = loader.load(new FileInputStream("src/application/UserProfile.fxml"));
			UserProfile controller = (UserProfile)loader.getController();
			controller.applicationStage = applicationStage;
			Scene scene = new Scene(root);
			applicationStage.setScene(scene);
			applicationStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
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
			
			controller.setStorage(Storage.storage);
			controller.updateSleepValues();
			
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
	   		   
	   		Date today = new Date();
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(today); 
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	    	if (dayOfWeek == Calendar.MONDAY) {
	    		controller.updateTodaysExerciseLabel(Storage.storage.getMondayExerciseInfo());
	    	}
	    	if (dayOfWeek == Calendar.TUESDAY) {
	    		controller.updateTodaysExerciseLabel(Storage.storage.getTuesdayExerciseInfo());
	    	}
	    	if (dayOfWeek == Calendar.WEDNESDAY) {
	    		controller.updateTodaysExerciseLabel(Storage.storage.getWednesdayExerciseInfo());
	    	}
	    	if (dayOfWeek == Calendar.THURSDAY) {
	    		controller.updateTodaysExerciseLabel(Storage.storage.getThursdayExerciseInfo());
	    	}
	    	if (dayOfWeek == Calendar.FRIDAY) {
	    		controller.updateTodaysExerciseLabel(Storage.storage.getFridayExerciseInfo());
	    	}
	    	if (dayOfWeek == Calendar.SATURDAY) {
	    		controller.updateTodaysExerciseLabel(Storage.storage.getSaturdayExerciseInfo());
	    	}
	    	if (dayOfWeek == Calendar.SUNDAY) {
	    		controller.updateTodaysExerciseLabel(Storage.storage.getSundayExerciseInfo());
	    	}
	    	
	   		   controller.setStorage(Storage.storage);
			  // controller.updateTodaysExerciseValues();
			   
			  // controller.updateTodaysExerciseLabel(Storage.storage.getProgressValue());
			   controller.updateTotalCaloriesBurnedValues();
			   controller.updateProgressValue();
	   		   
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
			
			controller.setStorage(Storage.storage);
			controller.updateWaterValues();

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


   @Override
   public void initialize(URL location, ResourceBundle resources) {
	   //<a href="https://www.flaticon.com/free-icons/user" title="user icons">User icons created by Freepik - Flaticon</a>
   		Image userIconImage = new Image(getClass().getResourceAsStream("user.png"));
   		profileImage.setImage(userIconImage);
   		
   		// Sets current date
   		LocalDateTime currentDateTime = LocalDateTime.now();
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, MMM dd yyyy");
    	String formattedDate = currentDateTime.format(dtf);
    	dateLabel.setText(formattedDate);
	   
   }
}
