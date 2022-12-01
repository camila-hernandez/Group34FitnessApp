package application;

public class Goals {
	
	private double stepGoals;
	private double sleepGoals;
	private double waterIntakeGoals;
	private double weightGoals;
	private double caloriesBurnedGoals;
	private double exerciseGoals;  

	public Goals() {
		// TODO Auto-generated constructor stub
	}
	
	public void checkUserInput(double value) throws InvalidUserInputException {
		try {
			boolean decimalEncountered = false;
			for (char c : Double.toString(value).toCharArray()) {
				// Check if the character is a '.'
				// If the character is a '.' and the for loop has not encountered a '.' yet, 
				// then it will indicate this '.' to be a decimal.
				if (c == '.' && !decimalEncountered) {
					decimalEncountered = true;
				}
				// Check if the character is a digit if it's not a decimal
				else if (!Character.isDigit(c)) {
					throw new InvalidUserInputException("Make sure to enter a number as a grade.");
				}
			}
		
			if (value < 0) {
				throw new InvalidUserInputException("Grade should be between 0 and the maximum value.");
			}	
		} catch (Exception e) {
		}
	}
	
	public void setStepsGoals(double steps) {
    	try {
			checkUserInput(steps);
			this.stepGoals = steps;
		} catch (InvalidUserInputException e) {
		}
    }
    
    public void setSleepGoals(double sleep) {
    	try {
			checkUserInput(sleep);
			this.sleepGoals = sleep;
		} catch (InvalidUserInputException e) {
		}
    }
    
    public void setWaterIntakeGoals(double water) {
    	try {
			checkUserInput(water);
			this.waterIntakeGoals = water;
		} catch (InvalidUserInputException e) {
		}
    }
    
    public void setWeightGoals(double weight) {
    	try {
			checkUserInput(weight);
			this.weightGoals = weight;
		} catch (InvalidUserInputException e) {
		}
    }
    
    public void setCaloriesGoals(double calories) {
    	try {
			checkUserInput(calories);
			this.caloriesBurnedGoals = calories;
		} catch (InvalidUserInputException e) {
		}
    	this.caloriesBurnedGoals = calories;
    }
    
    public void setExerciseGoals(double exercise) {
    	try {
			checkUserInput(exercise);
			this.exerciseGoals = exercise;
		} catch (InvalidUserInputException e) {
		}
    }
    
    public double getStepsGoals() {
		return stepGoals;
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
	
	public double getCaloriesGoals() {
		return caloriesBurnedGoals;
	}
	
	public double getExerciseGoals() {
		return exerciseGoals;
	}
}
