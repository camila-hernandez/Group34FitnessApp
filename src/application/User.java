package application;

/**
 * The User class will store and verify a set of characteristics that are unique to the user based
 * on the values entered by the user.
 * The User class will check and display errors entered by the user, such as invalid characters
 * or those out of acceptable range.
 * 
 * @author Camila Hernandez, Mariam Masri & Enes Gisi
 *
 */
public class User {
	User user;
	Health health = new Health();
	Fitness fitness = new Fitness();
	
	private String name = "";
	private int age = 0;
	private String gender = "";
	
	/**
	 * 
	 * @param str This parameter is the value of Age textfield
	 * @return return true if age entered is numeric, false if not
	 * 
	 * This method checks if the value entered for age is numeric
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
	 * aName is the name of the user that can be inputed in the User Profile window.
	 * Name is defaulted to an empty string.
	 * @param aName This string must consist of only alphabetical letters.
	 */
	public void setName(String aName) {
		name = aName;
	}
	
	/**
	 * This method is used to display the name of the user in the main window after it has been set.
	 * @return This getter method returns the name of the user.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * anAge is the age of the user that can be inputed in the User Profile window.
	 * Age is defaulted to an empty string.
	 * @param anAge This integer must consist of only whole numbers greater than 0.
	 */
	public void setAge(int anAge) {
		age = anAge;
	}
	
	/**
	 * This method is used to calculate the user's body fat percentage in the Nutrition window after it has been set.
	 * @return This getter method returns the age of the user.
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * aGender is the gender of the user that can be selected in the User Profile window.
	 * Gender is defaulted to an empty string.
	 * @param aGender This string is selected by the user.
	 */
	public void setGender(String aGender) {
		gender = aGender;
	}
	
	/**
	 * This method is also used to calculate the user's body fat percentage in the Nutrition window 
	 * after it has been set.
	 * @return This getter method returns the gender of the user.
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * This method will check if the name that the user inputed into the TextField is valid.
	 * @param s This is the string that the user enters into the TextField as their name.
	 * @throws InvalidUserInputException This is the custom exception that is thrown if the user' input is invalid.
	 * @throws EmptyInputException 
	 */
	public void checkName(String nameString) throws InvalidUserInputException, EmptyInputException {
		// Check if user input is empty
		if (nameString.isEmpty()) {
			throw new EmptyInputException("Please fill out all required TextFields.");
		}
		// Check if the string is all alphabetical letters
		else {
			if (!nameString.matches("^[a-zA-Z]*$")) {
				throw new InvalidUserInputException("Invalid Character");
			}
		}
	}
	
	/**
	 * This method will check if the age that the user inputed into the TextField is a valid age.
	 * @param valueEntered This is the value that the user entered into the TextField as a string.
	 * @throws InvalidUserInputException This is the custom exception that is thrown if the user's input is invalid.
	 * @throws EmptyInputException 
	 */
	public void checkAge(String ageString) throws InvalidUserInputException, EmptyInputException {	
		// Check if user input is empty
		if (ageString.isEmpty()) {
			throw new EmptyInputException("Please fill out all required TextFields.");
		}
		else {
			for (char c : ageString.toCharArray()) {
				// Check if the character is a digit
				if (!Character.isDigit(c)) {
					throw new InvalidUserInputException("Make sure to enter a valid number.");
				}
			}
		}
	}
}
