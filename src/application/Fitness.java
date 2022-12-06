package application;

import java.util.ArrayList;
import java.util.Collections;

public class Fitness extends Goals {
	
	private double stepsGoal;
	private ArrayList<Integer> stepsArray;
	private int stepsCount;
	private double caloriesBurnedGoal;
	private double exerciseGoal;
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
	
	boolean reachStepsGoal = false;
	boolean reachExerciseGoal = false;
	boolean reachCaloriesBurnedGoal = false;

	double value;
	
	User user;
	
	public Fitness() {
		stepsArray = new ArrayList<Integer>(Collections.nCopies(60, 0));
		stepsCount = 0;
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

	public void checkGoalsCompleted() {
		if ((stepsCount >= stepsGoal) && (!reachStepsGoal)) {
			completeGoal();
			reachStepsGoal = true;
		}
		if ((progress >= exerciseGoal) && (!reachExerciseGoal)) {
			completeGoal();
			reachExerciseGoal = true;
		}
		if (totalCaloriesBurned >= caloriesBurnedGoal && !reachCaloriesBurnedGoal) {
			completeGoal();
			reachCaloriesBurnedGoal = true;
		}
	}
	
	public void checkInput(String valueEntered) throws InvalidUserInputException {	
		boolean decimalEncountered = false;
		for (char c :valueEntered.toCharArray()) {
			// Check if the character is a '.'
			// If the character is a '.' and the for loop has not encountered a '.' yet, 
			// then it will indicate this '.' to be a decimal.
			if (c == '.' && !decimalEncountered) {
				decimalEncountered = true;
			}
			// Check if the character is a digit if it's not a decimal
			else if (!Character.isDigit(c)) {
				throw new InvalidUserInputException("Make sure to enter a valid number.");
			}
		}
		
		value = Double.parseDouble(valueEntered);
		
		if (value < 0) {
			throw new InvalidUserInputException("Number should be greater than 0.");
		}
	}

	public void setStepsGoals(double steps) {
		this.stepsGoal = steps;
    }
	

	//STEPS VALIDATION + GETTER + SETTER (make this to deal with the array list)
	public double getStepsCount() {
		return stepsCount;
	}
	
	public static boolean isNumeric(String str){ 
		  try {  
			Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	//validation done in array update so no need for it here (for loop in the controller)
	public void setStepsCount(int monthlySteps) {
			this.stepsCount = monthlySteps;
	}
	
	public void updateMonthlySteps(int dayOfMonthChoice, String dailyStepCount) throws InvalidUserInputException{
		if (isNumeric(dailyStepCount)) {
			stepsArray.set(dayOfMonthChoice, Integer.parseInt(dailyStepCount));
			for (int i = 0; i < stepsArray.size(); i++) {
				stepsCount += stepsArray.get(i);
				}
		}
		else {throw new InvalidUserInputException("Your input must be numeric");}
	}
    //*****************************************

    public void setCaloriesGoals(double calories) {
		this.caloriesBurnedGoal = calories;
    }
    
    public void setExerciseGoals(double exercise) {
		this.exerciseGoal = exercise;
    }
    
    public double getStepsGoals() {
		return stepsGoal;
	}
	
	public double getCaloriesGoals() {
		return caloriesBurnedGoal;
	}
	
	public double getExerciseGoals() {
		return exerciseGoal;
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
	 }
	 
	 public double getTotalCaloriesBurned() {
		 return totalCaloriesBurned;
	 }
	 
	 public void setProgress(double time) {
		 this.progress = time;
	 }
	 
	 public double getProgress() {
		 return progress;
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
