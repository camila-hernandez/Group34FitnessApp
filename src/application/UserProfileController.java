package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

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
	
	@FXML
	private Label genderLabel;
	
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
	 * This method will set the labels with the information entered by the user
	 */
	public void setUserProfileLabels() {
		nameLabel.setText(user.getName());
		ageLabel.setText(Integer.toString(user.getAge()));
		genderLabel.setText(user.getGender());
		heightLabel.setText(Double.toString(user.health.getHeight()));
		weightLabel.setText(Double.toString(user.health.getStartingWeight()));
	}
	
	/**
	 * This ActionEvent will allow the user to enter their personal information in a new scene.
	 * @param modifyUserProfileEvent This is the new scene where the user will input their information.
	 * @throws InvalidUserInputException This is the exception that will be thrown if the information is invalid.
	 */
	@FXML
	void updateUserProfile(ActionEvent modifyUserProfileEvent) throws InvalidUserInputException {
	    // Getting the current scene
		Scene userProfileScene = applicationStage.getScene();
	    
		// Creating a custom color to use throughout the scene
	    Color c = Color.web("#6b4191",1.0);
	    
	    // Creating the scene
	    VBox userProfileContainer = new VBox();
	    userProfileContainer.setStyle("-fx-background-color: white");
	    
	    StackPane updateUserProfileStack = new StackPane();
	 	   
	 	Rectangle profileHeaderRectangle = new Rectangle(110, 61, 390, 95);
	 	profileHeaderRectangle.setFill(c);
	 	profileHeaderRectangle.setArcHeight(20);
	 	profileHeaderRectangle.setArcWidth(20);
	 	   
	 	Label updateProfileLabel = new Label("UPDATE USER PROFILE");
	 	updateProfileLabel.setTextFill(Color.WHITE);
	 	Font font = Font.font("System", FontWeight.BOLD, 25);
	 	updateProfileLabel.setFont(font);
	 	   
	 	updateUserProfileStack.getChildren().addAll(profileHeaderRectangle, updateProfileLabel);
	 	updateUserProfileStack.setPadding(new Insets(60,0,25,0));
	    
	 	// Setting up a font to use for each label
	 	Font labelFont = Font.font("System", 24.5);
	 	
	    Label updateNameLabel = new Label("Name: ");
	    updateNameLabel.setFont(labelFont);
	    Label updateAgeLabel = new Label("Age: ");
	    updateAgeLabel.setFont(labelFont);
	    Label updateHeightLabel = new Label("Height in cm: ");
	    updateHeightLabel.setFont(labelFont);
	    Label updateWeightLabel = new Label("Weight in kg: ");
	    updateWeightLabel.setFont(labelFont);
	    Label updateGenderLabel = new Label("Gender: ");
	    updateGenderLabel.setFont(labelFont);
	    
	    // Creating TextFields and a choice box for user input
	    TextField nameTextfield = new TextField();
	    TextField ageTextfield = new TextField();
	    TextField heightTextfield = new TextField();
	    TextField weightTextfield = new TextField();
	    ChoiceBox<String> genderChoiceBox = new ChoiceBox<>();
	    genderChoiceBox.getItems().add("Female");
	    genderChoiceBox.getItems().add("Male");
	    
	    // Creating an error label
	    VBox userProfileErrorLabelContainer = new VBox();
	 	Label userProfileErrorLabel = new Label(" ");
	 	Font errorLabelFont = Font.font("System", 16);
	 	userProfileErrorLabel.setFont(errorLabelFont);
	 	userProfileErrorLabel.setTextFill(Color.RED);
	 	userProfileErrorLabelContainer.getChildren().add(userProfileErrorLabel);
	 	userProfileErrorLabelContainer.setAlignment(Pos.CENTER);
	    
	 	// Creating containers for each item for their corresponding label and textfield or choice box
	    HBox nameContainer = new HBox();
	    HBox ageContainer = new HBox();
	    HBox heightContainer = new HBox();
	    HBox weightContainer = new HBox();
	    HBox genderContainer = new HBox();
	    
	    nameContainer.getChildren().addAll(updateNameLabel, nameTextfield);
	    ageContainer.getChildren().addAll(updateAgeLabel, ageTextfield);
	    heightContainer.getChildren().addAll(updateHeightLabel, heightTextfield);
	    weightContainer.getChildren().addAll(updateWeightLabel, weightTextfield);
	    genderContainer.getChildren().addAll(updateGenderLabel, genderChoiceBox);
	    
	    nameContainer.setAlignment(Pos.CENTER);
	    nameContainer.setPadding(new Insets(0,0,0,50));
	    ageContainer.setAlignment(Pos.CENTER);
	    ageContainer.setPadding(new Insets(50,0,0,50));
	    genderContainer.setAlignment(Pos.CENTER);
	   	genderContainer.setPadding(new Insets(50,0,0,50));
	    heightContainer.setAlignment(Pos.CENTER);
	    heightContainer.setPadding(new Insets(50,0,0,50));
	    weightContainer.setAlignment(Pos.CENTER);
	    weightContainer.setPadding(new Insets(50,0,0,50));
	    
	    // Creating a done button
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
	    
	    // Set the action of the button
	    doneButton.setOnAction(doneEvent -> {
	    	try {
	    		// Check user input
	    		user.checkName(nameTextfield.getText());
				user.isNumeric(ageTextfield.getText());
				user.health.checkInput(heightTextfield.getText());
				user.health.checkInput(weightTextfield.getText());
				// Set properties in User and Health classes
				user.setName(nameTextfield.getText());
				user.setAge(Integer.parseInt(ageTextfield.getText()));
				user.setGender(genderChoiceBox.getValue().toString());
				user.health.setHeight(Double.parseDouble(heightTextfield.getText()));
				user.health.setStartingWeight(Double.parseDouble(weightTextfield.getText()));
				// Set labels with user information
				setUserProfileLabels();
				
				applicationStage.setScene(userProfileScene);
	    	} catch (InvalidUserInputException e) {
	    		userProfileErrorLabel.setText(e.getMessage());
			}
	    });
	    
	    // Add every container into the new scene container
	    userProfileContainer.getChildren().addAll(updateUserProfileStack, userProfileErrorLabelContainer, nameContainer, ageContainer, genderContainer, heightContainer, weightContainer, buttonContainer);
	    
	    // Display the scene
	    Scene updateUserProfileScene = new Scene(userProfileContainer, 609, 856);
	  	applicationStage.setScene(updateUserProfileScene);
	 }
	
	/**
	 * This ActionEvent changes the scene back to the main page while passing the same User
	 * object and setting various labels in the main page.
	 * @param returnToMainPageEvent Changes the scene back to the main page.
	 */
	@FXML
	void returnToDashboard(ActionEvent returnToMainPageEvent) {
		// Changing the scene using FXML files
	   	try {
	   		FXMLLoader loader = new FXMLLoader();
	    	BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerView.fxml"));
	    	FitnessTrackerController controller = (FitnessTrackerController)loader.getController();
	    	 
	    	// Pass the same User object to each scene
	    	controller.setUser(user);
	    	// Set the goals label in the main scene
	  		controller.setGoalsCompletedLabel();
	  		// Set name label in the main scene based on the User class
	    	controller.setNameLabel();
	    	
	    	controller.applicationStage = applicationStage;
	    		   
	    	Scene scene = new Scene(root);
	    	applicationStage.setScene(scene);
	    	applicationStage.show();	   
	    		
	   	} catch(Exception e) {
	   		e.printStackTrace();
	   	}
	}
	
	/**
	 * This method will write the user's data to a file.
	 */
	private void writeToFile() {
		File f = new File("FitnessTrackerFile.txt");
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
			
		// If the file does not exist, then it will print this statement	
		} catch (Exception e) {
			System.out.println("File cannot be created");
		}
	}

	/**
	 * This ActionEvent will allow the user to sign out, while saving their information for
	 * the next time they open the application.
	 * @param signOutEvent This will close the application.
	 */
    @FXML
    void userLogOut(ActionEvent signOutEvent) {
    	writeToFile();
	    applicationStage.close();
    }
}
