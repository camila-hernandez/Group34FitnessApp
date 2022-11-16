package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FitnessTrackerController {
	Stage applicationStage;
	
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
    void trackNutrition(ActionEvent event) {

    }

    @FXML
    void trackWeight(ActionEvent event) {

    }

    @FXML
    void trackActivities(ActionEvent event) {

    }

    @FXML
    void showRecommendations(ActionEvent event) {

    }
    
    @FXML
    void updateGoals (ActionEvent updateGoalsEvent) {
    	Scene goalsScene = applicationStage.getScene();
    	
    	VBox updateGoalsContainer = new VBox();
    	Label setGoalsLabel = new Label("SET GOALS");
    	
    	HBox stepGoalsContainer = new HBox();
    	Label stepGoalsLabel = new Label("STEPS GOALS: ");
    	TextField stepGoalsTextfield = new TextField();
    	stepGoalsContainer.getChildren().addAll(stepGoalsLabel, stepGoalsTextfield);
    	
    	HBox sleepGoalsContainer = new HBox();
    	Label sleepGoalsLabel = new Label("SLEEP GOALS: ");
    	TextField sleepGoalsTextfield = new TextField();
    	sleepGoalsContainer.getChildren().addAll(sleepGoalsLabel, sleepGoalsTextfield);
    	
    	HBox waterIntakeGoalsContainer = new HBox();
    	Label waterIntakeGoalsLabel = new Label("WATER INTAKE GOALS: ");
    	TextField waterIntakeGoalsTextfield = new TextField();
    	waterIntakeGoalsContainer.getChildren().addAll(waterIntakeGoalsLabel, waterIntakeGoalsTextfield);
    	
    	HBox weightGoalsContainer = new HBox();
    	Label weightGoalsLabel = new Label("WEIGHT GOALS: ");
    	TextField weightGoalsTextfield = new TextField();
    	weightGoalsContainer.getChildren().addAll(weightGoalsLabel, weightGoalsTextfield);
    	
    	Button saveChangesButton = new Button("SAVE CHANGES GOALS");
    	saveChangesButton.setOnAction(saveChangesButtonEvent -> applicationStage.setScene(goalsScene));
    	
    	updateGoalsContainer.getChildren().addAll(setGoalsLabel, stepGoalsContainer, sleepGoalsContainer, waterIntakeGoalsContainer,
    			weightGoalsContainer, saveChangesButton);
    	Scene updateGoalsScene = new Scene(updateGoalsContainer);
    	applicationStage.setScene(updateGoalsScene);
    }
    
    @FXML
    void setGoals(ActionEvent setGoalsEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	VBox goalsContainer = new VBox();
    	Label setGoalsLabel = new Label("SET GOALS");
    	
    	HBox stepGoalsContainer = new HBox();
    	Label stepGoalsLabel = new Label("STEPS GOALS: ");
    	TextField stepGoalsTextfield = new TextField();
    	stepGoalsContainer.getChildren().addAll(stepGoalsLabel, stepGoalsTextfield);
    	
    	HBox sleepGoalsContainer = new HBox();
    	Label sleepGoalsLabel = new Label("SLEEP GOALS: ");
    	TextField sleepGoalsTextfield = new TextField();
    	sleepGoalsContainer.getChildren().addAll(sleepGoalsLabel, sleepGoalsTextfield);
    	
    	HBox waterIntakeGoalsContainer = new HBox();
    	Label waterIntakeGoalsLabel = new Label("WATER INTAKE GOALS: ");
    	TextField waterIntakeGoalsTextfield = new TextField();
    	waterIntakeGoalsContainer.getChildren().addAll(waterIntakeGoalsLabel, waterIntakeGoalsTextfield);
    	
    	HBox weightGoalsContainer = new HBox();
    	Label weightGoalsLabel = new Label("WEIGHT GOALS: ");
    	TextField weightGoalsTextfield = new TextField();
    	weightGoalsContainer.getChildren().addAll(weightGoalsLabel, weightGoalsTextfield);
    	
    	Button updateGoalsButton = new Button("UPDATE GOALS");
    	
    	Button returnToMainPageButton = new Button("RETURN TO MAIN PAGE");
    	returnToMainPageButton.setOnAction(returnToMainPageEvent -> applicationStage.setScene(mainScene));
    	
    	goalsContainer.getChildren().addAll(setGoalsLabel, stepGoalsContainer, sleepGoalsContainer, waterIntakeGoalsContainer,
    			weightGoalsContainer, updateGoalsButton, returnToMainPageButton);
    	Scene goalsScene = new Scene(goalsContainer);
    	applicationStage.setScene(goalsScene);
    }
}


