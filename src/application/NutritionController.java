package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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

public class NutritionController {

	public Stage applicationStage;

	@FXML
	private TextField CalorieIntake;
	
	@FXML
	private Label carbsLabel;
	
	@FXML
	private Label fatLabel;
	
	@FXML
	private Label fiberLabel;
	
	@FXML
	private Label servingRatioLabel;
	
	@FXML
	private Label CalorieIntakeDisplay;
	
	@FXML
	private Label bmiDisplayLabel;
	
	@FXML
	private Label userWeightLabel;
	
	User user;
	
	public void setUser(User user) {
    	this.user = user;
    }
	
	Label errorLabel = new Label(" ");
	void setServingProperties(Scene servingScene, TextField carbsTextField, TextField fatTextField, TextField fiberTextField) throws InvalidUserInputException {
		
		carbsLabel.setText(carbsTextField.getText());
		fatLabel.setText(fatTextField.getText());
		fiberLabel.setText(fiberTextField.getText());
		
		applicationStage.setScene(servingScene);
	}
	
	@FXML
	void setCalorieIntake(ActionEvent setCalorieIntakeEvent) {
		double calorieAmount = Double.parseDouble(CalorieIntake.getText());
		
		if (calorieAmount < 2000) {
			CalorieIntakeDisplay.setText("Your Calorie intake of " 
		+ calorieAmount + " is less than the average "
				+ "amount required daily for an adult.");
		}
		
		if (calorieAmount >= 2000 && calorieAmount < 3000) {
			CalorieIntakeDisplay.setText("You have consumed the average "
					+ "amount of calories needed for an adult");
		}
		
		if (calorieAmount > 3000) {
			CalorieIntakeDisplay.setText("Your Calorie intake of " 
		+ calorieAmount + " is greater than the average "
				+ "amount required daily for an adult.");
		}
	}
	
	@FXML
	void calculateBMI(ActionEvent calculateBMIevent) {
		double bmi = user.health.calculateBMI();
		if (bmi < 18.5) {
			bmiDisplayLabel.setText(String.format("Your bmi is: %.2f " , bmi, + '\n' + "you are underweight."));	
		}
		if (bmi > 18.5 && bmi < 25) {
			bmiDisplayLabel.setText(String.format("Your bmi is: %.2f " , bmi, + '\n' + "you are at a healthy weight."));	
		}
		
		if (bmi > 25) {
			bmiDisplayLabel.setText(String.format("Your bmi is: %.2f " , bmi, + '\n' + "you are over weight."));	
		}
		
	}
	
	@FXML
	void displayServingRatio(ActionEvent event) {
		user.health.setCarbs(Double.parseDouble(carbsLabel.getText()));
		user.health.setFat(Double.parseDouble(fatLabel.getText()));
		user.health.setFiber(Double.parseDouble(fiberLabel.getText()));	
	}
	
	@FXML
	void calculateServingRatio(ActionEvent event) {
		double carbs = user.health.calculateCarbs();
		double fat = user.health.calculateFat();
		double fiber = user.health.calculateFiber();
		
		servingRatioLabel.setText(String.format("ratio: %.2f carbs, %.2f fat, %.2f fiber.", carbs,fat,fiber));
	}
	
	@FXML
	void compareWeight(ActionEvent event) {
		double userWeight = user.health.getWeight();
		double weightGoal = user.health.getWeightGoals();
		
		if (weightGoal - userWeight >= 0) {
			userWeightLabel.setText("You have reached your weight goal.");
		}
		
		if (weightGoal - userWeight < 0) {
			userWeightLabel.setText("You are " + (userWeight - weightGoal) + " kg away from your weight goal.");
		}
	}
	
	@FXML
	void updateServingRatio(ActionEvent event){
	    Scene servingScene = applicationStage.getScene();
	    
	    Color c = Color.web("#6b4191",1.0);
	    
	    VBox servingContainer = new VBox();
	    servingContainer.setStyle("-fx-background-color: white");
	    
	    StackPane updateServingStack = new StackPane();
	 	   
	 	Rectangle profileHeaderRectangle = new Rectangle(110, 61, 390, 95);
	 	profileHeaderRectangle.setFill(c);
	 	profileHeaderRectangle.setArcHeight(20);
	 	profileHeaderRectangle.setArcWidth(20);
	 	   
	 	Label updateServingLabel = new Label("UPDATE USER SERVING");
	 	updateServingLabel.setTextFill(Color.WHITE);
	 	Font font = Font.font("System", FontWeight.BOLD, 25);
	 	updateServingLabel.setFont(font);
	 	   
	 	updateServingStack.getChildren().addAll(profileHeaderRectangle, updateServingLabel);
	 	updateServingStack.setPadding(new Insets(60,0,25,0));
	    
	 	Font labelFont = Font.font("System", 24.5);
	    Label updateCarbsLabel = new Label("Carbs in serving (g): ");
	    updateCarbsLabel.setFont(labelFont);
	    
	    Label updateFiberLabel = new Label("Fiber in serving (g): ");
	    updateFiberLabel.setFont(labelFont);
	    
	    Label updateFatLabel = new Label("Fat in serving (g) ");
	    updateFatLabel.setFont(labelFont);
	    
	    
	    TextField carbsTextField = new TextField();
	    
	    TextField fatTextField = new TextField();
	    
	    TextField fiberTextField = new TextField();
	    
	    HBox carbsContainer = new HBox();
	    HBox fatContainer = new HBox();
	    HBox fiberContainer = new HBox();
	    
	    carbsContainer.getChildren().addAll(updateCarbsLabel, carbsTextField);
	    fatContainer.getChildren().addAll(updateFatLabel, fatTextField);
	    fiberContainer.getChildren().addAll(updateFiberLabel, fiberTextField);

	    
	    carbsContainer.setAlignment(Pos.CENTER);
	    fiberContainer.setPadding(new Insets(0,0,0,50));
	    fatContainer.setAlignment(Pos.CENTER);
	    carbsContainer.setPadding(new Insets(50,0,0,50));
	    fiberContainer.setAlignment(Pos.CENTER);
	    fatContainer.setPadding(new Insets(50,0,0,50));
	    
	    HBox buttonContainer = new HBox();
	    Button doneButton = new Button("Done");
		doneButton.setPrefSize(106, 48);
		doneButton.setTextFill(Color.WHITE);
		Font buttonFont = Font.font("System", FontWeight.BOLD, 22);
		doneButton.setFont(buttonFont);
		doneButton.setStyle("-fx-background-color: #3e9acf");
		   
		buttonContainer.getChildren().addAll(doneButton);
	    buttonContainer.setPadding(new Insets(75,0,0,0));
	    buttonContainer.setAlignment(Pos.CENTER);
	    doneButton.setOnAction(doneEvent -> {
	    	try {
				setServingProperties(servingScene, carbsTextField, fatTextField, fiberTextField);
				displayServingRatio(event);
				calculateServingRatio(event);
				
			} catch (InvalidUserInputException e) {
				errorLabel.setText(e.getMessage());
			}
	    });
	    
	    servingContainer.getChildren().addAll(updateServingStack,  carbsContainer, fatContainer, fiberContainer, buttonContainer);
	    
	    Scene updateServingScene = new Scene(servingContainer, 609, 856);
	  	applicationStage.setScene(updateServingScene);
	 }
	@FXML
    void returnToMain(ActionEvent event) {
    	 try {
  		   FXMLLoader loader = new FXMLLoader();
  		   BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerView.fxml"));
  		   FitnessTrackerController controller = (FitnessTrackerController)loader.getController();
  		   controller.setUser(user);
		   controller.setGoalsCompletedLabel();
  		   controller.setNameLabel();
  		   controller.applicationStage = applicationStage;
  		   
  		   Scene scene = new Scene(root);
  		   applicationStage.setScene(scene);
  		   applicationStage.show();
  	   } catch(Exception e) {
  		   e.printStackTrace();
  	   }
	}

}
