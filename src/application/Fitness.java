package application;

public class Fitness extends Goals {
	
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
	
	public Fitness() {
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
	
	 public void setTotalCaloriesBurned(double caloriesBurned) {
		 try {
			checkUserInput(caloriesBurned);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.totalCaloriesBurned = caloriesBurned;
	 }
	 
	 public double getTotalCaloriesBurned() {
		 return totalCaloriesBurned;
	 }
	 
	 public void setProgress(double time) {
		 try {
			checkUserInput(time);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.progress = time;
	 }
	 
	 public double getProgress() {
		 return progress;
	 }

	 public void setMondayCaloriesBurnedInfo(double monday) {
		 try {
			checkUserInput(monday);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.mondayCaloriesBurnedInfo = monday;
	 }
	 
	 public void setTuesdayCaloriesBurnedInfo(double tuesday) {
		 try {
			checkUserInput(tuesday);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.tuesdayCaloriesBurnedInfo = tuesday;
	 }
	 
	 public void setWednesdayCaloriesBurnedInfo(double wednesday) {
		 try {
			checkUserInput(wednesday);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.wednesdayCaloriesBurnedInfo = wednesday;
	 }
	 
	 public void setThursdayCaloriesBurnedInfo(double thursday) {
		 try {
			checkUserInput(thursday);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.thursdayCaloriesBurnedInfo = thursday;
	 }
	 
	 public void setFridayCaloriesBurnedInfo(double friday) {
		 try {
			checkUserInput(friday);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.fridayCaloriesBurnedInfo = friday;
	 }
	 
	 public void setSaturdayCaloriesBurnedInfo(double saturday) {
		 try {
			checkUserInput(saturday);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.saturdayCaloriesBurnedInfo = saturday;
	 }
	 
	 public void setSundayCaloriesBurnedInfo(double sunday) {
		 try {
			checkUserInput(sunday);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		 try {
			checkUserInput(monday);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.mondayExerciseInfo = monday;
	 }
	 
	 public void setTuesdayExerciseInfo(double tuesday) {
		 try {
			checkUserInput(tuesday);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.tuesdayExerciseInfo = tuesday;
	 }
	 
	 public void setWednesdaydayExerciseInfo(double wednesday) {
		 try {
			checkUserInput(wednesday);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.wednesdayExerciseInfo = wednesday;
	 }
	 
	 public void setThursdayExerciseInfo(double thursday) {
		 try {
			checkUserInput(thursday);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.thursdayExerciseInfo = thursday;
	 }
	 
	 public void setFridayExerciseInfo(double friday) {
		 try {
			checkUserInput(friday);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.fridayExerciseInfo = friday;
	 }
	 
	 public void setSaturdayExerciseInfo(double saturday) {
		 try {
			checkUserInput(saturday);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.saturdayExerciseInfo = saturday;
	 }
	 
	 public void setSundayExerciseInfo(double sunday) {
		 try {
			checkUserInput(sunday);
		} catch (InvalidUserInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
