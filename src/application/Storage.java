package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Storage {
	public static Storage storage = new Storage();
	
	private String stepsInformation;
	private String sleepInformation;
	private String waterInformation;
	private String weightInformation;
	private String caloriesBurnedInformation;
	private String exerciseInformation;  

    public String stepGoalsLabel;
    public String waterIntakeGoalsLabel;
    public String weightGoalsLabel;
    public String exerciseGoalsLabel;
    public String caloriesBurnedGoalsLabel;
    public String sleepGoalsLabel;
    
    public String todayExerciseLabel;
    
    @FXML
    private Button updateGoalsButton;

    @FXML
    private Button homeButton;


    public Storage(String stepsData, String sleepData, String waterData, String weightData, String caloriesData, String exerciseData) {
        this.stepsInformation = stepsData;
        this.sleepInformation = sleepData;
        this.waterInformation = waterData;
        this.weightInformation = weightData;
        this.caloriesBurnedInformation = caloriesData;
        this.exerciseInformation = exerciseData;
    }
    
    public Storage() {
		
	}

	public void setStepsGoals(String steps) {
    	this.stepsInformation = steps;
    }
    
    public void setSleepGoals(String sleep) {
    	this.sleepInformation = sleep;
    }
    public void setWaterIntakeGoals(String water) {
    	this.waterInformation = water;
    }
    
    public void setWeightGoals(String weight) {
    	this.weightInformation = weight;
    }
    
    public void setCaloriesGoals(String calories) {
    	this.caloriesBurnedInformation = calories;
    }
    
    public void setExerciseGoals(String exercise) {
    	this.exerciseInformation = exercise;
    }

	public String getStepsGoals() {
		return stepsInformation;
	}
	
	public String getSleepGoals() {
		return sleepInformation;
	}
	
	public String getWaterIntakeGoals() {
		return waterInformation;
	}
	
	public String getWeightGoals() {
		return weightInformation;
	}
	
	public String getCaloriesGoals() {
		return caloriesBurnedInformation;
	}
	
	public String getExerciseGoals() {
		return exerciseInformation;
	}
	
	 public void setStepsGoalsLabel(String stepsLabel) {
	 	this.stepGoalsLabel = stepsLabel;
	 }
	    
	 public void setSleepGoalsLabel(String sleepLabel) {
	    this.sleepGoalsLabel = sleepLabel;
	 }
	    
	 public void setWaterIntakeGoalsLabel(String waterLabel) {
	    this.waterIntakeGoalsLabel = waterLabel;
	 }
	    
	 public void setWeightGoalsLabel(String weightLabel) {
	    this.weightGoalsLabel = weightLabel;
	 }
	    
	 public void setCaloriesBurnedGoalsLabel(String caloriesLabel) {
	    this.caloriesBurnedGoalsLabel = caloriesLabel;
	 }
	    
	 public void setExerciseGoalsLabel(String exerciseLabel) {
		this.exerciseGoalsLabel = exerciseLabel;
	 }
	 
	 public void setTodaysExerciseLabel(String exercise) {
		 this.todayExerciseLabel = exercise;
	 }
	
}
