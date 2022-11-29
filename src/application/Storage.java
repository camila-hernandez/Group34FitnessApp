package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Storage {
	public static Storage storage = new Storage();
	
	private String stepsInformation = "0";
	private String sleepInformation = "0";
	private String waterInformation = "0";
	private String weightInformation = "0";
	private String caloriesBurnedInformation = "0";
	private String exerciseInformation = "0";  

    public String stepGoalsLabel = "0";
    public String waterIntakeGoalsLabel = "0";
    public String weightGoalsLabel = "0";
    public String exerciseGoalsLabel = "0";
    public String caloriesBurnedGoalsLabel = "0";
    public String sleepGoalsLabel = "0";
    
    public String todayExerciseLabel = "0";
    public String todayExerciseMotivationalLabel;
    
    public double progress;
    
    public String mondayExerciseInfo = "0.0";
    public String tuesdayExerciseInfo = "0.0";
    public String wednesdayExerciseInfo = "0.0";
    public String thursdayExerciseInfo = "0.0";
    public String fridayExerciseInfo = "0.0";
    public String saturdayExerciseInfo = "0.0";
    public String sundayExerciseInfo = "0.0";
    
    
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
	 
	 public String getTodaysExercise() {
		 return todayExerciseLabel;
	 }
	
	 public void setTodaysExerciseMotivationalLabel(String motivation) {
		 this.todayExerciseMotivationalLabel = motivation;
	 }
	 
	 public void setProgress(double time) {
		 this.progress = time;
	 }
	 
	 public double getProgress() {
		 return progress;
	 }

	 public void setMondayExerciseInfo(String monday) {
		 this.mondayExerciseInfo = monday;
	 }
	 
	 public void setTuesdayExerciseInfo(String tuesday) {
		 this.tuesdayExerciseInfo = tuesday;
	 }
	 
	 public void setWednesdaydayExerciseInfo(String wednesday) {
		 this.wednesdayExerciseInfo = wednesday;
	 }
	 
	 public void setThursdayExerciseInfo(String thursday) {
		 this.thursdayExerciseInfo = thursday;
	 }
	 
	 public void setFridayExerciseInfo(String friday) {
		 this.fridayExerciseInfo = friday;
	 }
	 
	 public void setSaturdayExerciseInfo(String saturday) {
		 this.saturdayExerciseInfo = saturday;
	 }
	 
	 public void setSundayExerciseInfo(String sunday) {
		 this.sundayExerciseInfo = sunday;
	 }
	 
	 public String getMondayExerciseInfo() {
		 return mondayExerciseInfo;
	 }
	 
	 public String getTuesdayExerciseInfo() {
		 return tuesdayExerciseInfo;
	 }
	 
	 public String getWednesdayExerciseInfo() {
		 return wednesdayExerciseInfo;
	 }
	 
	 public String getThursdayExerciseInfo() {
		 return thursdayExerciseInfo;
	 }
	 
	 public String getFridayExerciseInfo() {
		 return fridayExerciseInfo;
	 }
	 
	 public String getSaturdayExerciseInfo() {
		 return saturdayExerciseInfo;
	 }
	 
	 public String getSundayExerciseInfo() {
		 return sundayExerciseInfo;
	 }
	 
}

