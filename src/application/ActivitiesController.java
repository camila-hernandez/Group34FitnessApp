package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ActivitiesController {
	Stage applicationStage;

    @FXML
    private Button returnToMainButton;

    @FXML
    private Label caloriesBurnedLabel;

    @FXML
    private Label durationOfExerciseLabel;

    @FXML
    void returnToDashboard(ActionEvent event) {

    }
   
    public void changeSceneRecentActivityTab() {
    	
    }
    
    public void updateWorkouts(ActionEvent event) {
    	Scene displayTrainingPage = applicationStage.getScene(); 
 	   
  	   // Create new scene that displays the user's health and fitness goals
  	   VBox workoutContainer = new VBox();
  	   workoutContainer.setStyle("-fx-background-color: white");
  	   
  	   Label workoutHeaderLabel = new Label("WORKOUTS");
  	   workoutHeaderLabel.setTextFill(Color.MEDIUMVIOLETRED);
  	   Font font = Font.font("System", FontWeight.BOLD, 30);
  	   workoutHeaderLabel.setFont(font);
  	   workoutHeaderLabel.setPadding(new Insets(25,0,25,60));
  	   
  	   LocalDateTime workoutSectionDate = LocalDateTime.now();  
  	   DateTimeFormatter formatWorkoutSectionDate = DateTimeFormatter.ofPattern("E, MMM dd yyyy");  
  	   String formattedDate = workoutSectionDate.format(formatWorkoutSectionDate);  
  	   Font dateFont = Font.font("System", 24);
  	   Label currentDateLabel = new Label(formattedDate);
  	   currentDateLabel.setFont(dateFont);
  	   currentDateLabel.setPadding(new Insets(0,0,0,200));
  	   
  	   // Create stacks for widgets
   	   StackPane sportsStack = new StackPane();
   	   sportsStack.setPadding(new Insets(10,0,5,0));
   	   StackPane cardioTrainingStack = new StackPane();
   	   cardioTrainingStack.setPadding(new Insets(0,0,5,0));
   	   StackPane flexibilityTrainingStack = new StackPane();
   	   flexibilityTrainingStack.setPadding(new Insets(0,0,5,0));
   	   StackPane weightTrainingStack = new StackPane();
   	   weightTrainingStack.setPadding(new Insets(0,0,5,0));
   	   StackPane strengthTrainingStack = new StackPane();
   	   strengthTrainingStack.setPadding(new Insets(0,0,5,0));
   	   
   	   // Create rectangles for stacks
   	   Rectangle stackRectangle1 = new Rectangle(64, 165, 485, 117);
   	   stackRectangle1.setFill(Color.MEDIUMVIOLETRED);
   	   stackRectangle1.setArcHeight(20);
   	   stackRectangle1.setArcWidth(20);
   	   
   	   Rectangle stackRectangle2 = new Rectangle(64, 165, 485, 117);
	   stackRectangle2.setFill(Color.MEDIUMVIOLETRED);
	   stackRectangle2.setArcHeight(20);
	   stackRectangle2.setArcWidth(20);
	   
	   Rectangle stackRectangle3 = new Rectangle(64, 165, 485, 117);
   	   stackRectangle3.setFill(Color.MEDIUMVIOLETRED);
   	   stackRectangle3.setArcHeight(20);
   	   stackRectangle3.setArcWidth(20);
   	   
   	   Rectangle stackRectangle4 = new Rectangle(64, 165, 485, 117);
	   stackRectangle4.setFill(Color.MEDIUMVIOLETRED);
	   stackRectangle4.setArcHeight(20);
	   stackRectangle4.setArcWidth(20);
	   
	   Rectangle stackRectangle5 = new Rectangle(64, 165, 485, 117);
   	   stackRectangle5.setFill(Color.MEDIUMVIOLETRED);
   	   stackRectangle5.setArcHeight(20);
   	   stackRectangle5.setArcWidth(20);
   	   
   	   // Create sports container
   	   VBox sportsContainer = new VBox();
   	   
   	   Label sportsLabel = new Label("Sports");
   	   sportsLabel.setPadding(new Insets(0,0,0,100));
   	   Font labelFont = Font.font("System", FontWeight.BOLD, 26);
   	   sportsLabel.setFont(labelFont);
   	   sportsLabel.setTextFill(Color.WHITE);
   	   
   	   HBox sportsCaloriesHBoxContainer = new HBox();
   	   Label sportsCaloriesBurnedLabel = new Label("Calories burned:");
   	   sportsCaloriesBurnedLabel.setPadding(new Insets(0,82.5,0,0));
   	   Font dataFont = Font.font("System", 18);
   	   sportsCaloriesBurnedLabel.setFont(dataFont);
   	   sportsCaloriesBurnedLabel.setTextFill(Color.WHITE);
   	   TextField sportsCaloriesTextfield = new TextField();
   	   sportsCaloriesHBoxContainer.getChildren().addAll(sportsCaloriesBurnedLabel, sportsCaloriesTextfield);
   	   sportsCaloriesHBoxContainer.setAlignment(Pos.CENTER);
   	   
   	   HBox sportsExerciseHBoxContainer = new HBox();
   	   Label sportsExerciseLabel = new Label("Duration of exercise:");
   	   sportsExerciseLabel.setPadding(new Insets(0,50,0,0));
   	   sportsExerciseLabel.setFont(dataFont);
   	   sportsExerciseLabel.setTextFill(Color.WHITE);
   	   TextField sportsExerciseTextfield = new TextField();
   	   sportsExerciseHBoxContainer.getChildren().addAll(sportsExerciseLabel, sportsExerciseTextfield);
   	   sportsExerciseHBoxContainer.setAlignment(Pos.CENTER);
   	   
   	   sportsContainer.getChildren().addAll(sportsLabel, sportsCaloriesHBoxContainer, sportsExerciseHBoxContainer);
   	   sportsContainer.setPadding(new Insets(10,0,0,0));
   	   
   	   // Create cardio training container
   	   VBox cardioTrainingContainer = new VBox();
 	   
 	   Label cardioLabel = new Label("Cardio Training");
 	   cardioLabel.setPadding(new Insets(0,0,0,100));
 	   cardioLabel.setFont(labelFont);
 	   cardioLabel.setTextFill(Color.WHITE);
 	   
 	   HBox cardioCaloriesHBoxContainer = new HBox();
 	   Label cardioCaloriesBurnedLabel = new Label("Calories burned:");
 	   cardioCaloriesBurnedLabel.setPadding(new Insets(0,82.5,0,0));	
 	   cardioCaloriesBurnedLabel.setFont(dataFont);
 	   cardioCaloriesBurnedLabel.setTextFill(Color.WHITE);
 	   TextField cardioCaloriesTextfield = new TextField();
 	   cardioCaloriesHBoxContainer.getChildren().addAll(cardioCaloriesBurnedLabel, cardioCaloriesTextfield);
 	   cardioCaloriesHBoxContainer.setAlignment(Pos.CENTER);
 	   
 	   HBox cardioExerciseHBoxContainer = new HBox();
 	   Label cardioExerciseLabel = new Label("Duration of exercise:");
 	   cardioExerciseLabel.setPadding(new Insets(0,50,0,0));
 	   cardioExerciseLabel.setFont(dataFont);
 	   cardioExerciseLabel.setTextFill(Color.WHITE);
 	   TextField cardioExerciseTextfield = new TextField();
 	   cardioExerciseHBoxContainer.getChildren().addAll(cardioExerciseLabel, cardioExerciseTextfield);
 	   cardioExerciseHBoxContainer.setAlignment(Pos.CENTER);
 	   
 	   cardioTrainingContainer.getChildren().addAll(cardioLabel, cardioCaloriesHBoxContainer, cardioExerciseHBoxContainer);
 	   cardioTrainingContainer.setPadding(new Insets(10,0,0,0));
 	   
 	   // Create flexibility training container
 	   VBox flexibilityTrainingContainer = new VBox();
  	   
  	   Label flexibilityLabel = new Label("Flexibility Training");
  	   flexibilityLabel.setPadding(new Insets(0,0,0,100));
  	   flexibilityLabel.setFont(labelFont);
  	   flexibilityLabel.setTextFill(Color.WHITE);
  	   
  	   HBox flexibilityCaloriesHBoxContainer = new HBox();
  	   Label flexibilityCaloriesBurnedLabel = new Label("Calories burned:");
  	   flexibilityCaloriesBurnedLabel.setPadding(new Insets(0,82.5,0,0));
  	   flexibilityCaloriesBurnedLabel.setFont(dataFont);
  	   flexibilityCaloriesBurnedLabel.setTextFill(Color.WHITE);
  	   TextField flexibilityCaloriesTextfield = new TextField();
  	   flexibilityCaloriesHBoxContainer.getChildren().addAll(flexibilityCaloriesBurnedLabel, flexibilityCaloriesTextfield);
  	   flexibilityCaloriesHBoxContainer.setAlignment(Pos.CENTER);
  	   
  	   HBox flexibilityExerciseHBoxContainer = new HBox();
  	   Label flexibilityExerciseLabel = new Label("Duration of exercise:");
  	   flexibilityExerciseLabel.setPadding(new Insets(0,50,0,0));
  	   flexibilityExerciseLabel.setFont(dataFont);
  	   flexibilityExerciseLabel.setTextFill(Color.WHITE);
  	   TextField flexibilityExerciseTextfield = new TextField();
  	   flexibilityExerciseHBoxContainer.getChildren().addAll(flexibilityExerciseLabel, flexibilityExerciseTextfield);
  	   flexibilityExerciseHBoxContainer.setAlignment(Pos.CENTER);
  	   
  	   flexibilityTrainingContainer.getChildren().addAll(flexibilityLabel, flexibilityCaloriesHBoxContainer, flexibilityExerciseHBoxContainer);
  	   flexibilityTrainingContainer.setPadding(new Insets(10,0,0,0));
  	   
  	   // Create weight training container
  	   VBox weightTrainingContainer = new VBox();
 	   
 	   Label weightLabel = new Label("Weight Training");
 	   weightLabel.setPadding(new Insets(0,0,0,100));
 	   weightLabel.setFont(labelFont);
 	   weightLabel.setTextFill(Color.WHITE);
 	   
 	   HBox weightCaloriesHBoxContainer = new HBox();
 	   Label weightCaloriesBurnedLabel = new Label("Calories burned:");
 	   weightCaloriesBurnedLabel.setPadding(new Insets(0,82.5,0,0));
 	   weightCaloriesBurnedLabel.setFont(dataFont);
 	   weightCaloriesBurnedLabel.setTextFill(Color.WHITE);
 	   TextField weightCaloriesTextfield = new TextField();
 	   weightCaloriesHBoxContainer.getChildren().addAll(weightCaloriesBurnedLabel, weightCaloriesTextfield);
 	   weightCaloriesHBoxContainer.setAlignment(Pos.CENTER);
 	   
 	   HBox weightExerciseHBoxContainer = new HBox();
 	   Label weightExerciseLabel = new Label("Duration of exercise:");
 	   weightExerciseLabel.setPadding(new Insets(0,50,0,0));
 	   weightExerciseLabel.setFont(dataFont);
 	   weightExerciseLabel.setTextFill(Color.WHITE);
 	   TextField weightExerciseTextfield = new TextField();
 	   weightExerciseHBoxContainer.getChildren().addAll(weightExerciseLabel, weightExerciseTextfield);
 	   weightExerciseHBoxContainer.setAlignment(Pos.CENTER);
 	   
 	   weightTrainingContainer.getChildren().addAll(weightLabel, weightCaloriesHBoxContainer, weightExerciseHBoxContainer);
 	   weightTrainingContainer.setPadding(new Insets(10,0,0,0));
 	   
 	   // Create strength training container
 	   VBox strengthTrainingContainer = new VBox();
  	   
  	   Label strengthLabel = new Label("Strength Training");
  	   strengthLabel.setPadding(new Insets(0,0,0,100));
  	   strengthLabel.setFont(labelFont);
  	   strengthLabel.setTextFill(Color.WHITE);
  	   
  	   HBox strengthCaloriesHBoxContainer = new HBox();
  	   Label strengthCaloriesBurnedLabel = new Label("Calories burned:");
  	   strengthCaloriesBurnedLabel.setPadding(new Insets(0,82.5,0,0));
  	   strengthCaloriesBurnedLabel.setFont(dataFont);
  	   strengthCaloriesBurnedLabel.setTextFill(Color.WHITE);
  	   TextField strengthCaloriesTextfield = new TextField();
  	   strengthCaloriesHBoxContainer.getChildren().addAll(strengthCaloriesBurnedLabel, strengthCaloriesTextfield);
  	   strengthCaloriesHBoxContainer.setAlignment(Pos.CENTER);
  	   
  	   HBox strengthExerciseHBoxContainer = new HBox();
  	   Label strengthExerciseLabel = new Label("Duration of exercise:");
  	   strengthExerciseLabel.setPadding(new Insets(0,50,0,0));
  	   strengthExerciseLabel.setFont(dataFont);
  	   strengthExerciseLabel.setTextFill(Color.WHITE);
  	   TextField strengthExerciseTextfield = new TextField();
  	   strengthExerciseHBoxContainer.getChildren().addAll(strengthExerciseLabel, strengthExerciseTextfield);
  	   strengthExerciseHBoxContainer.setAlignment(Pos.CENTER);
  	   
  	   strengthTrainingContainer.getChildren().addAll(strengthLabel, strengthCaloriesHBoxContainer, strengthExerciseHBoxContainer);
  	   strengthTrainingContainer.setPadding(new Insets(10,0,0,0));
  	   
  	   sportsStack.getChildren().addAll(stackRectangle1, sportsContainer);
  	   cardioTrainingStack.getChildren().addAll(stackRectangle2, cardioTrainingContainer);
  	   flexibilityTrainingStack.getChildren().addAll(stackRectangle3, flexibilityTrainingContainer);
  	   weightTrainingStack.getChildren().addAll(stackRectangle4, weightTrainingContainer);
  	   strengthTrainingStack.getChildren().addAll(stackRectangle5, strengthTrainingContainer);
  	   
  	   // Create button container
  	   VBox uploadWorkoutInfoButtonContainer = new VBox();
  	   Button submitWorkoutDataButton = new Button("SUBMIT DATA");
	   submitWorkoutDataButton.setMinSize(177, 44);
	   submitWorkoutDataButton.setTextFill(Color.WHITE);
	   submitWorkoutDataButton.setFont(labelFont);
	   submitWorkoutDataButton.setStyle("-fx-background-color: MEDIUMVIOLETRED");
	   uploadWorkoutInfoButtonContainer.getChildren().addAll(submitWorkoutDataButton);
	   uploadWorkoutInfoButtonContainer.setAlignment(Pos.CENTER);
	   uploadWorkoutInfoButtonContainer.setPadding(new Insets(10,0,0,0));
	   submitWorkoutDataButton.setOnAction(submitWorkoutDataEvent -> applicationStage.setScene(displayTrainingPage));
  	   
  	   workoutContainer.getChildren().addAll(workoutHeaderLabel, currentDateLabel, sportsStack, cardioTrainingStack, flexibilityTrainingStack,
  			   weightTrainingStack, strengthTrainingStack, uploadWorkoutInfoButtonContainer);
  	   
  	   Scene modifyUserWorkoutInfoScene = new Scene(workoutContainer, 609, 856);
  	   applicationStage.setScene(modifyUserWorkoutInfoScene);
  	   //updateStack.setPadding(new Insets(25,0,25,0));
  	    
    } 
}
