package application;

public class Calculator {
	double weight;
	double height;
	double bodyFat;
	
	double calculateBMI() {
		return weight / (height * height);
	}
	
	double calculateBodyFatPercentage() {
		return bodyFat;
		// female
		//return 163.205 * log10(waist + hip - neck) - 97.684 * log10(height) - 78.387;
		// male
		//return 86.010 * log10(abdomen - neck) - 70.041 * log10(height) + 36.76;
	}
	
	double calculateLBM() {
		return weight - calculateBodyFatPercentage();
	}
	
	//double calculateCarbs() {
		//return (amount in serving size (in g) / 300) * 100;
	//}
	
	//double calculateFat() {
		//return (amount in serving size (in g) / 65) * 100;
	//}
	
	//double calculateFiber() {
		//return (amount in serving size (in g) / 25) * 100;
	//}
}
