package application;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The Fitness class will verify and store a set of characteristics that are related to the user's fitness goals
 * that are unique to them based on the values entered.
 * This class will check and display errors entered by the user, such as invalid characters
 * or those out of acceptable range.
 * 
 * @author Camila Hernandez, Mariam Masri & Enes Gisi
 *
 */
public class Fitness extends Goals {

	private int stepsGoal = 0;
	private ArrayList<Integer> stepsArray = new ArrayList<Integer>(Collections.nCopies(30, 0));
	private int stepsCount = 0;
	private double caloriesBurnedGoal = 0.0;
	private double exerciseGoal = 0.0;
	private double progress = 0.0;
	private double totalCaloriesBurned = 0.0;
	private double mondayExerciseInfo = 0.0;
	private double tuesdayExerciseInfo = 0.0;
	private double wednesdayExerciseInfo = 0.0;
	private double thursdayExerciseInfo = 0.0;
	private double fridayExerciseInfo = 0.0;
	private double saturdayExerciseInfo = 0.0;
	private double sundayExerciseInfo = 0.0;
	private double mondayCaloriesBurnedInfo = 0.0;
	private double tuesdayCaloriesBurnedInfo = 0.0;
	private double wednesdayCaloriesBurnedInfo = 0.0;
	private double thursdayCaloriesBurnedInfo = 0.0;
	private double fridayCaloriesBurnedInfo = 0.0;
	private double saturdayCaloriesBurnedInfo = 0.0;
	private double sundayCaloriesBurnedInfo = 0.0;

	boolean reachStepsGoal = false;
	boolean reachExerciseGoal = false;
	boolean reachCaloriesBurnedGoal = false;

	double value;

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
	 * This method will set the user's input from the steps TextField from the GoalsController class.
	 * @param steps This is how many steps the user would like to take in a day.
	 */
	public void setStepsGoals(int steps) {
		this.stepsGoal = steps;
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
	 * This method will store the user's input from the TextField in the StepsController class.
	 * @param monthlySteps This is how many steps the user has taken.
	 */
	public void setStepsCount(int monthlySteps) {
		//Validation is done in array update so no need for it here (for loop in the controller)
		this.stepsCount = monthlySteps;
		checkGoalsCompleted();
	}	
	/**
	 * This method is used to compare the user's steps taken in a day to their goal.
	 * @return This getter method returns the steps count of the user.
	 */
	public int getStepsCount() {
		return stepsCount;
	}

	/**
	 * This method checks to see if the number of steps taken is an integer.
	 * @param str This is the number of steps taken.
	 * @return Returns false if the number entered is not an integer.
	 */
	public boolean isNumeric(String str){ 
		try {  
			Integer.parseInt(str);  
			return true;
		} catch(NumberFormatException e){  
			return false;  
		}  
	}

	/**
	 * This method will check if the user has selected the day of month in the ChoiceBox.
	 * @param dayOfMonthString This is the string that the user selected in the ChoiceBox.
	 * @throws InvalidUserInputException InvalidUserInputException This is the custom exception that is 
	 * thrown if the user's input is invalid.
	 */
	public void checkdayOfMonth(String dayOfMonthString) throws InvalidUserInputException {
		// Check if user input is empty
		if (dayOfMonthString == null) {
			throw new InvalidUserInputException("Please select a day of the month.");
		}
	}

	/**
	 * This method will increment the total steps taken monthly.
	 * @param dayOfMonthChoice This is the day of month the suer chooses.
	 * @param dailyStepCount This is how many steps the user took daily.
	 * @throws InvalidUserInputException This is the custom exception that is thrown if the user's input is invalid.
	 */
	public void updateMonthlySteps(int dayOfMonthChoice, String dailyStepCount) throws InvalidUserInputException{
		stepsCount = 0;
		if (isNumeric(dailyStepCount)) {
			stepsArray.set(dayOfMonthChoice-1, Integer.parseInt(dailyStepCount));
			for (int i = 0; i < stepsArray.size(); i++) {
				stepsCount += stepsArray.get(i);
			}
		}
		else {
			throw new InvalidUserInputException("Please enter steps as a numeric value");
		}
	}

	/**
	 * This method will store the suer's total calories burned from the calories burned TextFields in the Workouts
	 * tab in the Activities window.
	 * @param caloriesBurned This is the total calories the user burned through exercise.
	 */
	public void setTotalCaloriesBurned(double caloriesBurned) {
		this.totalCaloriesBurned = caloriesBurned;
		checkGoalsCompleted();
	}

	/**
	 * This method is used to store the user's total calories burned according to the day of the week.
	 * This is used to generate the weekly workout progress graph.
	 * @return This getter method returns the user's total calories burned for the day.
	 */
	public double getTotalCaloriesBurned() {
		return totalCaloriesBurned;
	}

	/**
	 * This method is used to store the user's total exercise duration from the exercise duration TextFields in the
	 * Workouts tab in the Activities window.
	 * @return This is the user's total exercise duration for the day.
	 */
	public void setProgress(double time) {
		this.progress = time;
		checkGoalsCompleted();
	}

	/**
	 * This method is used to store the user's total exercise duration according to the day of the week.
	 * This is used to generate the weekly workout progress graph.
	 * @return This getter method returns the user's total exercise duration for the day.
	 */
	public double getProgress() {
		return progress;
	}

	/**
	 * This method is used to store the user's total calories burned from the calories burned TextFields on Mondays.	 
	 * @param monday This is the user's total calories burned for Mondays.
	 */
	public void setMondayCaloriesBurnedInfo(double monday) {
		this.mondayCaloriesBurnedInfo = monday;
	}

	/**
	 * This method is used to store the user's total calories burned from the calories burned TextFields on Tuesdays.	 
	 * @param tuesday This is the user's total calories burned for Tuesdays.
	 */
	public void setTuesdayCaloriesBurnedInfo(double tuesday) {
		this.tuesdayCaloriesBurnedInfo = tuesday;
	}

	/**
	 * This method is used to store the user's total calories burned from the calories burned TextFields on Wednesdays.	 
	 * @param wednesday This is the user's total calories burned for Wednesdays.
	 */
	public void setWednesdayCaloriesBurnedInfo(double wednesday) {
		this.wednesdayCaloriesBurnedInfo = wednesday;
	}

	/**
	 * This method is used to store the user's total calories burned from the calories burned TextFields on Thursdays.	 
	 * @param thursday This is the user's total calories burned for Thursdays.
	 */
	public void setThursdayCaloriesBurnedInfo(double thursday) {
		this.thursdayCaloriesBurnedInfo = thursday;
	}

	/**
	 * This method is used to store the user's total calories burned from the calories burned TextFields on Fridays.	 
	 * @param friday This is the user's total calories burned for Fridays.
	 */
	public void setFridayCaloriesBurnedInfo(double friday) {
		this.fridayCaloriesBurnedInfo = friday;
	}

	/**
	 * This method is used to store the user's total calories burned from the calories burned TextFields on Saturdays.	 
	 * @param saturday This is the user's total calories burned for Saturdays.
	 */
	public void setSaturdayCaloriesBurnedInfo(double saturday) {
		this.saturdayCaloriesBurnedInfo = saturday;
	}

	/**
	 * This method is used to store the user's total calories burned from the calories burned TextFields on Sundays.	 
	 * @param sunday This is the user's total calories burned for Sundays.
	 */
	public void setSundayCaloriesBurnedInfo(double sunday) {
		this.sundayCaloriesBurnedInfo = sunday;
	}
	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total calories burned for Mondays.
	 */
	public double getMondayCaloriesBurnedInfo() {
		return mondayCaloriesBurnedInfo;
	}

	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total calories burned for Tuesdays.
	 */
	public double getTuesdayCaloriesBurnedInfo() {
		return tuesdayCaloriesBurnedInfo;
	}

	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total calories burned for Wednesdays.
	 */
	public double getWednesdayCaloriesBurnedInfo() {
		return wednesdayCaloriesBurnedInfo;
	}

	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total calories burned for Thursdays.
	 */
	public double getThursdayCaloriesBurnedInfo() {
		return thursdayCaloriesBurnedInfo;
	}

	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total calories burned for Fridays.
	 */
	public double getFridayCaloriesBurnedInfo() {
		return fridayCaloriesBurnedInfo;
	}

	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total calories burned for Saturdays.
	 */
	public double getSaturdayCaloriesBurnedInfo() {
		return saturdayCaloriesBurnedInfo;
	}

	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total calories burned for Sundays.
	 */
	public double getSundayCaloriesBurnedInfo() {
		return sundayCaloriesBurnedInfo;
	}

	/**
	 * This method is used to store the user's total exercise duration from the exercise duration TextFields on Mondays.	 
	 * @param monday This is the user's total exercise duration for Mondays.
	 */
	public void setMondayExerciseInfo(double monday) {
		this.mondayExerciseInfo = monday;
	}

	/**
	 * This method is used to store the user's total exercise duration from the exercise duration TextFields on Tuesdays.	 
	 * @param tuesday This is the user's total exercise duration for Tuesdays.
	 */
	public void setTuesdayExerciseInfo(double tuesday) {
		this.tuesdayExerciseInfo = tuesday;
	}

	/**
	 * This method is used to store the user's total exercise duration from the exercise duration TextFields on Wednesdays.	 
	 * @param wednesday This is the user's total exercise duration for Wednesdays.
	 */
	public void setWednesdaydayExerciseInfo(double wednesday) {
		this.wednesdayExerciseInfo = wednesday;
	}

	/**
	 * This method is used to store the user's total exercise duration from the exercise duration TextFields on Thursdays.	 
	 * @param thursday This is the user's total exercise duration for Thursdays.
	 */
	public void setThursdayExerciseInfo(double thursday) {
		this.thursdayExerciseInfo = thursday;
	}

	/**
	 * This method is used to store the user's total exercise duration from the exercise duration TextFields on Fridays.	 
	 * @param friday This is the user's total exercise duration for Fridays.
	 */
	public void setFridayExerciseInfo(double friday) {
		this.fridayExerciseInfo = friday;
	}

	/**
	 * This method is used to store the user's total exercise duration from the exercise duration TextFields on Saturdays.	 
	 * @param saturday This is the user's total exercise duration for Saturdays.
	 */
	public void setSaturdayExerciseInfo(double saturday) {
		this.saturdayExerciseInfo = saturday;
	}

	/**
	 * This method is used to store the user's total exercise duration from the exercise duration TextFields on Sundays.	 
	 * @param sunday This is the user's total exercise duration for Sundays.
	 */
	public void setSundayExerciseInfo(double sunday) {
		this.sundayExerciseInfo = sunday;
	}

	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total exercise duration for Mondays.
	 */
	public double getMondayExerciseInfo() {
		return mondayExerciseInfo;
	}

	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total exercise duration for Tuesdays.
	 */
	public double getTuesdayExerciseInfo() {
		return tuesdayExerciseInfo;
	}

	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total exercise duration for Wednesdays.
	 */
	public double getWednesdayExerciseInfo() {
		return wednesdayExerciseInfo;
	}

	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total exercise duration for Thursdays.
	 */
	public double getThursdayExerciseInfo() {
		return thursdayExerciseInfo;
	}

	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total exercise duration for Fridays.
	 */
	public double getFridayExerciseInfo() {
		return fridayExerciseInfo;
	}

	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total exercise duration for Saturdays.
	 */
	public double getSaturdayExerciseInfo() {
		return saturdayExerciseInfo;
	}

	/**
	 * This method is used to build the user's weekly workout progress graph.
	 * The user can input this information in the Workout tab.
	 * @return This getter method returns the user's total exercise duration for Sundays.
	 */
	public double getSundayExerciseInfo() {
		return sundayExerciseInfo;
	}

	/**
	 * This method gets called in three of the setter methods to check if the user has completed their daily goals.
	 * This method also calls a method in the Goals class which increments the number of goals completed.
	 */
	public void checkGoalsCompleted() {
		// If the user has reached their goal, it calls a method in the Goals class
		// and turns booleans true so that the user cannot reach the goal multiple time in one day
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
	 * This method will check if the user's weight and height that they have inputed in the TextFields in the
	 * User Profile window are valid numbers.
	 * @param valueEntered This is the value that the user entered into the TextField as a string.
	 * @throws InvalidUserInputException This is the custom exception that is thrown if the user's input is invalid.
	 */
	public void checkInput(String valueEntered) throws InvalidUserInputException {	
		boolean decimalEncountered = false;
		if (valueEntered.isEmpty()) {
			throw new InvalidUserInputException("Please fill out all required TextFields.");
		}
		else {
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

	/**
	 * This method will check if the user's steps count that they have entered in the TextFields in the
	 * Steps window are valid numbers.
	 * @param str This is the value that the user entered into the TextField as a string.
	 * @throws InvalidUserInputException This is the custom exception that is thrown if the user's input is invalid.
	 */
	public void checkIntegers(String str) throws InvalidUserInputException {	
		// Check if user input is empty
		if (str.isEmpty()) {
			throw new InvalidUserInputException("Please fill out all required TextFields.");
		}
		else {
			for (char c : str.toCharArray()) {
				// Check if the character is a digit
				if (!Character.isDigit(c)) {
					throw new InvalidUserInputException("Make sure to enter a valid number.");
				}
			}
		}
	}

}
