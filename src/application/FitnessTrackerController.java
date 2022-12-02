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
	
	@FXML
	private Label goalsCompletedLabel;
	
	User user;
	
	public void setUser(User user) {
    	this.user = user;
	}
	
	public void setGoalsCompletedLabel() {
    	goalsCompletedLabel.setText("You have completed " + (user.fitness.getGoalsCompleted() + user.health.getGoalsCompleted()) + " goal(s)!");
    }
	
    @FXML
    void openUserProfile(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			AnchorPane root = loader.load(new FileInputStream("src/application/UserProfile.fxml"));
			UserProfileController controller = (UserProfileController)loader.getController();
			controller.setUser(user);
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
	//	controller.setUser(user);
    }
	
	@FXML
	void trackSleep(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(new FileInputStream("src/application/UserSleepTracker.fxml"));
			SleepController controller = (SleepController)loader.getController();
			
			controller.setUser(user);
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
			NutritionController controller = (NutritionController)loader.getController();
			controller.applicationStage = applicationStage;
			controller.setUser(user);
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
	   		
	   		controller.setUser(user);
	   		System.out.println("Setting user for actviities controller from fitness");
	   		
	   		Date today = new Date();
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(today); 
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	    	if (dayOfWeek == Calendar.MONDAY) {
	    		controller.updateTodaysExerciseLabel(user.fitness.getMondayExerciseInfo());
	    	}
	    	if (dayOfWeek == Calendar.TUESDAY) {
	    		controller.updateTodaysExerciseLabel(user.fitness.getTuesdayExerciseInfo());
	    	}
	    	if (dayOfWeek == Calendar.WEDNESDAY) {
	    		controller.updateTodaysExerciseLabel(user.fitness.getWednesdayExerciseInfo());
	    	}
	    	if (dayOfWeek == Calendar.THURSDAY) {
	    		controller.updateTodaysExerciseLabel(user.fitness.getThursdayExerciseInfo());
	    	}
	    	if (dayOfWeek == Calendar.FRIDAY) {
	    		controller.updateTodaysExerciseLabel(user.fitness.getFridayExerciseInfo());
	    	}
	    	if (dayOfWeek == Calendar.SATURDAY) {
	    		controller.updateTodaysExerciseLabel(user.fitness.getSaturdayExerciseInfo());
	    	}
	    	if (dayOfWeek == Calendar.SUNDAY) {
	    		controller.updateTodaysExerciseLabel(user.fitness.getSundayExerciseInfo());
	    	}
	    	
			   controller.updateTotalCaloriesBurnedValues();
			   controller.updateProgressValue();
			   System.out.println(user.test);
	   		   
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
	   		   RecipesController controller = (RecipesController)loader.getController();
	   		controller.setUser(user);
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
			WaterIntakeController controller = (WaterIntakeController)loader.getController();
			
			controller.setUser(user);
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
		   GoalsController controller = (GoalsController)loader.getController();
		   
		   controller.setUser(user);
		   System.out.println("Setting user for goals controller from fitness");
		   controller.updateGoalValues();
		   System.out.println(user.test);
		   
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
