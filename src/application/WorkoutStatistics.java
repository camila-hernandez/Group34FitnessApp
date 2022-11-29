package application;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WorkoutStatistics implements Initializable {

    @FXML
    private NumberAxis yAxis;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private BarChart<?, ?> workoutStatsChart;
    
    Storage storage;

	Stage applicationStage;
	
	public void setStorage(Storage storage) {
    	this.storage = storage;
    }
	
	public String getMondayValuesFromStorage() {
		return Storage.storage.getMondayExerciseInfo();
	}
	
	public String getTuesdayValuesFromStorage() {
		return Storage.storage.getTuesdayExerciseInfo();
	}
	
	public String getWednesdayValuesFromStorage() {
		return Storage.storage.getWednesdayExerciseInfo();
	}
	
	public String getThursdayValuesFromStorage() {
		return Storage.storage.getThursdayExerciseInfo();
	}
	
	public String getFridayValuesFromStorage() {
		return Storage.storage.getFridayExerciseInfo();
	}
	
	public String getSaturdayValuesFromStorage() {
		return Storage.storage.getSaturdayExerciseInfo();
	}
	
	public String getSundayValuesFromStorage() {
		return Storage.storage.getSundayExerciseInfo();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		XYChart.Series	series = new XYChart.Series();
		series.setName("Weekly Workout Statistics");
		//Populating the series with data
        series.getData().add(new XYChart.Data("Monday", Double.parseDouble(Storage.storage.getMondayExerciseInfo())));
        series.getData().add(new XYChart.Data("Tuesday", Double.parseDouble(Storage.storage.getTuesdayExerciseInfo())));
        series.getData().add(new XYChart.Data("Wednesday", Double.parseDouble(Storage.storage.getWednesdayExerciseInfo())));
        series.getData().add(new XYChart.Data("Thursday", Double.parseDouble(Storage.storage.getThursdayExerciseInfo())));
        series.getData().add(new XYChart.Data("Friday", Double.parseDouble(Storage.storage.getFridayExerciseInfo())));
        series.getData().add(new XYChart.Data("Saturday", Double.parseDouble(Storage.storage.getSaturdayExerciseInfo())));
        series.getData().add(new XYChart.Data("Sunday", Double.parseDouble(Storage.storage.getSundayExerciseInfo())));
        
        XYChart.Series series2 = new XYChart.Series();
        //Populating the series with data
        series2.getData().add(new XYChart.Data("Monday", 20));
        series2.getData().add(new XYChart.Data("Tuesday", 20));
        series2.getData().add(new XYChart.Data("Wednesday", 20));
        series2.getData().add(new XYChart.Data("Thursday", 20));
        series2.getData().add(new XYChart.Data("Friday", 20));
        series2.getData().add(new XYChart.Data("Saturday", 20));
        series2.getData().add(new XYChart.Data("Sunday", 20));
        
        workoutStatsChart.getData().addAll(series,series2);
       
	}
	
	@FXML
    void returnToActivities(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
		   Pane root = loader.load(new FileInputStream("src/application/FitnessTrackerActivity.fxml"));
		   ActivitiesController controller = (ActivitiesController)loader.getController();
		   
		   controller.setStorage(Storage.storage);
		   controller.updateTodaysExerciseValues();
		   controller.updateProgressValue();
		   
		   controller.applicationStage = applicationStage;
		   
		   Scene scene = new Scene(root);
		   applicationStage.setScene(scene);
		   applicationStage.show();
	   } catch(Exception e) {
		   e.printStackTrace();
	   }
	}

}

