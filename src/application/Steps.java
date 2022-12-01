package application;

public class Steps {
	private int stepsCount = 0;
	

	public Steps(String steps) {
		this.setStepsCount(steps);
	}


	public double getStepsCount() {
		return stepsCount;
	}
	
	public static boolean isNumeric(String str) throws NumberFormatException{ 
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
