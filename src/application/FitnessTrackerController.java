package application;

import java.io.FileInputStream;
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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The FitnessTrackerController will display health and fitness related characters in the main window 
 * based on the values entered by the user.
 * Also, the user will be able to access every aspect of this application from this window.
 * This controller will check and display errors entered by the user, such as invalid characters
 * or those out of acceptable range.
 * 
 * @author Camila Hernandez, Mariam Masri & Enes Gisi
 * 
 */
public class FitnessTrackerController implements Initializable {
  Stage applicationStage;
  
	@FXML
	private TextField amountOfWater;
	
	@FXML 
	private Label waterProgress;
  
	@FXML
    public Label stepsThisMonth;
	
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
	private Label nameLabel;

	@FXML
	private Label dateLabel;

	@FXML
	private Label goalsCompletedLabel;
	
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
	 * This method sets the user's name in the main window.
	 */
	public void setNameLabel() {
		nameLabel.setText(user.getName());
	}

	/**
	 * This method displays how many overall goals the user has completed today.
	 */
	public void setGoalsCompletedLabel() {
    	goalsCompletedLabel.setText("You have completed " + (user.fitness.getGoalsCompleted() + user.health.getGoalsCompleted()) + " goal(s)!");
    }
	
	/**
	 * This ActionEvent will open a new scene where the user can view and modify their personal information,
	 * as well as log out of the application.
	 * @param userProfileEvent This ActionEvent will open a new scene to the user profile.
	 */
    @FXML
    void openUserProfile(ActionEvent userProfileEvent) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			AnchorPane root = loader.load(new FileInputStream("src/application/UserProfile.fxml"));
			UserProfileController controller = (UserProfileController)loader.getController();
			controller.setUser(user);
			controller.setUserProfileLabels();
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
		try {
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(new FileInputStream("src/application/StepsView.fxml"));
			StepsController controller = (StepsController)loader.getController();
			controller.setUser(user);
			controller.updateProgressBar(event);
			controller.setStepGoalLabel("Note: Default monthly step goal is set to 111,000 based on \n"
					+ "Mayoclinic recommendations. Current monthly goal is: " + user.fitness.getStepsGoals());
			controller.applicationStage = applicationStage;
			Scene scene = new Scene(root);
			applicationStage.setScene(scene);
			applicationStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	/**
	 * This ActionEvent will open a new scene where the user can track their sleep and compare their sleep duration
	 * to their goal.
	 * @param trackSleepEvent This ActionEvent will open a new scene to the Sleep window.
	 */
	@FXML
	void trackSleep(ActionEvent trackSleepEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(new FileInputStream("src/application/SleepTracker.fxml"));
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
	
	/**
	 * This ActionEvent will open a new scene where the user can track their nutrition and compare their weight goal
	 * to their current goal.
	 * @param trackNutritionEvent This ActionEvent will open a new scene to the Nutrition window.
	 */
	@FXML
	void trackNutrition(ActionEvent trackNutritionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(new FileInputStream("src/application/NutritionTracker.fxml"));
			NutritionController controller = (NutritionController)loader.getController();
			
			controller.setUser(user);
			
			controller.applicationStage = applicationStage;
			Scene scene = new Scene(root);
			applicationStage.setScene(scene);
			applicationStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This ActionEvent will open a new scene where the user can track their workouts and view their
	 * weekly statistics.
	 * @param trackActivitiesEvent This ActionEvent will open a new scene to the Activities window.
	 */
	@FXML
	void trackActivities(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
	   		AnchorPane root = loader.load(new FileInputStream("src/application/FitnessTrackerActivity.fxml"));
	   		ActivitiesController controller = (ActivitiesController)loader.getController();
	   		
	   		controller.setUser(user);
	   		
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
	   		   
	   		   controller.applicationStage = applicationStage;
	   		   
	   		   Scene scene = new Scene(root);
	   		   applicationStage.setScene(scene);
	   		   applicationStage.show();
	   	   } catch(Exception e) {
	   		   e.printStackTrace();
	   	   }
	}
	
	/**
	 * This ActionEvent will open a new scene where the user can view healthy recipes.
	 * @param userProfileEvent This ActionEvent will open a new scene to the Recipes window.
	 */
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
	
	/**
	 * This ActionEvent will open a new scene where the user can track and compare their daily water in-take amount to
	 * their goal set in the Goals window.
	 * @param userProfileEvent This ActionEvent will open a new scene to the Water In-take window.
	 */
	@FXML
    void trackWaterIntake(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(new FileInputStream("src/application/WaterIntake.fxml"));
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
	
	/**
	 * This method will display progress labels with regards water in-take, sleep duration and monthly steps.
	 */
	public void setDisplayLabel() {
		waterProgressIndicator.setProgress(user.health.getWaterIntakeAmount()/user.health.getWaterIntakeGoals());
		sleepDisplayLabel.setText(user.health.getSleepDuration() + " h");
		stepsThisMonth.setText(Integer.toString(user.fitness.getStepsCount()));
	}
   
	/**
	 * This ActionEvent will open a new scene where the user can view and modify their health and fitness goals.
	 * @param fitnessGoalsEvent This ActionEvent will open a new scene to the Health and Fitness Goals window.
	 */
   @FXML
   	void showUserFitnessGoals(ActionEvent fitnessGoalsEvent) {
	   try {		   
		   FXMLLoader loader = new FXMLLoader();
		   AnchorPane root = loader.load(new FileInputStream("src/application/FitnessTrackerGoalsView.fxml"));
		   GoalsController controller = (GoalsController)loader.getController();
		   
		   controller.setUser(user);
		   controller.updateGoalValues();
		   
		   controller.applicationStage = applicationStage;
		   
		   Scene scene = new Scene(root);
		   applicationStage.setScene(scene);
		   applicationStage.show();
	   } catch(Exception e) {
		   e.printStackTrace();
	   }  
   }
   
   /**
    * This method sets imported images and the current date label in the main window.
    */
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