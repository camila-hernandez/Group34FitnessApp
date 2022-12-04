package application;

public class User {
	
	private String name;
	private double age;
	private String gender;

	User user;
	Health health = new Health();
	Fitness fitness = new Fitness();
	
	public String test = "Test";
	
	public void setName(String aName) {
		name = aName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(double anAge) {
		age = anAge;
	}
	
	public double getAge() {
		return age;
	}
	
	public void setGender(String aGender) {
		gender = aGender;
	}
	
	public String getGender() {
		return gender;
	}
	
	// Check user input for name
	public void checkName(String s) throws InvalidUserInputException {
		if (!s.matches("^[a-zA-Z]*$")) {
				throw new InvalidUserInputException("Invalid Character");
		}
	}
	
	public void checkAge(String valueEntered) throws InvalidUserInputException {	
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
	}
}
