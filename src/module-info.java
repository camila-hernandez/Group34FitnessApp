module Group34FitnessApp {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.base;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
}
