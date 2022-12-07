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

public class UserUpdateController {
	Stage applicationStage;
	
	@FXML
	private Button logOutButton;

	@FXML
	private Label nameUpdateErrorLabel;
	
	@FXML
	private Label ageUpdateErrorLabel;
	
	@FXML
	private Label genderUpdateErrorLabel;
	
	@FXML
	private Label heightUpdateErrorLabel;
	
	@FXML
	private Label weightUpdateErrorLabel;
	
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField ageField;
	
	@FXML
	private TextField genderField;
	
	@FXML
	private TextField heightField;
	
	@FXML
	private TextField weightField;
	
	User user;
	
	//public void setNameUpdateErrorLabel(String newLabel) {
	//	nameUpdateErrorLabel.setText(newLabel);
	//}
	//public void setAgeUpdateErrorLabel(String newLabel) {
	//	ageUpdateErrorLabel.setText(newLabel);
	//}
	//public void setGenderUpdateErrorLabel(String newLabel) {
	//	genderUpdateErrorLabel.setText(newLabel);
	//}
	//public void setHeightUpdateErrorLabel(String newLabel) {
	//	heightUpdateErrorLabel.setText(newLabel);
	//}
	//public void setWeightUpdateErrorLabel(String newLabel) {
	//	heightUpdateErrorLabel.setText(newLabel);
	//}
	
	/**
	 * This method will allow for the same User object to be passed between different controllers.
	 * The user can access the same properties in each scene.
	 * @param user This is the User object.
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * This ActionEvent will allow the user to enter their personal information in a new scene.
	 * @param modifyUserProfileEvent This is the new scene where the user will input their information.
	 * @throws InvalidUserInputException This is the exception that will be thrown if the information is invalid.
	 */
	@FXML
	void updateUserProfile(ActionEvent event) throws InvalidUserInputException {
		try {
			FXMLLoader loader = new FXMLLoader();
			AnchorPane root = loader.load(new FileInputStream("src/application/UserProfileUpdate.fxml"));
			UserProfileController controller = (UserProfileController)loader.getController();
			controller.setUser(user);
			controller.applicationStage = applicationStage;
			Scene scene = new Scene(root);
			applicationStage.setScene(scene);
			applicationStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	@FXML
	void saveUserProfile(ActionEvent event) {
		try {
			user.checkName(nameField.getText());
			user.setName(nameField.getText());
			nameUpdateErrorLabel.setText("");
		} catch(EmptyInputException eie ) {nameUpdateErrorLabel.setText("Name cannot be empty");}
		  catch(InvalidUserInputException iuie) {nameUpdateErrorLabel.setText("Name must be alphabetic");}
		try {
			user.checkAge(ageField.getText());
			user.setAge(Integer.parseInt(ageField.getText()));
			ageUpdateErrorLabel.setText("");
		} catch(EmptyInputException eie) {ageUpdateErrorLabel.setText("Age cannot be empty");}
		  catch(InvalidUserInputException iuie) {ageUpdateErrorLabel.setText("Age must be numeric");}
		try {
			user.checkName(genderField.getText());
			if(genderField.getText().equals("Male") || genderField.getText().equals("Female")) {
			user.setGender(genderField.getText());}
			else {genderUpdateErrorLabel.setText("Please enter Male or Female");}
			genderUpdateErrorLabel.setText("");
		} catch(EmptyInputException e) {genderUpdateErrorLabel.setText("Gender cannot be empty");}
		  catch(InvalidUserInputException iuie) {genderUpdateErrorLabel.setText("Gender must be alphabetic");}
		try {
			user.health.setHeight(Double.parseDouble(heightField.getText()));
			heightUpdateErrorLabel.setText("");
		} catch(NumberFormatException nfe) {heightUpdateErrorLabel.setText("Your height must be numeric");}
		try {
			user.health.setStartingWeight(Double.parseDouble(weightField.getText()));
			weightUpdateErrorLabel.setText("");
		} catch(NumberFormatException nfe) {weightUpdateErrorLabel.setText("Your weight must be numeric");}
		
		
	}
	
	/**
	 * This ActionEvent changes the scene back to the main page while passing the same User
	 * object and setting various labels in the main page.
	 * @param returnToMainPageEvent Changes the scene back to the main page.
	 */
	@FXML
	void returnToUser(ActionEvent returnToMainPageEvent) {
		// Changing the scene using FXML files
	   	try {
	   		FXMLLoader loader = new FXMLLoader();
	    	AnchorPane root = loader.load(new FileInputStream("src/application/UserProfile.fxml"));
	    	UserProfileController controller = (UserProfileController)loader.getController();
	    	controller.setUser(user);
	    	 
	    	controller.nameLabel.setText(user.getName());
			controller.ageLabel.setText(Double.toString(user.getAge()));
			controller.genderLabel.setText(user.getGender());
			controller.heightLabel.setText(Double.toString(user.health.getHeight()));
			System.out.println("Weight kg" + user.health.getStartingWeight());
			controller.weightLabel.setText(Double.toString(user.health.getStartingWeight()));
	    	
	    	controller.applicationStage = applicationStage;
	    		   
	    	Scene scene = new Scene(root);
	    	applicationStage.setScene(scene);
	    	applicationStage.show();	   
	    		
	   	} catch(Exception e) {
	   		e.printStackTrace();
	   	}
	}
	

}