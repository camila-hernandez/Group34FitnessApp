package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserProfileController {
	Stage applicationStage;
	
	@FXML
	private Button logOutButton;

	@FXML
	private Label weightLabel;

	@FXML
	private Button updateProfileButton;

	@FXML
	private Button returnHomeButton;

	@FXML
	private Label ageLabel;

	@FXML
	private Label heightLabel;

	@FXML
	private Label nameLabel;
	
	User user;
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@FXML
	void updateUserProfile(ActionEvent event) {
	    Scene userProfileScene = applicationStage.getScene();
	    
	    VBox userProfileContainer = new VBox();
	    
	    Label updateProfileLabel = new Label();
	    	
	    Label updateNameLabel = new Label("Name: ");
	    
	    Label updateAgeLabel = new Label("Age: ");
	    
	    Label updateHeightLabel = new Label("Height: ");
	    
	    Label updateWeightLabel = new Label("Weight: ");
	    
	    TextField updateNameTextfield = new TextField();
	    
	    TextField updateAgeTextfield = new TextField();
	    
	    TextField updateHeightTextfield = new TextField();
	    
	    TextField updateWeightTextfield = new TextField();
	    
	    HBox nameContainer = new HBox();
	    HBox ageContainer = new HBox();
	    HBox heightContainer = new HBox();
	    HBox weightContainer = new HBox();
	    
	    nameContainer.getChildren().addAll(updateNameLabel, updateNameTextfield);
	    ageContainer.getChildren().addAll(updateAgeLabel, updateAgeTextfield);
	    heightContainer.getChildren().addAll(updateHeightLabel, updateHeightTextfield);
	    weightContainer.getChildren().addAll(updateWeightLabel, updateWeightTextfield);
	    
	    Button doneButton = new Button("Done");
	    doneButton.setOnAction(doneEvent -> applicationStage.setScene(userProfileScene));
	    
	    userProfileContainer.getChildren().addAll(updateProfileLabel, nameContainer, ageContainer, heightContainer, weightContainer, doneButton);
	    
	    Scene updateUserProfileScene = new Scene(userProfileContainer, 609, 856);
	  	applicationStage.setScene(updateUserProfileScene);
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

    @FXML
    void userLogOut(ActionEvent event) {
    	File f = new File("C:\\Users\\CS219-user\\Documents\\FitnessTrackerFile.txt");
		try {
			// If the file doesn't exist, we will create the file
			if (!f.exists()) {
				f.createNewFile();
			}
			// Write all goals to the file
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Steps goal = " + user.fitness.getStepsGoals() + "\n");
			bw.write("Sleep goal = " + user.health.getSleepGoals() + "\n");
			bw.write("Water intake goal = " + user.health.getWaterIntakeGoals() + "\n");
			bw.write("Weight goal = " + user.health.getWeightGoals() + "\n");
			bw.write("Calories burned goal = " + user.fitness.getCaloriesGoals() + "\n");
			bw.write("Exercise goal = " + user.fitness.getExerciseGoals() + "\n");
			bw.write("Daily progress = " + user.fitness.getProgress() + "\n");
			
			// Stores exercise information depending on day of the week for statistics in the file
			bw.write("Monday exercise duration = " + user.fitness.getMondayExerciseInfo() + "\n");
			bw.write("Monday calories burned = " + user.fitness.getMondayCaloriesBurnedInfo() + "\n");
			
			bw.write("Tuesday exercise duration = " + user.fitness.getTuesdayExerciseInfo() + "\n");
			bw.write("Tuesday calories burned = " + user.fitness.getTuesdayCaloriesBurnedInfo() + "\n");
	
			bw.write("Wednesday exercise duration = " + user.fitness.getWednesdayExerciseInfo() + "\n");
			bw.write("Wednesday calories burned = " + user.fitness.getWednesdayCaloriesBurnedInfo() + "\n");
		
			bw.write("Thursday exercise duration = " + user.fitness.getThursdayExerciseInfo() + "\n");
			bw.write("Thursday calories burned = " + user.fitness.getThursdayCaloriesBurnedInfo() + "\n");
		
			bw.write("Friday exercise duration = " + user.fitness.getFridayExerciseInfo() + "\n");
			bw.write("Friday calories burned = " + user.fitness.getFridayCaloriesBurnedInfo() + "\n");
	
			bw.write("Saturday exercise duration = " + user.fitness.getSaturdayExerciseInfo() + "\n");
			bw.write("Saturday calories burned = " + user.fitness.getSaturdayCaloriesBurnedInfo() + "\n");
		
			bw.write("Sunday exercise duration = " + user.fitness.getSundayExerciseInfo() + "\n");
			bw.write("Sunday calories burned = " + user.fitness.getSundayCaloriesBurnedInfo() + "\n");
			
			// Close BufferedWriter and FileWriter			
			bw.close();
			fw.close();
			
		} catch (Exception e) {
			System.out.println("File cannot be created");
		}
	   applicationStage.close();
    }
}
