package application;

public class Steps extends User {
	private int stepsCount = 0;
	

	public Steps(String steps) {
		super();
		this.setStepsCount(steps);
	}


	public double getStepsCount() {
		return stepsCount;
	}
	
	public static boolean isNumeric(String str) { 
		  try {  
			Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}

	public void setStepsCount(String stepsCount) {
		if (isNumeric(stepsCount)) {
			this.stepsCount = Integer.parseInt(stepsCount);
		}

	}

}
