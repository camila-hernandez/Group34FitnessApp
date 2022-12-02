package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WorkoutStatisticsController {
	Stage applicationStage;
	
    @FXML
    private NumberAxis yAxis;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private BarChart<?, ?> workoutStatsChart;
    
    User user;
	
	public void setUser(User user) {
		this.user = user;
		
	}
	
	public double getMondaysExerciseDuration() {
		return user.fitness.getMondayExerciseInfo();
	}
	
	public double getTuesdaysExerciseDuration() {
		return user.fitness.getTuesdayExerciseInfo();
	}
	
	public double getWednesdaysExerciseDuration() {
		return user.fitness.getWednesdayExerciseInfo();
	}
	
	public double getThursdaysExerciseDuration() {
		return user.fitness.getThursdayExerciseInfo();
	}
	
	public double getFridaysExerciseDuration() {
		return user.fitness.getFridayExerciseInfo();
	}
	
	public double getSaturdaysExerciseDuration() {
		return user.fitness.getSaturdayExerciseInfo();
	}
	
	public double getSundaysExerciseDuration() {
		return user.fitness.getSundayExerciseInfo();
	}
	
	public double getMondaysCaloriesBurned() {
		return user.fitness.getMondayCaloriesBurnedInfo();
	}
	
	public double getTuesdayCaloriesBurnedValues() {
		return user.fitness.getTuesdayCaloriesBurnedInfo();
	}
	
	public double getWednesdayCaloriesBurnedValues() {
		return user.fitness.getWednesdayCaloriesBurnedInfo();
	}
	
	public double getThursdayCaloriesBurnedValues() {
		return user.fitness.getThursdayCaloriesBurnedInfo();
	}
	
	public double getFridayCaloriesBurnedValues() {
		return user.fitness.getFridayCaloriesBurnedInfo();
	}
	
	public double getSaturdayCaloriesBurnedValues() {
		return user.fitness.getSaturdayExerciseInfo();
	}
	
	public double getSundayCaloriesBurnedValues() {
		return user.fitness.getSundayCaloriesBurnedInfo();
	}

	public void createChart() {	
		XYChart.Series	series = new XYChart.Series();
		series.setName("Daily workout duration (mins)");
		//Populating the series with data
        series.getData().add(new XYChart.Data("Monday", user.fitness.getMondayExerciseInfo()));
        series.getData().add(new XYChart.Data("Tuesday", user.fitness.getTuesdayExerciseInfo()));
        series.getData().add(new XYChart.Data("Wednesday", user.fitness.getWednesdayExerciseInfo()));
        series.getData().add(new XYChart.Data("Thursday", user.fitness.getThursdayExerciseInfo()));
        series.getData().add(new XYChart.Data("Friday", user.fitness.getFridayExerciseInfo()));
        series.getData().add(new XYChart.Data("Saturday", user.fitness.getSaturdayExerciseInfo()));
        series.getData().add(new XYChart.Data("Sunday", user.fitness.getSundayExerciseInfo()));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Daily amount of calories burned (cal)");
        //Populating the series with data
        series2.getData().add(new XYChart.Data("Monday", user.fitness.getMondayCaloriesBurnedInfo()));
        series2.getData().add(new XYChart.Data("Tuesday", user.fitness.getTuesdayCaloriesBurnedInfo()));
        series2.getData().add(new XYChart.Data("Wednesday", user.fitness.getWednesdayCaloriesBurnedInfo()));
        series2.getData().add(new XYChart.Data("Thursday", user.fitness.getThursdayCaloriesBurnedInfo()));
        series2.getData().add(new XYChart.Data("Friday", user.fitness.getFridayCaloriesBurnedInfo()));
        series2.getData().add(new XYChart.Data("Saturday", user.fitness.getSaturdayCaloriesBurnedInfo()));
        series2.getData().add(new XYChart.Data("Sunday", user.fitness.getSundayCaloriesBurnedInfo()));
        
        workoutStatsChart.getData().addAll(series,series2); 
	}
	
	@FXML
    void returnToActivities(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
		   Pane root = loader.load(new FileInputStream("src/application/FitnessTrackerActivity.fxml"));
		   ActivitiesController controller = (ActivitiesController)loader.getController();
		   
		   controller.setUser(user);
		   System.out.println("Setting user for activities controller from stats");
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

