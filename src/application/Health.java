package application;

public class Health extends Goals {

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
}
