package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Recipes {
	Stage applicationStage;

    @FXML
    void showBreakfastBurritoRecipe(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	
    	// Source: https://www.foodnetwork.com/recipes/ellie-krieger/breakfast-burrito-recipe-1953146
    	VBox burritoRecipeContainer = new VBox();
    	Label burritoRecipe = new Label();
    	Label burritoNameLabel = new Label("Breakfast Burrito");
    	burritoRecipe.setText(
    			"Ingredients\r\n"
    			+ "2 teaspoons canola oil\r\n"
    			+ "\r\n"
    			+ "1/2 small red onion, diced (1 cup)\r\n"
    			+ "\r\n"
    			+ "1 red bell pepper, seeded and diced\r\n"
    			+ "\r\n"
    			+ "1 cup drained, rinsed canned black beans, preferably low-sodium\r\n"
    			+ "\r\n"
    			+ "1/4 teaspoon chili flakes\r\n"
    			+ "\r\n"
    			+ "Salt and freshly ground black pepper\r\n"
    			+ "\r\n"
    			+ "4 eggs and 4 egg whites\r\n"
    			+ "\r\n"
    			+ "1/3 cup (about 1 1/2 ounce) shredded pepper Jack cheese\r\n"
    			+ "\r\n"
    			+ "Nonstick cooking spray\r\n"
    			+ "\r\n"
    			+ "4 (10 inch) whole wheat tortillas (burrito size)\r\n"
    			+ "\r\n"
    			+ "1/4 cup reduced fat-free sour cream or 2 percent plain Greek yogurt\r\n"
    			+ "\r\n"
    			+ "1/4 cup salsa\r\n"
    			+ "\r\n"
    			+ "1 large tomato, (4 ounces) seeded and diced\r\n"
    			+ "\r\n"
    			+ "1 small avocado (4 ounces), cubed\r\n"
    			+ "\r\n"
    			+ "Hot sauce"
    			+ "\r\n"
    			+ "Recipe"
    			+ "\r\n"
    			+ "Heat the canola oil in a large nonstick skillet over a medium-high heat."
    			+ "\r\n"
    			+ "Cook the onions and peppers until onions are softened and peppers are slightly charred, about 8 minutes."
    			+ "\r\n"
    			+ "Add black beans and red pepper flakes and cook until warmed through, another 3 minutes."
    			+ "\r\n"
    			+ "Season with salt and pepper and transfer to a dish."
    			+ "\r\n"
    			+ "Whisk together the eggs and egg whites then stir in the cheese."
    			+ "\r\n"
    			+ "Spray the skillet with cooking spray, and reheat the skillet over a medium heat."
    			+ "\r\n"
    			+ "Reduce heat to low and add eggs, scrambling until cooked through, about 3 minutes."
    			+ "\r\n"
    			+ "Spread each tortilla with 1 tablespoon each sour cream (or yogurt) and salsa,"
    			+ "\r\n"
    			+ "then layer with 1/4 of the black bean mixture, 1/4 of the scrambled eggs, some diced tomato"
    			+ "\r\n"
    			+ "and 1/4 of the avocado. Season, to taste, with hot sauce. Roll up burrito-style and serve.");
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	burritoRecipeContainer.getChildren().addAll(burritoNameLabel, burritoRecipe, doneButton);
    	
    	Scene breakfastBurritoScene = new Scene(burritoRecipeContainer, 609, 856);
   	   	applicationStage.setScene(breakfastBurritoScene);
    }

    @FXML
    void showApplePancakesRecipe(ActionEvent event) {

    }

    @FXML
    void showBreakfastCasseroleRecipe(ActionEvent event) {

    }

    @FXML
    void showMisoSoupRecipe(ActionEvent event) {
    	
    }

    @FXML
    void showSandwichRecipe(ActionEvent event) {

    }

    @FXML
    void showTacosAndSaladRecipe(ActionEvent event) {

    }

    @FXML
    void showRoastedSalmonRecipe(ActionEvent event) {

    }

    @FXML
    void showBeefStirFryRecipe(ActionEvent event) {

    }

    @FXML
    void showGrilledChickenRecipe(ActionEvent event) {

    }

    @FXML
    void returnToMainPage(ActionEvent event) {

    }

}
