package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class UserGoalsDisplay {
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

    void displayStepsGoals(String stepsInformation) {
 		stepGoalsLabel.setText(stepsInformation);
    }
    void displaySleepGoals(String sleepInformation) {
    	sleepGoalsLabel.setText(sleepInformation);
    }
    
    void displayWaterIntakeGoals(String waterInformation) {
    	waterIntakeGoalsLabel.setText(waterInformation);
    }
    
    void displayWeightGoals(String weightInformation) {
    	weightGoalsLabel.setText(weightInformation);
    }
    
    void displayCaloriesBurnedGoals(String caloriesBurnedInformation) {
    	caloriesBurnedGoalsLabel.setText(caloriesBurnedInformation);
    }
    
    void displayExerciseGoals(String exerciseInformation) {
    	exerciseGoalsLabel.setText(exerciseInformation);
    }
    
    @FXML
    void returnToMainPage(ActionEvent event) {

    }

    @FXML
    void updateFitnessGoals(ActionEvent event) {
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
 	   
 	   // Getting the user input from textfields and slider
 	   String stepsInformation = stepsGoalsTextfield.getText();
 	   String sleepInformation = sleepGoalsTextfield.getText();
 	   String waterIntakeInformation = waterIntakeGoalsTextfield.getText();
 	   String weightInformation = weightGoalsTextfield.getText();
 	   String caloriesBurnedInformation = caloriesBurnedGoalsTextfield.getText();
 	   String exerciseInformation = exerciseDurationGoalsTextfield.getText();
 	 	
 	   // Create buttons container
 	   HBox updateButtonContainer = new HBox();
 	   
 	   Button saveChangesGoalsButton = new Button("SAVE CHANGES");
 	   saveChangesGoalsButton.setMinSize(177, 44);
 	   saveChangesGoalsButton.setTextFill(Color.WHITE);
 	   saveChangesGoalsButton.setFont(labelFont);
 	   saveChangesGoalsButton.setStyle("-fx-background-color: LIGHTBLUE");
 	   saveChangesGoalsButton.setOnAction(saveChangesGoalsEvent -> applicationStage.setScene(displayUserFitnessGoalsScene));

 	   // Using methods from user goals display class
 	   displayStepsGoals(stepsInformation);
 	   displaySleepGoals(sleepInformation);
 	   displayWaterIntakeGoals(waterIntakeInformation);
 	   displayWeightGoals(weightInformation);
 	   displayCaloriesBurnedGoals(caloriesBurnedInformation);
 	   displayExerciseGoals(exerciseInformation);
 	   
 	   updateButtonContainer.getChildren().add(saveChangesGoalsButton);
 	   updateButtonContainer.setAlignment(Pos.CENTER);
 	   updateButtonContainer.setPadding(new Insets(10,0,0,0));
 		
 	   updateFitnessGoalsContainer.getChildren().addAll(updateStack, updateStepsGoalsContainer, updateSleepGoalsContainer, updateWaterIntakeGoalsContainer,
 				updateNutritionGoalsLabel, updateNutritionGoalsContainer, updateExerciseGoalsLabel, updateExerciseGoalsContainer, updateCaloriesGoalsContainer, updateButtonContainer);
 		
 	   Scene updatedUserFitnessGoalsScene = new Scene(updateFitnessGoalsContainer, 609, 856);
 	   applicationStage.setScene(updatedUserFitnessGoalsScene);	 
 	  
    }

}

