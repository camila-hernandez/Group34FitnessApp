package application;

public class Health extends Goals {
	
	private double sleepGoals;
	private double waterIntakeGoals;
	private double weightGoals;
	private double weight;
	private double height;
	private double bodyFat;
	private double waterIntakeAmount;
	private String waterProgressTotalLabel;
	private double sleepDuration;
	private String sleepProgressLabel;
	
	boolean reachSleepGoal = false;
	boolean reachWaterIntakeGoal = false;
	boolean reachWeightGoal = false;

	public Health() {
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
					throw new InvalidUserInputException("Make sure to enter a valid number.");
				}
			}
		
			if (value < 0) {
				throw new InvalidUserInputException("Number should be greater than 0.");
			}	
		} catch (Exception e) {
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
		try {
			checkUserInput(aHeight);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.height = aHeight;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setBodyFat(double fat) {
		try {
			checkUserInput(fat);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bodyFat = fat;
	}
	
	public double getBodyFat() {
		return bodyFat;
	}
	
	public void setWaterIntakeAmount(double water) {
		this.waterIntakeAmount = water;
		if (waterIntakeAmount >= waterIntakeGoals) {
			completeGoal();
		}
	}
	
	public double getWaterIntakeAmount() {
		return waterIntakeAmount;
	}
	
	public void setSleepDuration(double sleep) {
		this.sleepDuration = sleep;
		if ((sleepDuration >= sleepGoals) && (!reachSleepGoal)) {
			completeGoal();
		}
	}
	
	public double getSleepDuration() {
		return sleepDuration;
	}
	
	public double calculateBMI() {
		return weight / (height * height);
	}
	
	public double calculateBodyFatPercentage() {
		return bodyFat;
		// female
		//return 163.205 * log10(waist + hip - neck) - 97.684 * log10(height) - 78.387;
		// male
		//return 86.010 * log10(abdomen - neck) - 70.041 * log10(height) + 36.76;
	}
	
	public double calculateLBM() {
		return weight - calculateBodyFatPercentage();
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
	
	//double calculateCarbs() {
		//return (amount in serving size (in g) / 300) * 100;
	//}
	
	//double calculateFat() {
		//return (amount in serving size (in g) / 65) * 100;
	//}
	
	//double calculateFiber() {
		//return (amount in serving size (in g) / 25) * 100;
	//}
	

}
