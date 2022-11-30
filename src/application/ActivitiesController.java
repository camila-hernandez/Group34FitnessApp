package application;

import java.io.FileInputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class ActivitiesController implements Initializable {
	Stage applicationStage;

    @FXML
    private Button returnToMainButton;

    @FXML
    private Label caloriesBurnedLabel;

    @FXML
    private Label durationOfExerciseLabel;
    
    @FXML
    private Label todayExerciseLabel;

    @FXML
    private ImageView statsImage;
    
    @FXML
    private ImageView workoutImage;
    
    @FXML
    private ImageView headerImage;

    @FXML
    private Label todayExerciseMotivationLabel;
    
    @FXML
    private ProgressBar workoutProgressBar;
    
    @FXML
    private Label dateLabel;
    
    @FXML
    private Label progressLabel;
   
    @FXML
    private NumberAxis yAxis;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private BarChart<?, ?> workoutStatsChart;
    
    Storage storage;
    
    double progress = 0.0;
    double totalCalories = 0.0;
    
    public void setStorage(Storage storage) {
    	this.storage = storage;
    }
   
    @Override
	public void initialize(URL location, ResourceBundle resources) {
        // <a href="https://www.flaticon.com/free-icons/statistics" title="statistics icons">Statistics icons created by Freepik - Flaticon</a>
        // <a href="https://www.flaticon.com/free-icons/diet" title="diet icons">Diet icons created by Chattapat - Flaticon</a>
    	// <a href="https://www.flaticon.com/free-icons/training" title="training icons">Training icons created by Freepik - Flaticon</a>
    	// Loads image onto stats button
    	Image statsIconImage = new Image(getClass().getResourceAsStream("bar-chart.png"));
    	statsImage.setImage(statsIconImage);
    	
    	Image workoutIconImage = new Image(getClass().getResourceAsStream("healthy.png"));
    	workoutImage.setImage(workoutIconImage);
    	
    	Image headerIconImage = new Image(getClass().getResourceAsStream("training.png"));
    	headerImage.setImage(headerIconImage);
    	
    	workoutProgressBar.setStyle("-fx-accent: purple;");
    	
    	// Sets the current date label
    	LocalDateTime currentDateTime = LocalDateTime.now();
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, MMM dd yyyy");
    	String formattedDate = currentDateTime.format(dtf);
    	dateLabel.setText(formattedDate);
	}
    
    public void updateProgress(double time) {
    	// Initialize progress and label to 0
    	workoutProgressBar.setProgress(0);
    	progressLabel.setText(0.0 + "%");
    	// Update progress bar
    	progress = (time / Double.parseDouble(Storage.storage.getExerciseGoals())) * 100;
    	workoutProgressBar.setProgress(progress / 100);
    	if (progress < 100 || progress == 100) {
    		progressLabel.setText(Math.round(progress) + ".0%");
    	}
    	else {
    		progressLabel.setText("100.0%");
    	}
    	Storage.storage.setProgressValue(time);
    	storage.setProgressValue(time);
    	
    	Date today = new Date();
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(today); 
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
    	if (dayOfWeek == Calendar.MONDAY) {
    		updateTodaysExerciseLabel(Storage.storage.getMondayExerciseInfo());
    	}
    	if (dayOfWeek == Calendar.TUESDAY) {
    		updateTodaysExerciseLabel(Storage.storage.getTuesdayExerciseInfo());
    	}
    	if (dayOfWeek == Calendar.WEDNESDAY) {
    		updateTodaysExerciseLabel(Storage.storage.getWednesdayExerciseInfo());
    	}
    	if (dayOfWeek == Calendar.THURSDAY) {
    		updateTodaysExerciseLabel(Storage.storage.getThursdayExerciseInfo());
    	}
    	if (dayOfWeek == Calendar.FRIDAY) {
    		updateTodaysExerciseLabel(Storage.storage.getFridayExerciseInfo());
    	}
    	if (dayOfWeek == Calendar.SATURDAY) {
    		updateTodaysExerciseLabel(Storage.storage.getSaturdayExerciseInfo());
    	}
    	if (dayOfWeek == Calendar.SUNDAY) {
    		updateTodaysExerciseLabel(Storage.storage.getSundayExerciseInfo());
    	}
    	
    	//updateTodaysExerciseLabel(Double.toString(Storage.storage.get));
    	//System.out.println("Test: " + Storage.storage.getProgressValue());
    
    	if (progress < 50 && progress != 0) {
    		todayExerciseMotivationLabel.setText("You got this! Keep going!");
    	}
    	if (progress == 50) {
    		todayExerciseMotivationLabel.setText("Halfway there! Don't stop now, keep going!");
    	}
    	if (progress > 50 && progress != 100) {
    		todayExerciseMotivationLabel.setText("Almost to the finish line!");
    	}
    	if (progress == 100 || progress > 100) {
    		todayExerciseMotivationLabel.setText("Great work! You reached your goal!");
    	}
    }
    
    public void updateProgressValue() {
    	updateProgress(storage.progress);
    }
 
    public void updateTodaysExerciseLabel(String exercise) {
    	todayExerciseLabel.setText(exercise + "/" + Double.parseDouble(Storage.storage.getExerciseGoals()) + " minutes");
    }
    
    public void updateStats(String day, String calories) {
    	Date today = new Date();
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(today); 
		day = Double.toString(Storage.storage.getProgressValue());
		calories = Double.toString(Storage.storage.getTotalCaloriesBurned());
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
    	if (dayOfWeek == Calendar.MONDAY) {
    		Storage.storage.setMondayExerciseInfo(day);
    		Storage.storage.setMondayCaloriesBurnedInfo(calories);
    	}
    	if (dayOfWeek == Calendar.TUESDAY) {
    		Storage.storage.setTuesdayExerciseInfo(day);
    		Storage.storage.setTuesdayCaloriesBurnedInfo(calories);
    	}
    	if (dayOfWeek == Calendar.WEDNESDAY) {
    		Storage.storage.setWednesdaydayExerciseInfo(day);
    		Storage.storage.setWednesdayCaloriesBurnedInfo(calories);
    	}
    	if (dayOfWeek == Calendar.THURSDAY) {
    		Storage.storage.setThursdayExerciseInfo(day);
    		Storage.storage.setThursdayCaloriesBurnedInfo(calories);
    	}
    	if (dayOfWeek == Calendar.FRIDAY) {
    		Storage.storage.setFridayExerciseInfo(day);
    		Storage.storage.setFridayCaloriesBurnedInfo(calories);
    	}
    	if (dayOfWeek == Calendar.SATURDAY) {
    		Storage.storage.setSaturdayExerciseInfo(day);
    		Storage.storage.setSaturdayCaloriesBurnedInfo(calories);
    	}
    	if (dayOfWeek == Calendar.SUNDAY) {
    		Storage.storage.setSundayExerciseInfo(day);
    		Storage.storage.setSundayCaloriesBurnedInfo(calories);
    	}
    }

    public void totalCaloriesBurned(double calories) {
    	totalCalories = calories;
    	Storage.storage.setTotalCaloriesBurned(calories);
    	storage.setTotalCaloriesBurned(calories);
    	System.out.println(totalCalories);
    }
    
    public void updateTotalCaloriesBurnedValues() {
    	if (totalCalories != 0.0) {
    		totalCaloriesBurned(storage.totalCalories);
    	}
    }
   
    @FXML
    void returnToDashboard(ActionEvent event) {
    	 try {
    		   FXMLLoader loader = new FXMLLoader();
    		   BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerView.fxml"));
    		   FitnessTrackerController controller = (FitnessTrackerController)loader.getController();
    		   
    		   controller.applicationStage = applicationStage;
    		   
    		   Scene scene = new Scene(root);
    		   applicationStage.setScene(scene);
    		   applicationStage.show();
    		   
    		
    	   } catch(Exception e) {
    		   e.printStackTrace();
    	   }
    }
    
    public void updateWorkouts(ActionEvent event) {
    	Scene displayTrainingPage = applicationStage.getScene(); 
 	   
  	   // Create new scene that displays the user's health and fitness goals
  	   VBox workoutContainer = new VBox();
  	   workoutContainer.setStyle("-fx-background-color: white");
  	
  	   // Create header title
 	   StackPane workoutStack = new StackPane();
 	   
 	   Rectangle workoutHeaderRectangle = new Rectangle(87, 58, 435, 93);
 	   workoutHeaderRectangle.setFill(Color.PURPLE);
 	   workoutHeaderRectangle.setArcHeight(20);
 	   workoutHeaderRectangle.setArcWidth(20);
 	   
 	   Label workoutLabel = new Label("WORKOUTS");
 	   workoutLabel.setTextFill(Color.WHITE);
 	   Font font = Font.font("System", FontWeight.BOLD, 22);
 	   workoutLabel.setFont(font);
 	   
 	   workoutStack.getChildren().addAll(workoutHeaderRectangle, workoutLabel);
 	   workoutStack.setPadding(new Insets(25,0,25,0));

  	   // Create stacks for widgets
   	   StackPane sportsStack = new StackPane();
   	   sportsStack.setPadding(new Insets(10,0,5,0));
   	   StackPane cardioTrainingStack = new StackPane();
   	   cardioTrainingStack.setPadding(new Insets(0,0,5,0));
   	   StackPane flexibilityTrainingStack = new StackPane();
   	   flexibilityTrainingStack.setPadding(new Insets(0,0,5,0));
   	   StackPane strengthTrainingStack = new StackPane();
   	   strengthTrainingStack.setPadding(new Insets(0,0,5,0));
   	   
   	   // Create rectangles for stacks
   	   Rectangle stackRectangle1 = new Rectangle(64, 165, 485, 117);
   	   stackRectangle1.setFill(Color.PURPLE);
   	   stackRectangle1.setArcHeight(20);
   	   stackRectangle1.setArcWidth(20);
   	   
   	   Rectangle stackRectangle2 = new Rectangle(64, 165, 485, 117);
	   stackRectangle2.setFill(Color.PURPLE);
	   stackRectangle2.setArcHeight(20);
	   stackRectangle2.setArcWidth(20);
	   
	   Rectangle stackRectangle3 = new Rectangle(64, 165, 485, 117);
   	   stackRectangle3.setFill(Color.PURPLE);
   	   stackRectangle3.setArcHeight(20);
   	   stackRectangle3.setArcWidth(20);
	   
	   Rectangle stackRectangle5 = new Rectangle(64, 165, 485, 117);
   	   stackRectangle5.setFill(Color.PURPLE);
   	   stackRectangle5.setArcHeight(20);
   	   stackRectangle5.setArcWidth(20);
   	   
   	   // Create sports container
   	   VBox sportsContainer = new VBox();
   	   
   	   Label sportsLabel = new Label("Sports");
   	   sportsLabel.setPadding(new Insets(0,0,0,100));
   	   Font labelFont = Font.font("System", FontWeight.BOLD, 25);
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
  	   strengthTrainingStack.getChildren().addAll(stackRectangle5, strengthTrainingContainer);
  	   
  	   // Guide to workouts
  	   Font guideFont = Font.font("System", 16);
  	   
  	   VBox guideContainer = new VBox();
  	   
  	   Label guideLabel = new Label("Guide:");
  	   
  	   Font guideLabelFont = Font.font("System", FontWeight.BOLD, 16);
  	   guideLabel.setFont(guideLabelFont);
  	   
  	   Label sportsExamplesLabel = new Label("Sports - basketball, soccer, hockey, football, etc.");
  	   sportsExamplesLabel.setFont(guideFont);
  	   
  	   Label cardioExamplesLabel = new Label("Cardio Training - walking, running, swimming, dancing, etc.");
  	   cardioExamplesLabel.setFont(guideFont);
  	   
  	   Label flexibilityExamplesLabel = new Label("Flexibility Training - stretching, yoga, pilates, etc.");
  	   flexibilityExamplesLabel.setFont(guideFont);
  	   
  	   Label strengthExamplesLabel = new Label("Strength Training - weight lifting, body-weight training, etc.");
  	   strengthExamplesLabel.setFont(guideFont);
  	   
  	   guideContainer.getChildren().addAll(guideLabel, sportsExamplesLabel, cardioExamplesLabel, flexibilityExamplesLabel, strengthExamplesLabel);
  	   guideContainer.setPadding(new Insets(0,0,0,80));
  	   
  	   // Create error label
  	   HBox workoutErrorContainer = new HBox();
  	   Label workoutErrorLabel = new Label();
  	   workoutErrorLabel.setTextFill(Color.RED);
  	   workoutErrorContainer.getChildren().add(workoutErrorLabel);
  	   workoutErrorContainer.setAlignment(Pos.CENTER);
  	   
  	   // Create button container
  	   VBox uploadWorkoutInfoButtonContainer = new VBox();
  	   Button submitWorkoutDataButton = new Button("Submit data");
	   submitWorkoutDataButton.setPrefSize(183, 40);
	   submitWorkoutDataButton.setTextFill(Color.WHITE);
	   Font buttonFont = Font.font("System", FontWeight.BOLD, 20);
	   submitWorkoutDataButton.setFont(buttonFont);
	   submitWorkoutDataButton.setStyle("-fx-background-color: PURPLE");
	   
	   uploadWorkoutInfoButtonContainer.getChildren().addAll(submitWorkoutDataButton);
	   uploadWorkoutInfoButtonContainer.setAlignment(Pos.CENTER);
	   uploadWorkoutInfoButtonContainer.setPadding(new Insets(10,0,0,0));
	   submitWorkoutDataButton.setOnAction(submitWorkoutDataEvent -> {
		   try {
			   double duration = (Double.parseDouble(sportsExerciseTextfield.getText()) + Double.parseDouble(cardioExerciseTextfield.getText()) +
					   Double.parseDouble(flexibilityExerciseTextfield.getText()) + Double.parseDouble(strengthExerciseTextfield.getText())); 
			   updateProgress(duration);
			   double calories = (Double.parseDouble(sportsCaloriesTextfield.getText()) + Double.parseDouble(cardioCaloriesTextfield.getText()) + 
					   Double.parseDouble(flexibilityCaloriesTextfield.getText()) + Double.parseDouble(strengthExerciseTextfield.getText()));
			   totalCaloriesBurned(calories);
			   updateStats(Double.toString(duration), Double.toString(calories));
			   updateTodaysExerciseLabel(Double.toString(duration)); 
			   applicationStage.setScene(displayTrainingPage);
		   } catch (Exception e) {
			   workoutErrorLabel.setText("This is not a valid data input. Please enter a number greater than 0.");
		   }
	   });
  	   
  	   workoutContainer.getChildren().addAll(workoutStack, workoutErrorContainer, sportsStack, cardioTrainingStack, flexibilityTrainingStack,
  			   strengthTrainingStack, guideContainer, uploadWorkoutInfoButtonContainer);
  	   
  	   Scene modifyUserWorkoutInfoScene = new Scene(workoutContainer, 609, 856);
  	   applicationStage.setScene(modifyUserWorkoutInfoScene);
  	    
    } 
    
    public void showWorkoutStats(ActionEvent event) {
    	try {
	   		   FXMLLoader loader = new FXMLLoader();
	   		   Pane root = loader.load(new FileInputStream("src/application/WorkoutStats.fxml"));
	   		   WorkoutStatistics controller = (WorkoutStatistics)loader.getController();
	   		   
	   		   controller.setStorage(storage);
	   		   controller.getMondayValuesFromStorage();
	   		   controller.getTuesdayValuesFromStorage();
	   		   controller.getWednesdayValuesFromStorage();
	   		   controller.getThursdayValuesFromStorage();
	   		   controller.getFridayValuesFromStorage();
	   		   controller.getSaturdayValuesFromStorage();
	   		   controller.getSundayValuesFromStorage();
	   		   
	   		   controller.applicationStage = applicationStage;
	   		   
	   		   Scene scene = new Scene(root);
	   		   applicationStage.setScene(scene);
	   		   applicationStage.show();
	   	   } catch(Exception e) {
	   		   e.printStackTrace();
	   	   }
        
    }


}

