package application;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Recipes {
	Stage applicationStage;
	
	Font font = Font.font("System", FontWeight.BOLD, 18);
	Font ingredientsFont = Font.font("System", FontWeight.BOLD, 16);
	Font directionsFont = Font.font("System", FontWeight.BOLD, 16);
	
    @FXML
    void showBreakfastBurritoRecipe(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	
    	// Source: https://www.foodnetwork.com/recipes/ellie-krieger/breakfast-burrito-recipe-1953146
    	VBox burritoRecipeContainer = new VBox();
    	burritoRecipeContainer.setStyle("-fx-background-color: white");
    	HBox burritoNameContainer = new HBox();
    	Label burritoRecipeIngredients = new Label();
    	Label burritoNameLabel = new Label("Breakfast Burrito");
    	burritoNameContainer.getChildren().add(burritoNameLabel);
    	burritoNameContainer.setAlignment(Pos.CENTER);
    	burritoNameLabel.setFont(font);
    	Label burritoIngredients = new Label("Ingredients:");
    	burritoIngredients.setFont(ingredientsFont);
    	burritoRecipeIngredients.setText(
    			"2 teaspoons canola oil"
    			+ "\r\n"
    			+ "1/2 small red onion, diced (1 cup)"
    			+ "\r\n"
    			+ "1 red bell pepper, seeded and diced"
    			+ "\r\n"
    			+ "1 cup drained, rinsed canned black beans, preferably low-sodium"
    			+ "\r\n"
    			+ "1/4 teaspoon chili flakes"
    			+ "\r\n"
    			+ "Salt and freshly ground black pepper"
    			+ "\r\n"
    			+ "4 eggs and 4 egg whites"
    			+ "\r\n"
    			+ "1/3 cup (about 1 1/2 ounce) shredded pepper Jack cheese"
    			+ "\r\n"
    			+ "Nonstick cooking spray"
    			+ "\r\n"
    			+ "4 (10 inch) whole wheat tortillas (burrito size)"
    			+ "\r\n"
    			+ "1/4 cup reduced fat-free sour cream or 2 percent plain Greek yogurt"
    			+ "\r\n"
    			+ "1/4 cup salsa"
    			+ "\r\n"
    			+ "1 large tomato, (4 ounces) seeded and diced"
    			+ "\r\n"
    			+ "1 small avocado (4 ounces), cubed"
    			+ "\r\n"
    			+ "Hot sauce"
    			+ "\r\n");
    	Label burritoDirectionsLabel = new Label("Directions:");
    	burritoDirectionsLabel.setFont(directionsFont);
    	Label burritoRecipe = new Label();
    	burritoRecipe.setText(
    			"Heat the canola oil in a large nonstick skillet over a medium-high heat."
    			+ "\r\n"
    			+ "Cook the onions and peppers until onions are softened and peppers are slightly charred, about 8 minutes."
    			+ "\r\n"
    			+ "Add black beans and red pepper flakes and cook until warmed through, another 3 minutes."
    			+ "\r\n"
    			+ "Season with salt and pepper and transfer to a dish. Whisk together the eggs and egg whites then stir in the cheese."
    			+ "\r\n"
    			+ "Whisk together the eggs and egg whites then stir in the cheese."
    			+ "\r\n"
    			+ "Spray the skillet with cooking spray, and reheat the skillet over a medium heat."
    			+ "\r\n"
    			+ "Reduce heat to low and add eggs, scrambling until cooked through, about 3 minutes."
    			+ "\r\n"
    			+ "Spread each tortilla with 1 tablespoon each sour cream (or yogurt) and salsa, then layer with 1/4 of the black bean"
    			+ "\r\n"
    			+ "mixture, 1/4 of the scrambled eggs, some diced tomato and 1/4 of the avocado."
    			+ "\r\n"
    			+ "Season, to taste, with hot sauce. Roll up burrito-style and serve.");
    	HBox doneButtonContainer = new HBox();
    	Font buttonFont = Font.font("System", FontWeight.BOLD, 16);
    	Button doneButton = new Button("Done");
    	doneButton.setFont(buttonFont);
    	doneButton.setStyle("-fx-background-color: orange");
    	doneButton.setTextFill(Color.WHITE);
    	
    	doneButtonContainer.getChildren().add(doneButton);
    	doneButtonContainer.setAlignment(Pos.CENTER);
    	doneButtonContainer.setPadding(new Insets(200,0,0,0));
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	burritoRecipeContainer.getChildren().addAll(burritoNameContainer, burritoIngredients, burritoRecipeIngredients, 
    			burritoDirectionsLabel, burritoRecipe, doneButtonContainer);
    	
    	Scene breakfastBurritoScene = new Scene(burritoRecipeContainer, 609, 856);
   	   	applicationStage.setScene(breakfastBurritoScene);
    }

    @FXML
    void showApplePancakesRecipe(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    
    	// Source: https://www.foodnetwork.com/recipes/ellie-krieger/whole-wheat-apple-pancakes-recipe-2012287
    	VBox pancakesRecipeContainer = new VBox();
    	pancakesRecipeContainer.setStyle("-fx-background-color: white");
    	HBox pancakesNameContainer = new HBox();
    	Label pancakesNameLabel = new Label("Whole-Wheat Apple Pancakes");
    	pancakesNameContainer.getChildren().add(pancakesNameLabel);
    	pancakesNameContainer.setAlignment(Pos.CENTER);
    	pancakesNameLabel.setFont(font);
    	Label pancakesIngredients = new Label("Ingredients:");
    	pancakesIngredients.setFont(ingredientsFont);
    	Label pancakesRecipeIngredients = new Label();
    	pancakesRecipeIngredients.setText(
    			"1 cup low-fat buttermilk"
    			+ "\r\n"
    			+ "3/4 cup nonfat milk"
    			+ "\r\n"
    			+ "2 large eggs"
    			+ "\r\n"
    			+ "1 tablespoon honey"
    			+ "\r\n"
    			+ "6 tablespoons pure maple syrup"
    			+ "\r\n"
    			+ "1 medium apple, diced"
    			+ "\r\n"
    			+ "3/4 cup all-purpose flour"
    			+ "\r\n"
    			+ "3/4 cup whole-wheat four"
    			+ "\r\n"
    			+ "2 teaspoons baking powder"
    			+ "1/2 teaspoon baking soda"
    			+ "\r\n"
    			+ "1/4 teaspoon salt"
    			+ "\r\n"
    			);
    	Label pancakesDirectionsLabel = new Label("Directions:");
    	pancakesDirectionsLabel.setFont(directionsFont);
    	Label pancakesRecipe = new Label();
    	pancakesRecipe.setText(
    			"Preheat the oven to 250. Put the apple in a microwave-safe bowl and tightly cover with plastic wrap;"
    			+ "\r\n"
    			+ "microwave on high until softened, about 2 minutes."
    			+ "\r\n"
    			+ "In a large bowl, whisk the flours, baking powder, baking soda and salt."
    			+ "\r\n"
    			+ "In a small bowl, whisk the buttermilk, nonfat milk, eggs and honey, then slowly add the dry ingredients,"
    			+ "\r\n"
    			+ "stirring until just combined."
    			+ "\r\n"
    			+ "Heat a large nonstick griddle or skillet over medium heat."
    			+ "\r\n"
    			+ "Spoon 1/4 cup batter onto the griddle for each pancake and sprinkle each with apple,"
    			+ "\r\n"
    			+ "then drizzle a little more batter over the apple."
    			+ "\r\n"
    			+ "Cook until the tops are bubbly and the edges are dry, about 2 minutes."
    			+ "\r\n"
    			+ "Flip and cook until golden brown, 1 to 2 more minutes."
    			+ "\r\n"
    			+ "Keep the pancakes warm on a baking sheet in the oven while making the rest."
    			+ "\r\n"
    			+ "Place 2 pancakes on each plate. Drizzle with the syrup.");
    	HBox doneButtonContainer = new HBox();
    	Font buttonFont = Font.font("System", FontWeight.BOLD, 16);
    	Button doneButton = new Button("Done");
    	doneButton.setFont(buttonFont);
    	doneButton.setStyle("-fx-background-color: orange");
    	doneButton.setTextFill(Color.WHITE);
    	
    	doneButtonContainer.getChildren().add(doneButton);
    	doneButtonContainer.setPadding(new Insets(200,0,0,0));
    	doneButtonContainer.setAlignment(Pos.CENTER);
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	pancakesRecipeContainer.getChildren().addAll(pancakesNameLabel, pancakesIngredients, pancakesRecipeIngredients, 
    			pancakesDirectionsLabel, pancakesRecipe, doneButton);
    	
    	Scene applePancakesScene = new Scene(pancakesRecipeContainer, 609, 856);
   	   	applicationStage.setScene(applePancakesScene);
    
    }

    @FXML
    void showBreakfastCasseroleRecipe(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	
    	// Source: https://www.foodnetwork.com/recipes/food-network-kitchen/breakfast-casserole-3362652
    	VBox casseroleRecipeContainer = new VBox();
    	Label casseroleRecipe = new Label();
    	Label casseroleNameLabel = new Label("Breakfast Casserole");
    	casseroleRecipe.setText(
    			"Ingredients\r\n"
    			+ "\r\n"
    			+ "8 ounces spicy or sweet turkey sausage links, casings removed, meat crumbled\r\n"
    			+ "\r\n"
    			+ "2 scallions, sliced\r\n"
    			+ "\r\n"
    			+ "6 large eggs and 6 large egg whites\r\n"
    			+ "\r\n"
    			+ "1 3/4 cups 1-percent milk\r\n"
    			+ "\r\n"
    			+ "Kosher salt and freshly ground black pepper\r\n"
    			+ "\r\n"
    			+ "One 9-ounce package frozen chopped spinach, thawed and drained of excess liquid\r\n"
    			+ "\r\n"
    			+ "3/4 cup shredded Cheddar\r\n"
    			+ "\r\n"
    			+ "1/2 cup grated Parmesan\r\n"
    			+ "\r\n"
    			+ "1/2 whole wheat baguette, cut into 3/4-inch cubes (about 4 cups)\r\n"
    			+ "\r\n"
    			+ "Cooking spray\r\n"
    			+ "Recipe"
    			+ "\r\n"
    			+ "Heat a large nonstick skillet over medium heat"
    			+ "\r\n"
    			+ "Add the turkey and scallions and cook, stirring to break up any large chunks, until browned"
    			+ "\r\n"
    			+ "and cooked through, about 10 minutes. Remove from heat and let cool slightly."
    			+ "\r\n"
    			+ "Whisk the eggs, egg whites, milk and 1/2 teaspoon each salt and pepper in a large bowl until combined."
    			+ "\r\n"
    			+ "Add the cooked sausage, spinach, cheeses and bread and toss to distribute the ingredients evenly."
    			+ "\r\n"
    			+ "Spray a 3-quart casserole dish with cooking spray. Spread the egg mixture evenly in the dish."
    			+ "\r\n"
    			+ "Cover and refrigerate for at least 6 hours or preferably overnight."
    			+ "\r\n"
    			+ "Preheat the oven to 350 degrees F. Bake the casserole, uncovered, until set and lightly browned on top,"
    			+ "\r\n"
    			+ "about 30 minutes.");
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	casseroleRecipeContainer.getChildren().addAll(casseroleNameLabel, casseroleRecipe, doneButton);
    	
    	Scene breakfastCasseroleScene = new Scene(casseroleRecipeContainer, 609, 856);
   	   	applicationStage.setScene(breakfastCasseroleScene);
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
