package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UserProfile {
	Stage applicationStage;

    @FXML
    private Button logOutButton;

    @FXML
    void userLogOut(ActionEvent event) {
    	File f = new File("C:\\Users\\CS219-user\\Documents\\FitnessTrackerFile.txt");
		try {
			// If the file doesn't exist, we will create the file
			if (!f.exists()) {
				f.createNewFile();
			}
			// Write to the file
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Steps goal = " + Storage.storage.getStepsGoals() + "\n");
			bw.write("Sleep goal = " + Storage.storage.getSleepGoals() + "\n");
			bw.write("Water intake goal = " + Storage.storage.getWaterIntakeGoals() + "\n");
			bw.write("Weight goal = " + Storage.storage.getWeightGoals() + "\n");
			bw.write("Calories burned goal = " + Storage.storage.getCaloriesGoals() + "\n");
			bw.write("Exercise goal = " + Storage.storage.getExerciseGoals() + "\n");
			// Close BufferedWriter and FileWriter			
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("File cannot be created");
		}
	   applicationStage.close();
    }

}
