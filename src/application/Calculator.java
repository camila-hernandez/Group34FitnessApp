package application;

public class Calculator {
	float weight;
	float height;
	float bodyFat;
	
	float calculateBMI() {
		return weight / (height * height);
	}
	
	float calculateBodyFatPercentage() {
		return bodyFat;
		// female
		//return 163.205 * log10(waist + hip - neck) - 97.684 * log10(height) - 78.387;
		// male
		//return 86.010 * log10(abdomen - neck) - 70.041 * log10(height) + 36.76;
	}
	
	float calculateLBM() {
		return weight - calculateBodyFatPercentage();
	}
	
	//float calculateCarbs() {
		//return (amount in serving size (in g) / 300) * 100;
	//}
	
	//float calculateFat() {
		//return (amount in serving size (in g) / 65) * 100;
	//}
	
	//float calculateFiber() {
		//return (amount in serving size (in g) / 25) * 100;
	//}
}
