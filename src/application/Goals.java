package application;

/**
 * The Goals class will keep track of and store the number of goals that the user has achieved throughout the day.
 * These goals can be entered by the user in the Goals window.
 * This controller will display how many goals the user has achieved in the main window.
 * 
 * @author Camila Hernandez, Mariam Masri & Enes Gisi
 *
 */
public class Goals {
	
	protected int goalsCompleted = 0;
	
	/**
	 * This method initializes the variable goalsCompleted to zero.
	 */
	public void resetGoalsCompleted() {
		goalsCompleted = 0;	
	}
	
	/**
	 * This method will increase the number of goals completed when the user has achieved their goal.
	 */
	public void completeGoal() {
		goalsCompleted++;
	}
	
	/**
	 * This getter method returns how many overall goals have been completed by the user.
	 * @return Returns how many goals the user has completed.
	 */
	public int getGoalsCompleted( ) {
		return goalsCompleted;
	}
}
