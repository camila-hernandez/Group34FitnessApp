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
    	  } catch (Exception e) {
    	  }
    }

    @FXML
    void showHealthyRecipes(ActionEvent event) {
    	
    }
    
    @FXML
    void showRecommendations(ActionEvent event) {

    }
    
   @FXML
   void showUserFitnessGoals(ActionEvent event) {
	   Scene mainScene = applicationStage.getScene();
	   Scene updateUserFitnessGoalsScene = applicationStage.getScene();
	   
	   // Create new scene that displays the user's health and fitness goals
	   VBox fitnessGoalsDisplayContainer = new VBox();
	   fitnessGoalsDisplayContainer.setStyle("-fx-background-color: white");
	   
	   // Create header title
	   StackPane stack = new StackPane();
	   
	   Rectangle headerRectangle = new Rectangle(87, 58, 435, 93);
	   headerRectangle.setFill(Color.LIGHTBLUE);
	   headerRectangle.setArcHeight(20);
	   headerRectangle.setArcWidth(20);
	  // Add padding or margins to rectangle
	   
	   Label fitnessGoalsLabel = new Label("HEALTH AND FITNESS GOALS");
	   fitnessGoalsLabel.setTextFill(Color.WHITE);
	   Font font = Font.font("System", FontWeight.BOLD, 26);
	   fitnessGoalsLabel.setFont(font);
	   
	   stack.getChildren().addAll(headerRectangle, fitnessGoalsLabel);
	   stack.setPadding(new Insets(25,0,25,0));
	   
	   // Create steps container
	   HBox stepsGoalsContainer = new HBox();
	   Label stepsGoalsLabel = new Label("STEPS GOALS:");
	   Font labelFont = Font.font("System", FontWeight.BOLD, 24);
	   stepsGoalsLabel.setFont(labelFont);
	   stepsGoalsLabel.setTextFill(Color.LIGHTBLUE);
	   stepsGoalsLabel.setPadding(new Insets(25, 0, 25, 0));
	   Label stepsGoalsInputLabel = new Label("");
	   stepsGoalsInputLabel.setMinWidth(267);
	   stepsGoalsInputLabel.setMinHeight(35);
	   stepsGoalsContainer.getChildren().addAll(stepsGoalsLabel, stepsGoalsInputLabel);
	   stepsGoalsContainer.setAlignment(Pos.CENTER);
	   
	   // Create sleep container
	   HBox sleepGoalsContainer = new HBox();
	   Label sleepGoalsLabel = new Label("SLEEP GOALS:");
	   sleepGoalsLabel.setFont(labelFont);
	   sleepGoalsLabel.setTextFill(Color.LIGHTBLUE);
	   sleepGoalsLabel.setPadding(new Insets(25, 5, 25, 0));
	   Label sleepGoalsInputLabel = new Label("");
	   sleepGoalsInputLabel.setMinWidth(267);
	   sleepGoalsInputLabel.setMinHeight(35);
	   sleepGoalsContainer.getChildren().addAll(sleepGoalsLabel, sleepGoalsInputLabel);
	   sleepGoalsContainer.setAlignment(Pos.CENTER);
	   
	   // Create water in-take container
	   HBox waterIntakeGoalsContainer = new HBox();
	   Label waterIntakeGoalsLabel = new Label("WATER INTAKE GOALS:");
	   waterIntakeGoalsLabel.setTextFill(Color.LIGHTBLUE);
	   waterIntakeGoalsLabel.setPadding(new Insets(25, 0, 25, 52));
	   waterIntakeGoalsLabel.setFont(labelFont);
	   Label waterIntakeGoalsInputLabel = new Label("");
	   waterIntakeGoalsInputLabel.setMinWidth(217);
	   waterIntakeGoalsInputLabel.setMinHeight(35);
	   waterIntakeGoalsContainer.getChildren().addAll(waterIntakeGoalsLabel, waterIntakeGoalsInputLabel);
	   waterIntakeGoalsContainer.setAlignment(Pos.CENTER);
	   
	   // Create nutrition container
	   Label nutritionGoalsLabel = new Label("NUTRITION GOALS:");
	   nutritionGoalsLabel.setTextFill(Color.LIGHTBLUE);
	   nutritionGoalsLabel.setPadding(new Insets(25, 0, 10, 90));
	   nutritionGoalsLabel.setMinSize(224, 35);
	   nutritionGoalsLabel.setFont(labelFont);
		
	   HBox nutritionGoalsContainer = new HBox();
	   Label weightGoalsLabel = new Label("What is your weight goal (in kg)?");
	   weightGoalsLabel.setPadding(new Insets(0, 0, 0, 50));
	   Font textFont = Font.font("System", 18);
	   weightGoalsLabel.setFont(textFont);
	   Label weightGoalsInputLabel = new Label("");
	   weightGoalsInputLabel.setMinSize(217, 35);
	   nutritionGoalsContainer.getChildren().addAll(weightGoalsLabel, weightGoalsInputLabel);
	   nutritionGoalsContainer.setAlignment(Pos.CENTER);
	   
	   // Create exercise container
	   Label exerciseGoalsLabel = new Label("EXERCISE GOALS:");
	   exerciseGoalsLabel.setPadding(new Insets(25, 0, 15, 90));
	   exerciseGoalsLabel.setTextFill(Color.LIGHTBLUE);
	   exerciseGoalsLabel.setMinSize(224, 35);
	   exerciseGoalsLabel.setFont(labelFont);
		
	   VBox exerciseGoalsContainer = new VBox();
	   Label exerciseDurationGoalsLabel = new Label("How long would you like to exercise (in minutes)?");
	   exerciseDurationGoalsLabel.setPadding(new Insets(0, 32, 25, 0));
	   exerciseDurationGoalsLabel.setFont(textFont);
	   Label exerciseDurationGoalsInputLabel = new Label("");
	   exerciseDurationGoalsInputLabel.setMinSize(224, 35);
	   exerciseDurationGoalsInputLabel.setAlignment(Pos.CENTER);
	   exerciseGoalsContainer.getChildren().addAll(exerciseDurationGoalsLabel, exerciseDurationGoalsInputLabel);
	   exerciseGoalsContainer.setAlignment(Pos.CENTER);
	   
	   // Create calories burned container
	   VBox caloriesGoalsContainer = new VBox();
	   Label caloriesBurnedGoalsLabel = new Label("How many calories would you like to burn in a day?");
	   caloriesBurnedGoalsLabel.setPadding(new Insets(0, 15, 25, 0));
	   caloriesBurnedGoalsLabel.setFont(textFont);
	   Label caloriesBurnedGoalsInputLabel = new Label("");
	   caloriesBurnedGoalsInputLabel.setMinSize(224, 35);
	   caloriesBurnedGoalsInputLabel.setAlignment(Pos.CENTER);
	   caloriesGoalsContainer.getChildren().addAll(caloriesBurnedGoalsLabel, caloriesBurnedGoalsInputLabel);
	   caloriesGoalsContainer.setAlignment(Pos.CENTER);
	   
	   // Create buttons container
	   HBox buttonsContainer = new HBox();
	   Button homeButton = new Button("RETURN TO MAIN");
	   homeButton.setPadding(new Insets(10,10,10,10));
	   homeButton.setMinSize(201, 44);
	   homeButton.setTextFill(Color.WHITE);
	   homeButton.setFont(labelFont);
	   homeButton.setStyle("-fx-background-color: LIGHTBLUE");
	   homeButton.setOnAction(homeEvent -> applicationStage.setScene(mainScene));
	   
	   Button updateGoalsButton = new Button("UPDATE GOALS");
	   updateGoalsButton.setMinSize(177, 44);
	   updateGoalsButton.setTextFill(Color.WHITE);
	   updateGoalsButton.setFont(labelFont);
	   updateGoalsButton.setStyle("-fx-background-color: LIGHTBLUE");
	   updateGoalsButton.setOnAction(updateGoalsEvent -> updateUserFitnessGoals(updateUserFitnessGoalsScene));
	   
	   buttonsContainer.getChildren().addAll(homeButton, updateGoalsButton);
	   buttonsContainer.setAlignment(Pos.CENTER);
	   buttonsContainer.setSpacing(20);
		
	   fitnessGoalsDisplayContainer.getChildren().addAll(stack, stepsGoalsContainer, sleepGoalsContainer, waterIntakeGoalsContainer,
				nutritionGoalsLabel, nutritionGoalsContainer, exerciseGoalsLabel, exerciseGoalsContainer, caloriesGoalsContainer, buttonsContainer);
		
	   Scene displayUserFitnessGoalsScene = new Scene(fitnessGoalsDisplayContainer, 609, 856);
	   applicationStage.setScene(displayUserFitnessGoalsScene);
   }
   
   void updateUserFitnessGoals(Scene updateUserFitnessGoalsScene) {
	   Scene displayuserFitnessGoalsScene = applicationStage.getScene(); 
	   
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
	   
	   // Create steps container
	   HBox updateStepsGoalsContainer = new HBox();
	   updateStepsGoalsContainer.setPadding(new Insets(0,50,0,50));
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
	   
	   // Create sleep container
	   HBox updateSleepGoalsContainer = new HBox();
	   Label updateSleepGoalsLabel = new Label("SLEEP GOALS:");
	   updateSleepGoalsLabel.setFont(labelFont);
	   updateSleepGoalsLabel.setTextFill(Color.LIGHTBLUE);
	   updateSleepGoalsLabel.setPadding(new Insets(25, 5, 25, 0));
	   TextField updateSleepGoalsTextfield = new TextField();
	   updateSleepGoalsTextfield.setMinWidth(254);
	   updateSleepGoalsTextfield.setMinHeight(51);
	   updateSleepGoalsContainer.getChildren().addAll(updateSleepGoalsLabel, updateSleepGoalsTextfield);
	   updateSleepGoalsContainer.setAlignment(Pos.CENTER);
	   
	   // Create water in-take container
	   HBox updateWaterIntakeGoalsContainer = new HBox();
	   Label updateWaterIntakeGoalsLabel = new Label("WATER INTAKE GOALS:");
	   updateWaterIntakeGoalsLabel.setTextFill(Color.LIGHTBLUE);
	   updateWaterIntakeGoalsLabel.setPadding(new Insets(25, 0, 25, 52));
	   updateWaterIntakeGoalsLabel.setFont(labelFont);
	   TextField updateWaterIntakeGoalsTextfield = new TextField();
	   updateWaterIntakeGoalsTextfield.setMinWidth(152);
	   updateWaterIntakeGoalsTextfield.setMinHeight(51);
	   updateWaterIntakeGoalsContainer.getChildren().addAll(updateWaterIntakeGoalsLabel, updateWaterIntakeGoalsTextfield);
	   updateWaterIntakeGoalsContainer.setAlignment(Pos.CENTER);
	   
	   // Create nutrition container
	   Label updateNutritionGoalsLabel = new Label("NUTRITION GOALS:");
	   updateNutritionGoalsLabel.setTextFill(Color.LIGHTBLUE);
	   updateNutritionGoalsLabel.setPadding(new Insets(25, 0, 10, 90));
	   updateNutritionGoalsLabel.setMinSize(224, 35);
	   updateNutritionGoalsLabel.setFont(labelFont);
		
	   HBox updateNutritionGoalsContainer = new HBox();
	   Label updateWeightGoalsLabel = new Label("What is your weight goal (in kg)?");
	   updateWeightGoalsLabel.setPadding(new Insets(0, 0, 0, 50));
	   Font textFont = Font.font("System", 18);
	   updateWeightGoalsLabel.setFont(textFont);
	   TextField weightGoalsTextfield = new TextField();
	   weightGoalsTextfield.setMinSize(152, 51);
	   updateNutritionGoalsContainer.getChildren().addAll(updateWeightGoalsLabel, weightGoalsTextfield);
	   updateNutritionGoalsContainer.setAlignment(Pos.CENTER);
	   
	   // Create exercise container
	   Label updateExerciseGoalsLabel = new Label("EXERCISE GOALS:");
	   updateExerciseGoalsLabel.setPadding(new Insets(25, 0, 15, 90));
	   updateExerciseGoalsLabel.setTextFill(Color.LIGHTBLUE);
	   updateExerciseGoalsLabel.setMinSize(224, 35);
	   updateExerciseGoalsLabel.setFont(labelFont);
		
	   VBox updateExerciseGoalsContainer = new VBox();
	   Label updateExerciseDurationGoalsLabel = new Label("How long would you like to exercise (in minutes)?");
	   updateExerciseDurationGoalsLabel.setPadding(new Insets(0, 32, 25, 0));
	   updateExerciseDurationGoalsLabel.setFont(textFont);
	   TextField exerciseDurationGoalsTextfield = new TextField();
	   exerciseDurationGoalsTextfield.setMinSize(298, 51);
	   exerciseDurationGoalsTextfield.setAlignment(Pos.CENTER);
	   updateExerciseGoalsContainer.getChildren().addAll(updateExerciseDurationGoalsLabel, exerciseDurationGoalsTextfield);
	   updateExerciseGoalsContainer.setAlignment(Pos.CENTER);
	   
	   // Create calories burned container
	   VBox updateCaloriesGoalsContainer = new VBox();
	   Label updateCaloriesBurnedGoalsLabel = new Label("How many calories would you like to burn in a day?");
	   updateCaloriesBurnedGoalsLabel.setPadding(new Insets(0, 15, 25, 0));
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
	   saveChangesGoalsButton.setOnAction(saveChangesGoalsEvent -> applicationStage.setScene(displayuserFitnessGoalsScene));
	   
	   updateButtonContainer.getChildren().add(saveChangesGoalsButton);
	   updateButtonContainer.setAlignment(Pos.CENTER);
	   updateButtonContainer.setSpacing(20);
		
	   updateFitnessGoalsContainer.getChildren().addAll(updateStack, updateStepsGoalsContainer, updateSleepGoalsContainer, updateWaterIntakeGoalsContainer,
				updateNutritionGoalsLabel, updateNutritionGoalsContainer, updateExerciseGoalsLabel, updateExerciseGoalsContainer, updateCaloriesGoalsContainer, updateButtonContainer);
		
	   Scene updatedUserFitnessGoalsScene = new Scene(updateFitnessGoalsContainer, 609, 856);
	   applicationStage.setScene(updatedUserFitnessGoalsScene);
	   
   }
}
    	