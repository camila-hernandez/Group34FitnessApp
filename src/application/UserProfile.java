package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
			// Write all goals to the file
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Steps goal = " + Storage.storage.getStepsGoals() + "\n");
			bw.write("Sleep goal = " + Storage.storage.getSleepGoals() + "\n");
			bw.write("Water intake goal = " + Storage.storage.getWaterIntakeGoals() + "\n");
			bw.write("Weight goal = " + Storage.storage.getWeightGoals() + "\n");
			bw.write("Calories burned goal = " + Storage.storage.getCaloriesGoals() + "\n");
			bw.write("Exercise goal = " + Storage.storage.getExerciseGoals() + "\n");
			
			// Stores exercise information depending on day of the week for statistics in the file
			Date today = new Date();
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(today); 
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek == Calendar.MONDAY) {
				bw.write("Monday exercise duration = " + Storage.storage.getMondayExerciseInfo() + "\n");
			}
			if (dayOfWeek == Calendar.TUESDAY) {
				bw.write("Tuesday exercise duration = " + Storage.storage.getTuesdayExerciseInfo() + "\n");
			}
			if (dayOfWeek == Calendar.WEDNESDAY) {
				bw.write("Wednesday exercise duration = " + Storage.storage.getWednesdayExerciseInfo() + "\n");
			}
			if (dayOfWeek == Calendar.THURSDAY) {
				bw.write("Thursday exercise duration = " + Storage.storage.getThursdayExerciseInfo() + "\n");
			}
			if (dayOfWeek == Calendar.FRIDAY) {
				bw.write("Friday exercise duration = " + Storage.storage.getFridayExerciseInfo() + "\n");
			}
			if (dayOfWeek == Calendar.SATURDAY) {
				bw.write("Saturday exercise duration = " + Storage.storage.getSaturdayExerciseInfo() + "\n");
			}
			if (dayOfWeek == Calendar.SUNDAY) {
				bw.write("Sunday exercise duration = " + Storage.storage.getSundayExerciseInfo() + "\n");
			}
			
			// Close BufferedWriter and FileWriter			
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("File cannot be created");
		}
	   applicationStage.close();
    }

}
