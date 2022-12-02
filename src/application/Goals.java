package application;

public class Goals {
	
	protected int goalsCompleted = 0;
	
	public void resetGoalsCompleted() {
		goalsCompleted = 0;	
	}
	
	public void completeGoal() {
		goalsCompleted++;
	}
	
	public int getGoalsCompleted( ) {
		return goalsCompleted;
	}
}
