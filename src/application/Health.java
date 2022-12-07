package application;

/**
 * The Health class will verify and store a set of characteristics that are related to the user's health goals
 * that are unique to them based on the values entered.
 * The Health class will also perform calculation based on the information entered by the user.
 * This class will check and display errors entered by the user, such as invalid characters
 * or those out of acceptable range.
 * 
 * @author Camila Hernandez, Mariam Masri & Enes Gisi
 *
 */
public class Health extends Goals {

	User user;

	private double sleepGoals = 0.0;
	private double waterIntakeGoals = 0.0;
	private double weightGoals = 0.0;
	private double startingWeight = 0.0;
	private double currentWeight = 0.0;
	private double height = 0.0;
	private double waterIntakeAmount = 0.0;
	private String waterProgressTotalLabel = "";
	private double sleepDuration = 0.0;
	private String sleepProgressLabel = "";

	private double carbs = 0.0;
	private double fat = 0.0;
	private double protein = 0.0;

	double value;

	// Booleans turn true if the user has achieved their goal
	boolean reachSleepGoal = false;
	boolean reachWaterIntakeGoal = false;
	boolean reachWeightGoal = false;

	/**
	 * userSleepGoal is how long the user aims to sleep (in hours) without interruptions throughout the night.
	 * The user can input this information in the Goals window.
	 * The user's sleep goal is defaulted to zero.
	 * @param userSleepGoal This double must consist of only numbers, a single decimal point 
	 * and must be greater than zero.
	 */
	public void setSleepGoals(double userSleepGoal) {
		this.sleepGoals = userSleepGoal;
	}

	/**
	 * userWaterIntakeGoal is how many cups of water the user aims to drink in a day.
	 * The user can input this information in the Goals window.
	 * The user's water in-take goal is defaulted to zero.
	 * @param userWaterGoal This double must consist of only numbers, a single decimal point 
	 * and must be greater than zero.
	 */
	public void setWaterIntakeGoals(double userWaterIntakeGoal) {
		this.waterIntakeGoals = userWaterIntakeGoal;
	}

	/**
	 * userWeightGoal is how much the user aims to weigh (in kilograms) throughout their fitness journey.
	 * The user can input this information in the Goals window.
	 * The user's weight goal is defaulted to zero.
	 * @param userWeightGoal This double must consist of only numbers, a single decimal point 
	 * and must be greater than zero.
	 */
	public void setWeightGoals(double userWeightGoal) {
		this.weightGoals = userWeightGoal;
	}

	/**
	 * This method is used to display the user's sleep goal in the Goals window after it has been set.
	 * This method is also used to calculate the user's progress to achieve their goal.
	 * @return This getter method returns the sleep goal of the user.
	 */
	public double getSleepGoals() {
		return sleepGoals;
	}

	/**
	 * This method is used to display the user's water in-take goal in the Goals window after it has been set.
	 * This method is also used to calculate the user's progress to achieve their goal.
	 * @return This getter method returns the water in-take goal of the user.
	 */
	public double getWaterIntakeGoals() {
		return waterIntakeGoals;
	}

	/**
	 * This method is used to display the user's weight goal in the Goals window after it has been set.
	 * This method is also used to calculate the user's progress to achieve their goal.
	 * @return This getter method returns the weight goal of the user.
	 */
	public double getWeightGoals() {
		return weightGoals;
	}

	/**
	 * aWeight is the starting weight (in kilograms) of the user that can be inputed in the User Profile window.
	 * The starting weight is defaulted to an empty string.
	 * @param aWeight This double must consist of only numbers, a single decimal point and must be greater than zero.
	 */
	public void setStartingWeight(double aWeight) {
		this.startingWeight = aWeight;
	}
	/**
	 * This method is used to compare the user's starting weight to their current weight.
	 * @return This getter method returns the starting weight of the user.
	 */
	public double getStartingWeight() {
		return startingWeight;
	}

	/**
	 * aHeight is the height (in centimeters) of the user that can be inputed in the User Profile window.
	 * Height is defaulted to an empty string.
	 * @param aHeight This double must consist of only numbers, a single decimal point and must be greater than zero.
	 */
	public void setHeight(Double aHeight) {
		this.height = aHeight;
	}

	/**
	 * This method is used to calculate the body mass index of the user.
	 * @return This getter method returns the height of the user.
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * aWeight is the current weight (in kilograms) of the user that can be inputed in the Nutrition window.
	 * The current weight is defaulted to an empty string.
	 * @param aWeight This double must consist of only numbers, a single decimal point and must be greater than zero.
	 */
	public void setCurrentWeight(double aWeight) {
		this.currentWeight = aWeight;
		// Call method in Health class
		checkGoalsCompleted();
	}

	/**
	 * This method is used to calculate the body mass index of the user.
	 * Also, this method is used to compare the user's current weight to their weight goal.
	 * achieve their weight goal.
	 * @return This getter method returns the current weight of the user.
	 */
	public double getCurrentWeight() {
		return currentWeight;
	}

	/**
	 * userWaterIntakeAmount is the how much water (in cups) the user has drank today.
	 * The user can input this information in the Water In-take window.
	 * Their water in-take is defaulted to zero.
	 * This setter method also checks to see if the user has completed their water in-take goal for the day.
	 * @param userWaterIntakeAmount This double must consist of only numbers, a single decimal point 
	 * and must be greater than zero.
	 */
	public void setWaterIntakeAmount(double userWaterIntakeAmount) {
		this.waterIntakeAmount = userWaterIntakeAmount;
		// Call method in Health class
		checkGoalsCompleted();
	}

	/**
	 * This method is used to calculate the user's progress to their water in-take goal.
	 * @return This getter method returns the water in-take amount of the user for the day.
	 */
	public double getWaterIntakeAmount() {
		return waterIntakeAmount;
	}

	/**
	 * userSleepDuration is the how much sleep (in hours) the user got today.
	 * The user can input this information in the Sleep window.
	 * Their sleep duration is defaulted to zero.
	 * @param userSleepDuration This double must consist of only numbers, a single decimal point 
	 * and must be greater than zero.
	 */
	public void setSleepDuration(double userSleepDuration) {
		this.sleepDuration = userSleepDuration;
		// Call method in Health class
		checkGoalsCompleted();
	}

	/**
	 * This method is used to calculate the user's progress to their sleep goal.
	 * @return This getter method returns how long the user slept for during one night.
	 */
	public double getSleepDuration() {
		return sleepDuration;
	}

	/**
	 * This method calculates the user's current body mass index (BMI).
	 * @return Returns the user's body mass index.
	 */
	public double calculateBMI(double weight, double height) {
		return ((weight / height) / height) * 10000;
	}
	
	/**
	 * sleepProgressLabel is the label in the main window that will display how many hours of sleep
	 * the user got today.
	 * @param sleepProgressLabel This string gets converted from a double.
	 */
	public void setSleepProgressLabel(String sleepProgressLabel) {
		this.sleepProgressLabel = sleepProgressLabel;
	}
	
	/**
	 * This method displays the user's sleep duration for the night on the main window.
	 * @return This getter method is returns the user's daily sleep duration progress in a label.
	 */
	public String getSleepProgressLabel() {
		return sleepProgressLabel;
	}
	
	/**
	 * waterProgressLabel is the label in the main window that will display how many cups of water
	 * the user drank today.
	 * @param waterProgressLabel This string gets converted from a double.
	 */
	public void setWaterProgressLabel(String waterProgressLabel) {
		this.waterProgressTotalLabel = waterProgressLabel;
	}

	/**
	 * This method displays the user's water in-take amount for the day on the main window.
	 * @return This getter method is returns the user's daily water in-take progress in a label.
	 */
	public String getWaterProgressLabel() {
		return waterProgressTotalLabel;
	}

	/**
	 * This method calculates the amount of carbohydrates the user consumed for the day.
	 * @return This method returns the amount of carbohydrates consumed.
	 */
	double calculateCarbs() {
		return (getCarbs() * 50 / 100);
	}
	
	/**
	 * This method calculates the amount of fat the user consumed for the day.
	 * @return This method returns the amount of fat consumed.
	 */
	double calculateFat() {
		return (getFat() * 30 / 100);
	}
	
	/**
	 * This method calculates the amount of protein the user consumed for the day.
	 * @return This method returns the amount of protein consumed.
	 */
	double calculateProtein() {
		return (getProtein() * 30 / 100);
	}
	
	/**
	 * This method is used to calculate the user's carbohydrates consumption for the day.
	 * @return This getter method returns the carbohydrate in-take amount of the user for the day.
	 */
	public double getCarbs() {
		return carbs;
	}

	/**
	 * carbs is the how many carbohydrates (in g) the user consumed today.
	 * The user can input this information in the Nutrition window.
	 * Their carbohydrate consumption is defaulted to zero.
	 * @param carbs This double must consist of only numbers, a single decimal point 
	 * and must be greater than zero.
	 */
	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}

	/**
	 * This method is used to calculate the user's fat consumption for the day.
	 * @return This getter method returns the fat in-take amount of the user for the day.
	 * @return
	 */
	public double getFat() {
		return fat;
	}

	/**
	 * fat is the how much fat (in g) the user consumed today.
	 * The user can input this information in the Nutrition window.
	 * Their fat consumption is defaulted to zero.
	 * @param fat This double must consist of only numbers, a single decimal point 
	 * and must be greater than zero.
	 */
	public void setFat(double fat) {
		this.fat = fat;
	}

	/**
	 * This method is used to calculate the user's protein consumption for the day.
	 * @return This getter method returns the protein in-take amount of the user for the day.
	 */
	public double getProtein() {
		return protein;
	}
	
	/**
	 * protein is the how much protein (in g) the user consumed today.
	 * The user can input this information in the Nutrition window.
	 * Their protein consumption is defaulted to zero.
	 * @param protein This double must consist of only numbers, a single decimal point 
	 * and must be greater than zero.
	 */
	public void setProtein(double protein) {
		this.protein = protein;
	}

	/**
	 * This method gets called in three of the setter methods to check if the user has completed their daily goals.
	 * This method also calls a method in the Goals class which increments the number of goals completed.
	 */
	public void checkGoalsCompleted() {
		// If the user has reached their goal, it calls a method in the Goals class
		// and turns booleans true so that the user cannot reach the goal multiple time in one day
		System.out.println("Sleep count: " + sleepDuration + "Sleep goal: " + sleepGoals);
		if ((sleepDuration >= sleepGoals) && (!reachSleepGoal)) {
			completeGoal();
			reachSleepGoal = true;
		}
		System.out.println("water count: " + waterIntakeAmount + "water goal: " + waterIntakeGoals);
		if (waterIntakeAmount >= waterIntakeGoals && (!reachWaterIntakeGoal)) {
			completeGoal();
			reachWaterIntakeGoal = true;
		}
		System.out.println("weight count: " + currentWeight + "Steps goal: " + weightGoals);
		if((currentWeight >= weightGoals) && (!reachWeightGoal)) {
			completeGoal();
			reachWeightGoal = true;
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
}
