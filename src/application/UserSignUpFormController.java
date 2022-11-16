package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UserSignUpFormController implements Initializable {
	Stage applicationStage;
	
	@FXML
	private ImageView signUpImage;
	
	@FXML
    private Label userSignUpMessage;
	
	@FXML
	private TextField nameTextfield;
	
	@FXML
	private TextField emailTextfield;

	@FXML
	private PasswordField passwordTextfield;
	
	@FXML
	private Button signUpForAccount;

	@FXML
    private Button existingAccount;

	private String userName;

	private String userEmailAddress;

	private String userPassword;		
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
    	Image fitnessTrackerLogoImage = new Image(getClass().getResourceAsStream("FitnessTrackerLogo.jpg"));
    	signUpImage.setImage(fitnessTrackerLogoImage);
	}
    @FXML
    void userSignUp(ActionEvent userSignUpEvent) {
    	if (nameTextfield.getText().toString().isEmpty() || emailTextfield.getText().toString().isEmpty() || passwordTextfield.getText().toString().isEmpty()) {
    		userSignUpMessage.setText("Please enter your credentials.");
    		userSignUpMessage.setTextFill(Color.INDIANRED);
    	}
    	
    	else {
    		storeUserCredentials();
    		try {
    			FXMLLoader loader = new FXMLLoader();
    			BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerView.fxml"));
    			FitnessTrackerController controller = (FitnessTrackerController)loader.getController();
    			controller.applicationStage = applicationStage;
    			Scene scene = new Scene(root);
    			applicationStage.setScene(scene);
    			applicationStage.show();
    		} catch (IOException e) {
    		}
    	}
    }

    protected void storeUserCredentials() {
    	this.userName = nameTextfield.getText();
    	this.userEmailAddress = emailTextfield.getText();
    	this.userPassword = passwordTextfield.getText();
    }
    
    public String getUserName() {
    	 return this.userName;
    }
    
    public String getUserEmailAddress() {
    	return this.userEmailAddress;
    }

    public String getUserPassword() {
    	return this.userPassword;
    }
    
    @FXML
    void userLogIn(ActionEvent accountLogInEvent) {
    	try {
			FXMLLoader loader = new FXMLLoader();
    	    BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerLogin.fxml"));
    	    UserLoginFormController controller = (UserLoginFormController)loader.getController();
    	    controller.applicationStage = applicationStage;
    	    Scene scene = new Scene(root);
    	    applicationStage.setScene(scene);
    	    applicationStage.show();
    	  } catch (IOException e) {
    	  }
    }
}
