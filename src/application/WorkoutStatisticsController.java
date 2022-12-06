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
	
    /**
	 * This method will allow for the same User object to be passed between different controllers.
	 * The user can access the same properties in each scene.
	 * @param user This is the User object.
	 */
	public void setUser(User user) {
		this.user = user;
		
	}
	
	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total exercise duration for Mondays.
	 */
	public double getMondaysExerciseDuration() {
		return user.fitness.getMondayExerciseInfo();
	}
	
	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total exercise duration for Tuesdays.
	 */
	public double getTuesdaysExerciseDuration() {
		return user.fitness.getTuesdayExerciseInfo();
	}
	
	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total exercise duration for Wednesdays.
	 */
	public double getWednesdaysExerciseDuration() {
		return user.fitness.getWednesdayExerciseInfo();
	}
	
	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total exercise duration for Thursdays.
	 */
	public double getThursdaysExerciseDuration() {
		return user.fitness.getThursdayExerciseInfo();
	}
	
	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total exercise duration for Fridays.
	 */
	public double getFridaysExerciseDuration() {
		return user.fitness.getFridayExerciseInfo();
	}
	
	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total exercise duration for Saturdays.
	 */
	public double getSaturdaysExerciseDuration() {
		return user.fitness.getSaturdayExerciseInfo();
	}
	
	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total exercise duration for Sundays.
	 */
	public double getSundaysExerciseDuration() {
		return user.fitness.getSundayExerciseInfo();
	}
	
	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total calories burned for Mondays.
	 */
	public double getMondaysCaloriesBurnedValues() {
		return user.fitness.getMondayCaloriesBurnedInfo();
	}
	
	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total calories burned for Tuesdays.
	 */
	public double getTuesdaysCaloriesBurnedValues() {
		return user.fitness.getTuesdayCaloriesBurnedInfo();
	}
	
	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total calories burned for Wednesdays.
	 */
	public double getWednesdaysCaloriesBurnedValues() {
		return user.fitness.getWednesdayCaloriesBurnedInfo();
	}
	
	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total calories burned for Thursdays.
	 */
	public double getThursdaysCaloriesBurnedValues() {
		return user.fitness.getThursdayCaloriesBurnedInfo();
	}
	
	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total calories burned for Fridays.
	 */
	public double getFridaysCaloriesBurnedValues() {
		return user.fitness.getFridayCaloriesBurnedInfo();
	}
	
	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total calories burned for Saturdays.
	 */
	public double getSaturdaysCaloriesBurnedValues() {
		return user.fitness.getSaturdayExerciseInfo();
	}
	
	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total calories burned for Sundays.
	 */
	public double getSundaysCaloriesBurnedValues() {
		return user.fitness.getSundayCaloriesBurnedInfo();
	}

	/**
	 * This method creates a bar graph from the values entered by the user in the Workout tabs
	 * in the Activities window.
	 * This graph will show the user their weekly workout progress in terms of exercise duration
	 * and the total calories burned through exercise.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void createWorkoutStatisticsBarGraph() {	
		XYChart.Series	series = new XYChart.Series();
		series.setName("Daily workout duration (mins)");
		//Populating the series with data
        series.getData().add(new XYChart.Data("Monday", getMondaysExerciseDuration()));
        series.getData().add(new XYChart.Data("Tuesday", getTuesdaysExerciseDuration()));
        series.getData().add(new XYChart.Data("Wednesday", getWednesdaysExerciseDuration()));
        series.getData().add(new XYChart.Data("Thursday", getThursdaysExerciseDuration()));
        series.getData().add(new XYChart.Data("Friday", getFridaysExerciseDuration()));
        series.getData().add(new XYChart.Data("Saturday", getSaturdaysExerciseDuration()));
        series.getData().add(new XYChart.Data("Sunday", getSundaysExerciseDuration()));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Daily amount of calories burned (cal)");
        //Populating the series with data
        series2.getData().add(new XYChart.Data("Monday", getMondaysCaloriesBurnedValues()));
        series2.getData().add(new XYChart.Data("Tuesday", getTuesdaysCaloriesBurnedValues()));
        series2.getData().add(new XYChart.Data("Wednesday", getWednesdaysCaloriesBurnedValues()));
        series2.getData().add(new XYChart.Data("Thursday", getThursdaysCaloriesBurnedValues()));
        series2.getData().add(new XYChart.Data("Friday", getFridaysCaloriesBurnedValues()));
        series2.getData().add(new XYChart.Data("Saturday", getSaturdaysCaloriesBurnedValues()));
        series2.getData().add(new XYChart.Data("Sunday", getSundaysCaloriesBurnedValues()));
        
        // Adds all data to graph
        workoutStatsChart.getData().addAll(series,series2); 
	}
	
	/**
	 * This ActionEvent changes the scene back to the main page while passing the same User
	 * object and setting various labels in the main page.
	 * @param returnToActivitiesEvent Changes the scene back to the main page.
	 */
	@FXML
    void returnToActivities(ActionEvent returnToActivitiesEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
		   Pane root = loader.load(new FileInputStream("src/application/FitnessTrackerActivity.fxml"));
		   ActivitiesController controller = (ActivitiesController)loader.getController();
		   
		   controller.setUser(user);
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

