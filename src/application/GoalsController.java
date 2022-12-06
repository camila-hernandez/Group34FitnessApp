package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * The GoalsController will verify and store a set of characteristics that are related to the user's health 
 * and fitness goals that are unique to them based on the values entered.
 * This controller will check and display errors entered by the user, such as invalid characters
 * or those out of acceptable range.
 * 
 * @author Camila Hernandez, Mariam Masri & Enes Gisi
 *
 */
public class GoalsController {
	 Stage applicationStage;

    @FXML
    private Label caloriesBurnedGoalsLabel;

    @FXML
    private Label sleepGoalsLabel;

    @FXML
    private Button updateGoalsButton;

    @FXML
    private Label stepGoalsLabel;

    @FXML
    private Label waterIntakeGoalsLabel;

    @FXML
    private Label weightGoalsLabel;

    @FXML
    private Label exerciseGoalsLabel;

    @FXML
    private Button homeButton;
    
    User user;
    
    Label goalsErrorLabel = new Label();
    
    /**
	 * This method will allow for the same User object to be passed between different controllers.
	 * The user can access the same properties in each scene.
	 * @param user This is the User object.
	 */
    public void setUser(User user) {
    	this.user = user;
    }
    
    // Setting font for all labels
    // Display user health and fitness goals based on their input
    Font newLabelFont = Font.font("System", 24);
    
    /**
     * This method updates the steps goal label in the Goals window.
     * The user inputs their information in the Update Goals tab in the Goals window.
     * @param steps This integer must consist of only whole numbers greater than zero.
     * @throws InvalidUserInputException This is the exception that will be thrown if the information is invalid.
     */
    public void updateStepsGoalsLabel(int steps) throws InvalidUserInputException {
    	stepGoalsLabel.setFont(newLabelFont);
 		stepGoalsLabel.setText(String.format(steps + " steps"));
 		user.fitness.setStepsGoals(steps);
    }
    
    /**
     * This method updates the sleep duration (in hours) goal label in the Goals window.
     * The user inputs their information in the Update Goals tab in the Goals window.
     * @param sleep This integer must consist of only whole numbers greater than zero.
     * @throws InvalidUserInputException This is the exception that will be thrown if the information is invalid.
     */
    public void updateSleepGoalsLabel(double sleep) {
    	sleepGoalsLabel.setFont(newLabelFont);
    	sleepGoalsLabel.setText(String.format(sleep + " hours"));
    	user.health.setSleepGoals(sleep);
    }
    
    /**
     * This method updates the water in-take (in cups) goal label in the Goals window.
     * The user inputs their information in the Update Goals tab in the Goals window.
     * @param water This integer must consist of only whole numbers greater than zero.
     * @throws InvalidUserInputException This is the exception that will be thrown if the information is invalid.
     */
    public void updateWaterIntakeGoalsLabel(double water) {
    	waterIntakeGoalsLabel.setFont(newLabelFont);
    	waterIntakeGoalsLabel.setText(String.format(water + " cups"));
    	user.health.setWaterIntakeGoals(water);
    }
    
    /**
     * This method updates the weight (in kilograms) goal label in the Goals window.
     * The user inputs their information in the Update Goals tab in the Goals window.
     * @param weight This integer must consist of only whole numbers greater than zero.
     * @throws InvalidUserInputException This is the exception that will be thrown if the information is invalid.
     */
    public void updateWeightGoalsLabel(double weight) {
    	weightGoalsLabel.setFont(newLabelFont);
    	weightGoalsLabel.setText(String.format(weight + " kg"));
    	user.health.setWeightGoals(weight);
    }
    
    /**
     * This method updates the calories burned (in cal) goal label in the Goals window.
     * The user inputs their information in the Update Goals tab in the Goals window.
     * @param calories This integer must consist of only whole numbers greater than zero.
     * @throws InvalidUserInputException This is the exception that will be thrown if the information is invalid.
     */
    public void updateCaloriesBurnedGoalsLabel(double calories) {
    	caloriesBurnedGoalsLabel.setFont(newLabelFont);
    	caloriesBurnedGoalsLabel.setText(calories + " cal");
    	user.fitness.setCaloriesGoals(calories);
    	caloriesBurnedGoalsLabel.setAlignment(Pos.CENTER);
    }
    
    /**
     * This method updates the exercise duration goal label in the Goals window.
     * The user inputs their information in the Update Goals tab in the Goals window.
     * @param exercie This integer must consist of only whole numbers greater than zero.
     * @throws InvalidUserInputException This is the exception that will be thrown if the information is invalid.
     */
    public void updateExerciseGoalsLabel(double exercise) {
    	exerciseGoalsLabel.setFont(newLabelFont);
    	exerciseGoalsLabel.setText(exercise + " minutes");
    	user.fitness.setExerciseGoals(exercise);
    	exerciseGoalsLabel.setAlignment(Pos.CENTER);
    }
    
    /**
     * This method updates the user's health and fitness goals labels in the Goals window.
     * This updates every time the user opens the application.
     * The user inputs their information in the Update Goals tab in the Goals window.
     * @throws InvalidUserInputException This is the exception that will be thrown if the information is invalid.
     */
    public void updateGoalValues() throws InvalidUserInputException {
    	if (stepGoalsLabel != null) {
    		updateStepsGoalsLabel(user.fitness.getStepsGoals());
    	}
    	if (sleepGoalsLabel != null) {
    		updateSleepGoalsLabel(user.health.getSleepGoals());
    	}
    	if (waterIntakeGoalsLabel != null) {
    		updateWaterIntakeGoalsLabel(user.health.getWaterIntakeGoals());
    	}
    	if (weightGoalsLabel != null) {
    		updateWeightGoalsLabel(user.health.getWeightGoals());
    	}
    	if (caloriesBurnedGoalsLabel != null) {
    		updateCaloriesBurnedGoalsLabel(user.fitness.getCaloriesGoals());
    	}
    	if (exerciseGoalsLabel != null) {
    		updateExerciseGoalsLabel(user.fitness.getExerciseGoals());
    	}
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
  		   controller.setNameLabel();
  		   controller.setGoalsCompletedLabel();

  		   controller.applicationStage = applicationStage;
  		   
  		   Scene scene = new Scene(root);
  		   applicationStage.setScene(scene);
  		   applicationStage.show();
  		   
  		
  	   } catch(Exception e) {
  		   e.printStackTrace();
  	   }
    }

    /**
     * This method will create a new scene where the user can input their health and fitness goals, 
     * such as steps, weight, etc.
     * This is crucial to progressing through the user's fitness journey.
     * The user can input this information in the Goals window.
     * @param updateGoalEvent This ActionEvent will store and update the user's health and fitness goals.
     * @throws InvalidUserInputException This is the exception that will be thrown if the information is invalid.
     */
    @FXML
    void updateFitnessGoals(ActionEvent updateGoalsEvent) throws InvalidUserInputException {
 	   Scene displayUserFitnessGoalsScene = applicationStage.getScene();
	   
 	   // Create new scene that displays the user's health and fitness goals
 	   VBox updateFitnessGoalsContainer = new VBox();
 	   updateFitnessGoalsContainer.setStyle("-fx-background-color: white");
 	   
 	   // Create header title
 	   StackPane updateStack = new StackPane();
 	   
 	   Rectangle updateHeaderRectangle = new Rectangle(87, 58, 435, 93);
 	   updateHeaderRectangle.setFill(Color.LIGHTBLUE);
 	   updateHeaderRectangle.setArcHeight(20);
 	   updateHeaderRectangle.setArcWidth(20);
 	   
 	   Label updateFitnessGoalsLabel = new Label("UPDATE HEALTH AND FITNESS GOALS");
 	   updateFitnessGoalsLabel.setTextFill(Color.WHITE);
 	   Font font = Font.font("System", FontWeight.BOLD, 22);
 	   updateFitnessGoalsLabel.setFont(font);
 	   
 	   updateStack.getChildren().addAll(updateHeaderRectangle, updateFitnessGoalsLabel);
 	   updateStack.setPadding(new Insets(25,0,25,0));
 	   
 	   // Create error label
 	   VBox errorLabelContainer = new VBox();
 	   Label goalsErrorLabel = new Label("");
 	   Font errorLabelFont = Font.font("System", 16);
 	   goalsErrorLabel.setFont(errorLabelFont);
 	   goalsErrorLabel.setTextFill(Color.RED);
 	   errorLabelContainer.getChildren().add(goalsErrorLabel);
 	   errorLabelContainer.setAlignment(Pos.CENTER);
 	   
 	   // Create steps container
 	   HBox updateStepsGoalsContainer = new HBox();
 	   Label updateStepsGoalsLabel = new Label("STEPS GOALS:");
 	   Font labelFont = Font.font("System", FontWeight.BOLD, 24);
 	   updateStepsGoalsLabel.setFont(labelFont);
 	   updateStepsGoalsLabel.setTextFill(Color.LIGHTBLUE);
 	   updateStepsGoalsLabel.setPadding(new Insets(25, 0, 25, 0));
 	   TextField stepsGoalsTextfield = new TextField();
 	   stepsGoalsTextfield.setMinWidth(259);
 	   stepsGoalsTextfield.setMinHeight(51);
 	   updateStepsGoalsContainer.getChildren().addAll(updateStepsGoalsLabel, stepsGoalsTextfield);
 	   updateStepsGoalsContainer.setAlignment(Pos.CENTER);
 	   updateStepsGoalsContainer.setSpacing(20);
 	   
 	   // Create sleep container
 	   HBox updateSleepGoalsContainer = new HBox();
 	   Label updateSleepGoalsLabel = new Label("SLEEP GOALS:");
 	   updateSleepGoalsLabel.setFont(labelFont);
 	   updateSleepGoalsLabel.setTextFill(Color.LIGHTBLUE);
 	   updateSleepGoalsLabel.setPadding(new Insets(25, 5, 25, 0));
 	   TextField sleepGoalsTextfield = new TextField();
 	   sleepGoalsTextfield.setMinWidth(254);
 	   sleepGoalsTextfield.setMinHeight(51);
 	   updateSleepGoalsContainer.getChildren().addAll(updateSleepGoalsLabel, sleepGoalsTextfield);
 	   updateSleepGoalsContainer.setAlignment(Pos.CENTER);
 	   updateSleepGoalsContainer.setSpacing(20);
 	   
 	   // Create water in-take container
 	   HBox updateWaterIntakeGoalsContainer = new HBox();
 	   Label updateWaterIntakeGoalsLabel = new Label("WATER INTAKE GOALS:");
 	   updateWaterIntakeGoalsLabel.setTextFill(Color.LIGHTBLUE);
 	   updateWaterIntakeGoalsLabel.setPadding(new Insets(25, 0, 25, 0));
 	   updateWaterIntakeGoalsLabel.setFont(labelFont);
 	   TextField waterIntakeGoalsTextfield = new TextField();
 	   waterIntakeGoalsTextfield.setMinWidth(152);
 	   waterIntakeGoalsTextfield.setMinHeight(51);
 	   updateWaterIntakeGoalsContainer.getChildren().addAll(updateWaterIntakeGoalsLabel, waterIntakeGoalsTextfield);
 	   updateWaterIntakeGoalsContainer.setAlignment(Pos.CENTER);
 	   updateWaterIntakeGoalsContainer.setSpacing(20);
 	   
 	   // Create nutrition container
 	   Label updateNutritionGoalsLabel = new Label("NUTRITION GOALS:");
 	   updateNutritionGoalsLabel.setTextFill(Color.LIGHTBLUE);
 	   updateNutritionGoalsLabel.setPadding(new Insets(25, 0, 10, 90));
 	   updateNutritionGoalsLabel.setMinSize(224, 35);
 	   updateNutritionGoalsLabel.setFont(labelFont);
 		
 	   HBox updateNutritionGoalsContainer = new HBox();
 	   Label updateWeightGoalsLabel = new Label("What is your weight goal (in kg)?");
 	   updateWeightGoalsLabel.setPadding(new Insets(0, 0, 0, 0));
 	   Font textFont = Font.font("System", 18);
 	   updateWeightGoalsLabel.setFont(textFont);
 	   TextField weightGoalsTextfield = new TextField();
 	   weightGoalsTextfield.setMinSize(150, 51);
 	   updateNutritionGoalsContainer.getChildren().addAll(updateWeightGoalsLabel, weightGoalsTextfield);
 	   updateNutritionGoalsContainer.setAlignment(Pos.CENTER);
 	   updateNutritionGoalsContainer.setSpacing(20);
 	   
 	   // Create exercise container
 	   Label updateExerciseGoalsLabel = new Label("EXERCISE GOALS:");
 	   updateExerciseGoalsLabel.setPadding(new Insets(25, 0, 15, 90));
 	   updateExerciseGoalsLabel.setTextFill(Color.LIGHTBLUE);
 	   updateExerciseGoalsLabel.setMinSize(224, 35);
 	   updateExerciseGoalsLabel.setFont(labelFont);
 		
 	   VBox updateExerciseGoalsContainer = new VBox();
 	   Label updateExerciseDurationGoalsLabel = new Label("How long would you like to exercise (in minutes)?");
 	   updateExerciseDurationGoalsLabel.setPadding(new Insets(0, 32, 5, 0));
 	   updateExerciseDurationGoalsLabel.setFont(textFont);
 	   TextField exerciseDurationGoalsTextfield = new TextField();
 	   exerciseDurationGoalsTextfield.setMinSize(298, 51);
 	   exerciseDurationGoalsTextfield.setAlignment(Pos.CENTER);
 	   updateExerciseGoalsContainer.getChildren().addAll(updateExerciseDurationGoalsLabel, exerciseDurationGoalsTextfield);
 	   updateExerciseGoalsContainer.setAlignment(Pos.CENTER);
 	   
 	   // Create calories burned container
 	   VBox updateCaloriesGoalsContainer = new VBox();
 	   Label updateCaloriesBurnedGoalsLabel = new Label("How many calories would you like to burn in a day?");
 	   updateCaloriesBurnedGoalsLabel.setPadding(new Insets(0, 15, 5, 0));
 	   updateCaloriesBurnedGoalsLabel.setFont(textFont);
 	   TextField caloriesBurnedGoalsTextfield = new TextField();
 	   caloriesBurnedGoalsTextfield.setMinSize(298, 51);
 	   caloriesBurnedGoalsTextfield.setAlignment(Pos.CENTER);
 	   updateCaloriesGoalsContainer.getChildren().addAll(updateCaloriesBurnedGoalsLabel, caloriesBurnedGoalsTextfield);
 	   updateCaloriesGoalsContainer.setAlignment(Pos.CENTER);
 	   
 	   // Create buttons container
 	   HBox updateButtonContainer = new HBox();
 	   
 	   Button saveChangesGoalsButton = new Button("SAVE CHANGES");
 	   saveChangesGoalsButton.setMinSize(177, 44);
 	   saveChangesGoalsButton.setTextFill(Color.WHITE);
 	   saveChangesGoalsButton.setFont(labelFont);
 	   saveChangesGoalsButton.setStyle("-fx-background-color: LIGHTBLUE");
 	   saveChangesGoalsButton.setOnAction(saveChangesGoalsEvent -> {
				try {
					// Checks user input
					// Updates each label in the Goals window
					// Sets each goal in Fitness class
					user.fitness.checkInput(stepsGoalsTextfield.getText());
					updateStepsGoalsLabel(Integer.parseInt(stepsGoalsTextfield.getText()));
					setStepsGoals(Integer.parseInt(stepsGoalsTextfield.getText()));
		    		user.health.checkInput(sleepGoalsTextfield.getText());
		    		updateSleepGoalsLabel(Double.parseDouble(sleepGoalsTextfield.getText()));
		    		setSleepGoals(sleepGoalsTextfield.getText());
		    		user.health.checkInput(waterIntakeGoalsTextfield.getText());
		    		updateWaterIntakeGoalsLabel(Double.parseDouble(waterIntakeGoalsTextfield.getText()));
		    		setWaterIntakeGoals(Double.parseDouble(waterIntakeGoalsTextfield.getText()));
		    		user.health.checkInput(weightGoalsTextfield.getText());
		    		updateWeightGoalsLabel(Double.parseDouble(weightGoalsTextfield.getText()));
		    		setWeightGoals(Double.parseDouble(weightGoalsTextfield.getText()));
		    		user.fitness.checkInput(caloriesBurnedGoalsTextfield.getText());
		    		updateCaloriesBurnedGoalsLabel(Double.parseDouble(caloriesBurnedGoalsTextfield.getText()));
		    		setCaloriesGoals(Double.parseDouble(caloriesBurnedGoalsTextfield.getText()));
		    		user.fitness.checkInput(exerciseDurationGoalsTextfield.getText());
		    		updateExerciseGoalsLabel(Double.parseDouble(exerciseDurationGoalsTextfield.getText()));
		    		setExerciseGoals(Double.parseDouble(exerciseDurationGoalsTextfield.getText()));
		    		applicationStage.setScene(displayUserFitnessGoalsScene);
		        	} catch (InvalidUserInputException e) {
		        		goalsErrorLabel.setText(e.getMessage());
		        	}
 	   	});
 	   
 	   // Adjusts button characteristics
 	   updateButtonContainer.getChildren().add(saveChangesGoalsButton);
 	   updateButtonContainer.setAlignment(Pos.CENTER);
 	   updateButtonContainer.setPadding(new Insets(10,0,0,0));
 		
 	   // Adds all containers into one container
 	   updateFitnessGoalsContainer.getChildren().addAll(updateStack, errorLabelContainer, updateStepsGoalsContainer, updateSleepGoalsContainer, updateWaterIntakeGoalsContainer,
 				updateNutritionGoalsLabel, updateNutritionGoalsContainer, updateExerciseGoalsLabel, updateExerciseGoalsContainer, updateCaloriesGoalsContainer, updateButtonContainer);
 		
 	   // Creates and sets a new scene
 	   Scene updatedUserFitnessGoalsScene = new Scene(updateFitnessGoalsContainer, 609, 856);
 	   applicationStage.setScene(updatedUserFitnessGoalsScene);	  	  
    }
    
    /**
     * This method will set the user's input from the steps TextField into the Fitness class.
     * @param steps This is how many steps the user would like to take in a day.
     */
    public void setStepsGoals(int steps) {
    	user.fitness.setStepsGoals(steps);
    }
    
    /**
     * This method will set the user's input from the sleep TextField into the Fitness class.
     * @param sleep This is how many hours of sleep the user would like to get during the night.
     */
    public void setSleepGoals(String sleep) {
    	user.health.setSleepGoals(Double.parseDouble(sleep));
    }
    
    /**
     * This method will set the user's input from the water in-take TextField into the Fitness class.
     * @param water This is how many cups of water the user would like to drink a day.
     */
    public void setWaterIntakeGoals(double water) {
    	user.health.setWaterIntakeGoals(water);
    }
    
    /**
     * This method will set the user's input from the weight TextField into the Fitness class.
     * @param sweight This is the use's desired weight.
     */
    public void setWeightGoals(double weight) {
    	user.health.setWeightGoals(weight);
    }
    
    /**
     * This method will set the user's input from the calories burned TextField into the Fitness class.
     * @param calories This is how many calories the user would like to burn in a day.
     */
    public void setCaloriesGoals(double calories) {
    	user.fitness.setCaloriesGoals(calories);
    }
    
    /**
     * This method will set the user's input from the exercise duration TextField into the Fitness class.
     * @param steps This is how long the user would like to exercise in a day.
     */
    public void setExerciseGoals(double exercise) {
    	user.fitness.setExerciseGoals(exercise);
    }
}

