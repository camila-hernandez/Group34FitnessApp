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
}
