package application;

public class User {
	
	private String name = "John Doe";

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) throws InvalidNameException {
		boolean validName = true;
		for (char c : newName.toCharArray()) {
    		if (!Character.isAlphabetic(c) && c!=32) {
    			validName = false;
    			throw new InvalidNameException("A name must be alphabetic");
    		}
    	}	
    	if (validName) {
    		name = String.valueOf(newName);
    	}
		else throw new InvalidNameException("A name must be alphabetic");
	}
}
