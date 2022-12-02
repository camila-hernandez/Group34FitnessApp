package application;

public class Fitness extends Goals {
	
	private double stepGoals;
	private double stepsTaken;
	private double caloriesBurnedGoals;
	private double exerciseGoals;
	private double progress;
	private double totalCaloriesBurned;
	private double mondayExerciseInfo;
	private double tuesdayExerciseInfo;
	private double wednesdayExerciseInfo;
	private double thursdayExerciseInfo;
	private double fridayExerciseInfo;
	private double saturdayExerciseInfo;
	private double sundayExerciseInfo;
	private double mondayCaloriesBurnedInfo;
	private double tuesdayCaloriesBurnedInfo;
	private double wednesdayCaloriesBurnedInfo;
	private double thursdayCaloriesBurnedInfo;
	private double fridayCaloriesBurnedInfo;
	private double saturdayCaloriesBurnedInfo;
	private double sundayCaloriesBurnedInfo;
	private String stepsGoalsLabel;
	private String caloriesBurnedGoalsLabel;
	private String exerciseGoalsLabel;
	private String todaysExerciseMotivationalLabel;
	
	boolean reachStepsGoals = false;
	boolean reachExerciseGoals = false;
	boolean reachCaloriesBurnedGoals = false;
	
	public Fitness() {
		stepGoals = 0.0;
		caloriesBurnedGoals = 0.0;
		exerciseGoals = 0.0;
		progress = 0.0;
		totalCaloriesBurned = 0.0;
		mondayExerciseInfo = 0.0;
		tuesdayExerciseInfo = 0.0;
		wednesdayExerciseInfo = 0.0;
		thursdayExerciseInfo = 0.0;
		fridayExerciseInfo = 0.0;
		saturdayExerciseInfo = 0.0;
		sundayExerciseInfo = 0.0;
		mondayCaloriesBurnedInfo = 0.0;
		tuesdayCaloriesBurnedInfo = 0.0;
		wednesdayCaloriesBurnedInfo = 0.0;
		thursdayCaloriesBurnedInfo = 0.0;
		fridayCaloriesBurnedInfo = 0.0;
		saturdayCaloriesBurnedInfo = 0.0;
		sundayCaloriesBurnedInfo = 0.0;
	}
	
	public void setStepsGoals(double steps) {
		this.stepGoals = steps;
    }
    
    public void setCaloriesGoals(double calories) {
		this.caloriesBurnedGoals = calories;
    }
    
    public void setExerciseGoals(double exercise) {
		this.exerciseGoals = exercise;
    }
    
    public double getStepsGoals() {
		return stepGoals;
	}
	
	public double getCaloriesGoals() {
		return caloriesBurnedGoals;
	}
	
	public double getExerciseGoals() {
		return exerciseGoals;
	}
	public void setStepsGoalsLabel(String stepsLabel) {
		 this.stepsGoalsLabel = stepsLabel;
	}
		    
	public void setCaloriesBurnedGoalsLabel(String caloriesLabel) {
		 this.caloriesBurnedGoalsLabel = caloriesLabel;
	}
		    
	public void setExerciseGoalsLabel(String exerciseLabel) {
		this.exerciseGoalsLabel = exerciseLabel;
	}
		 
	public void setTodaysExerciseMotivationalLabel(String motivation) {
		this.todaysExerciseMotivationalLabel = motivation;
	}
		
	public void setTotalCaloriesBurned(double caloriesBurned) {
		 this.totalCaloriesBurned = caloriesBurned;
		 if ((totalCaloriesBurned >= caloriesBurnedGoals) && (!reachCaloriesBurnedGoals)) {
				completeGoal();
			}
	 }
	 
	 public double getTotalCaloriesBurned() {
		 return totalCaloriesBurned;
	 }
	 
	 public void setProgress(double time) {
		 this.progress = time;
		 if ((progress >= exerciseGoals) && (!reachExerciseGoals)) {
				completeGoal();
			}
	 }
	 
	 public double getProgress() {
		 return progress;
	 }
	 
	 public void setStepsTaken(double steps) {
		 this.stepsTaken = steps;
		 if ((stepsTaken >= stepGoals) && (!reachStepsGoals)) {
				completeGoal();
			}
	 }
	 
	 public double getStepsTaken() {
		 return stepsTaken;
	 }

	 public void setMondayCaloriesBurnedInfo(double monday) {
		 this.mondayCaloriesBurnedInfo = monday;
	 }
	 
	 public void setTuesdayCaloriesBurnedInfo(double tuesday) {
		 this.tuesdayCaloriesBurnedInfo = tuesday;
	 }
	 
	 public void setWednesdayCaloriesBurnedInfo(double wednesday) {
		 this.wednesdayCaloriesBurnedInfo = wednesday;
	 }
	 
	 public void setThursdayCaloriesBurnedInfo(double thursday) {
		 this.thursdayCaloriesBurnedInfo = thursday;
	 }
	 
	 public void setFridayCaloriesBurnedInfo(double friday) {
		 this.fridayCaloriesBurnedInfo = friday;
	 }
	 
	 public void setSaturdayCaloriesBurnedInfo(double saturday) {
		 this.saturdayCaloriesBurnedInfo = saturday;
	 }
	 
	 public void setSundayCaloriesBurnedInfo(double sunday) {
		 this.sundayCaloriesBurnedInfo = sunday;
	 }
	 public double getMondayCaloriesBurnedInfo() {
		 return mondayCaloriesBurnedInfo;
	 }
	 
	 public double getTuesdayCaloriesBurnedInfo() {
		 return tuesdayCaloriesBurnedInfo;
	 }
	 
	 public double getWednesdayCaloriesBurnedInfo() {
		 return wednesdayCaloriesBurnedInfo;
	 }
	 
	 public double getThursdayCaloriesBurnedInfo() {
		 return thursdayCaloriesBurnedInfo;
	 }
	 
	 public double getFridayCaloriesBurnedInfo() {
		 return fridayCaloriesBurnedInfo;
	 }
	 
	 public double getSaturdayCaloriesBurnedInfo() {
		 return saturdayCaloriesBurnedInfo;
	 }
	 
	 public double getSundayCaloriesBurnedInfo() {
		 return sundayCaloriesBurnedInfo;
	 }

	 public void setMondayExerciseInfo(double monday) {
		 this.mondayExerciseInfo = monday;
	 }
	 
	 public void setTuesdayExerciseInfo(double tuesday) {
		 this.tuesdayExerciseInfo = tuesday;
	 }
	 
	 public void setWednesdaydayExerciseInfo(double wednesday) {
		 this.wednesdayExerciseInfo = wednesday;
	 }
	 
	 public void setThursdayExerciseInfo(double thursday) {
		 this.thursdayExerciseInfo = thursday;
	 }
	 
	 public void setFridayExerciseInfo(double friday) {
		 this.fridayExerciseInfo = friday;
	 }
	 
	 public void setSaturdayExerciseInfo(double saturday) {
		 this.saturdayExerciseInfo = saturday;
	 }
	 
	 public void setSundayExerciseInfo(double sunday) {
		 this.sundayExerciseInfo = sunday;
	 }
	 
	 public double getMondayExerciseInfo() {
		 return mondayExerciseInfo;
	 }
	 
	 public double getTuesdayExerciseInfo() {
		 return tuesdayExerciseInfo;
	 }
	 
	 public double getWednesdayExerciseInfo() {
		 return wednesdayExerciseInfo;
	 }
	 
	 public double getThursdayExerciseInfo() {
		 return thursdayExerciseInfo;
	 }
	 
	 public double getFridayExerciseInfo() {
		 return fridayExerciseInfo;
	 }
	 
	 public double getSaturdayExerciseInfo() {
		 return saturdayExerciseInfo;
	 }
	 
	 public double getSundayExerciseInfo() {
		 return sundayExerciseInfo;
	 }
	 
}
