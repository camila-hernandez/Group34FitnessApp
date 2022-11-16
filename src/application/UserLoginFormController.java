package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class UserLoginFormController extends UserSignUpFormController implements Initializable {
	Stage applicationStage;
	
	@FXML
    private ImageView loginImage;
	
	@FXML
	private Label userLoginMessage;
	
	@FXML
    private TextField emailTextfield;
	
    @FXML
    private PasswordField passwordTextfield;
    
    @FXML
    private Button loginButton;
    
    @FXML
    private Button noExistingAccount;
    
    // Loads image onto login form
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	Image fitnessTrackerLogoImage = new Image(getClass().getResourceAsStream("FitnessTrackerLogo.jpg"));
    	loginImage.setImage(fitnessTrackerLogoImage);
	}
    // Verify user account credentials
    @FXML
    void userLogin(ActionEvent loginToAccountEvent) {
    	checkLoginCredentials();
    }
    
    // Checks user input in login form
    private void checkLoginCredentials() {
    	if (emailTextfield.getText().toString().equals(getUserEmailAddress()) && 
    		passwordTextfield.getText().toString().equals(getUserPassword())) {
    		userLoginMessage.setText("Successful login!");
    		userLoginMessage.setTextFill(Color.DARKSEAGREEN);
    		
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
    	
    	else if (emailTextfield.getText().isEmpty() || passwordTextfield.getText().isEmpty()) {
    		userLoginMessage.setText("Please enter your credentials.");
    		userLoginMessage.setTextFill(Color.INDIANRED);
    	}
    	
    	else {
    		userLoginMessage.setText("Incorrect username and/or password.");
    		userLoginMessage.setTextFill(Color.INDIANRED);
    	}
    }
    
    // Changes the scene to the sign up form
    @FXML
    void userSignUp(ActionEvent createAnAccountEvent) {
    	try {
			FXMLLoader loader = new FXMLLoader();
    	    BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerSignUp.fxml"));
    	    UserSignUpFormController controller = (UserSignUpFormController)loader.getController();
    	    controller.applicationStage = applicationStage;
    	    Scene scene = new Scene(root);
    	    applicationStage.setScene(scene);
    	    applicationStage.show();
    	  } catch (IOException e) {
    	  }
    }
}

