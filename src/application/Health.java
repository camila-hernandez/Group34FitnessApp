package application;

public class Health extends Goals {

	User user;

	private double sleepGoals;
	private double waterIntakeGoals;
	private double weightGoals;
	private double weight;
	private double height;
	private double waterIntakeAmount;
	private String waterProgressTotalLabel;
	private double sleepDuration;
	private String sleepProgressLabel;

	private double carbs;
	private double fat;
	private double protein;
	private double currentWeight;

	double value;

	// Booleans turn true if the user has achieved their goal
	boolean reachSleepGoal = false;
	boolean reachWaterIntakeGoal = false;
	boolean reachWeightGoal = false;

	public Health() {
		// TODO Auto-generated constructor stub
	}

	public void checkGoalsCompleted() {
		if ((sleepDuration >= sleepGoals) && (!reachSleepGoal)) {
			completeGoal();
			reachSleepGoal = true;
		}
		if (waterIntakeAmount >= waterIntakeGoals && (!reachWaterIntakeGoal)) {
			completeGoal();
			reachWaterIntakeGoal = true;
		}
		if((currentWeight >= weightGoals) && (!reachWeightGoal)) {
			completeGoal();
			reachWeightGoal = true;
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

	public void setSleepGoals(double sleep) {
		this.sleepGoals = sleep;
	}

	public void setWaterIntakeGoals(double water) {
		this.waterIntakeGoals = water;
	}

	public void setWeightGoals(double weight) {
		this.weightGoals = weight;
	}

	public double getSleepGoals() {
		return sleepGoals;
	}

	public double getWaterIntakeGoals() {
		return waterIntakeGoals;
	}

	public double getWeightGoals() {
		return weightGoals;
	}

	public void setWeight(double aWeight) {
		this.weight = aWeight;
	}

	public double getWeight() {
		return weight;
	}

	public void setHeight(Double aHeight) {
		this.height = aHeight;
	}

	public double getHeight() {
		return height;
	}

	public void setWaterIntakeAmount(double water) {
		this.waterIntakeAmount = water;
		checkGoalsCompleted();
	}

	public double getWaterIntakeAmount() {
		return waterIntakeAmount;
	}

	public void setSleepDuration(double sleep) {
		this.sleepDuration = sleep;
		checkGoalsCompleted();
	}

	public double getSleepDuration() {
		return sleepDuration;
	}

	public double calculateBMI() {
		weight = getWeight();
		
		//height is converted in meters.
		height = getHeight()/100;
		return weight / (height * height);
	}

	public void setWaterProgressLabel(String waterProgressLabel) {
		this.waterProgressTotalLabel = waterProgressLabel;
	}

	public String getWaterProgressLabel() {
		return waterProgressTotalLabel;
	
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
		this.weight = aWeight;
	}
	/**
	 * This method is used to compare the user's starting weight to their current weight.
	 * @return This getter method returns the starting weight of the user.
	 */
	public double getStartingWeight() {
		return weight;
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
	 * @return This getter method returns the how long the user slept for during one night.
	 */
	public double getSleepDuration() {
		return sleepDuration;
	}
	
	/**
	 * This method calculates the user's current body mass index (BMI).
	 * @return Returns the user's body mass index.
	 */
	public double calculateBMI() {
		weight = getCurrentWeight();
		height = getHeight();
		return ((weight / height) / height) * 10000;
	}
	
	/**
	 * This method calculates the user's current body fat percentage.
	 * @return Returns the user's body fat percentage.
	 */
	public double calculateBodyFatPercentage() {
		// Calculate body fat percentage based on gender and age
		if (user.getGender().equalsIgnoreCase("Female")) {
			bodyFat = (1.20 * calculateBMI()) + (0.23 * user.getAge()) - 5.4;	
		}
		if (user.getGender().equalsIgnoreCase("Male")){
			bodyFat = (1.20 * calculateBMI()) + (0.23 * user.getAge()) - 16.2; 	
		}
		return bodyFat;
	}
	
	/**
	 * This method will calculate the user's lean body mass (LBM).
	 * @return Returns the lean body mass of the user.
	 */
	public double calculateLBM() {
		return weight - calculateBodyFatPercentage();
	}

	public String getSleepProgressLabel() {
		return sleepProgressLabel;
	}

	public void setSleepProgressLabel(String sleepProgressLabel) {
		this.sleepProgressLabel = sleepProgressLabel;
	}

	double calculateCarbs() {

		return (getCarbs() *50 / 100);
	}

	double calculateFat() {
		return (getFat() * 30 / 100);
	}

	double calculateProtein() {
		return (getProtein() * 30 / 100);
	}

	public double getCarbs() {
		return carbs;
	}

	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double fiber) {
		this.protein = fiber;
	}
	
	/**
	 * This method gets called in three of the setter methods to check if the user has completed their daily goals.
	 * This method also calls a method in the Goals class which increments the number of goals completed.
	 */
	public void checkGoalsCompleted() {
		// If the user has reached their goal, it calls a method in the Goals class
		// and turns booleans true so that the user cannot reach the goal multiple time in one day
		if ((sleepDuration >= sleepGoals) && (!reachSleepGoal)) {
			completeGoal();
			reachSleepGoal = true;
		}
		if (waterIntakeAmount >= waterIntakeGoals && (!reachWaterIntakeGoal)) {
			completeGoal();
			reachWaterIntakeGoal = true;
		}
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
