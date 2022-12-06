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
	// empty constructor
	public Fitness() {
		stepsArray = new ArrayList<Integer>(Collections.nCopies(30, 0));
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
	
	/**
     * This method will set the user's input from the steps TextField from the GoalsController class.
     * @param steps This is how many steps the user would like to take in a day.
	 */
	public void setStepsGoals(int steps) {
		this.stepsGoal = steps;
    }
	

	//STEPS VALIDATION + GETTER + SETTER (make this to deal with the array list)
	public int getStepsCount() {
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
		stepsCount = 0;
		if (isNumeric(dailyStepCount)) {
				stepsArray.set(dayOfMonthChoice-1, Integer.parseInt(dailyStepCount));
				for (int i = 0; i < stepsArray.size(); i++) {
					stepsCount += stepsArray.get(i);
				}
		}
		else {throw new InvalidUserInputException("Please enter steps as a numeric value");}
	}

	/**
     * This method will set the user's input from the calories burned TextField from the GoalsController class.
     * @param calories This is how many calories the user would like to burn in a day.
     */
    public void setCaloriesGoals(double calories) {
		this.caloriesBurnedGoal = calories;
    }
    /**
     * This method will set the user's input from the exercise duration TextField from the GoalsController class.
     * @param exercise This is how long the user would like to exercise for in a day.
     */
    public void setExerciseGoals(double exercise) {
		this.exerciseGoal = exercise;
    }
    
    /**
	 * This method is used to compare the daily steps taken by the user to their goal.
	 * @return This getter method returns the steps goal of the user.
	 */
    public int getStepsGoals() {
		return stepsGoal;
	}
	
    /**
	 * This method is used to compare the amount of calories burned by the user in a day to their goal.
	 * @return This getter method returns the calories burned goal of the user.
	 */
	public double getCaloriesGoals() {
		return caloriesBurnedGoal;
	}
	
	/**
	 * This method is used to compare the user's exercise duration in a day to their goal.
	 * @return This getter method returns the exercise duration goal of the user.
	 */
	public double getExerciseGoals() {
		return exerciseGoal;
	}
	
	/**
	 * 
	 * @param caloriesBurned
	 */
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

}
