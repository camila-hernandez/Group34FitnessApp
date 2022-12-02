package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FitnessTrackerController {
	Stage applicationStage;
	

	public Steps stepsCount;

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

    }

    @FXML
    void trackSteps(ActionEvent event) {
    	Steps userSteps = new Steps("0");
    	try {
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(new FileInputStream("src/application/StepsView.fxml"));
			StepsController controller = (StepsController)loader.getController();
			controller.applicationStage = applicationStage;
			Scene scene = new Scene(root);
			applicationStage.setScene(scene);
			applicationStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

	
	@FXML
	void trackSleep(ActionEvent event) {
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
	
	@FXML
	void setDisplayLabel(ActionEvent event) {
		waterProgressIndicator.setProgress(user.health.getWaterIntakeAmount()/user.health.getWaterIntakeGoals());
		sleepDisplayLabel.setText(user.health.getSleepDuration() + " h");
	}

    @FXML
    void showRecommendations(ActionEvent event) {

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
    	updateGoalsButton.setOnAction(updateGoalsButtonEvent -> System.out.println("Done button pressed"));
    	
    	Button returnToMainPageButton = new Button("RETURN TO MAIN PAGE");
    	returnToMainPageButton.setOnAction(returnToMainPageEvent -> applicationStage.setScene(mainScene));
    	
    	goalsContainer.getChildren().addAll(setGoalsLabel, stepGoalsContainer, sleepGoalsContainer, waterIntakeGoalsContainer,
    			weightGoalsContainer, updateGoalsButton, returnToMainPageButton);
    	Scene goalsScene = new Scene(goalsContainer);
    	applicationStage.setScene(goalsScene);
    }

}

