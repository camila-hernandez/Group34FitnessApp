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
    	casseroleRecipeContainer.setStyle("-fx-background-color: white");
    	HBox casseroleNameContainer = new HBox();
    	Label casseroleRecipeIngredients = new Label();
    	Label casseroleNameLabel = new Label("Breakfast Casserole");
    	casseroleNameContainer.getChildren().add(casseroleNameLabel);
    	casseroleNameContainer.setAlignment(Pos.CENTER);
    	casseroleNameLabel.setFont(font);
    	Label casseroleIngredients = new Label("Ingredients:");
    	casseroleIngredients.setFont(ingredientsFont);
    	casseroleRecipeIngredients.setText(
    			"8 ounces spicy or sweet turkey sausage links, casings removed, meat crumbled"
    			+ "\r\n"
    			+ "2 scallions, sliced"
    			+ "\r\n"
    			+ "6 large eggs and 6 large egg whites"
    			+ "\r\n"
    			+ "1 3/4 cups 1-percent milk"
    			+ "\r\n"
    			+ "Kosher salt and freshly ground black pepper"
    			+ "\r\n"
    			+ "One 9-ounce package frozen chopped spinach, thawed and drained of excess liquid"
    			+ "\r\n"
    			+ "3/4 cup shredded Cheddar"
    			+ "\r\n"
    			+ "1/2 cup grated Parmesan"
    			+ "\r\n"
    			+ "1/2 whole wheat baguette, cut into 3/4-inch cubes (about 4 cups)"
    			+ "\r\n"
    			+ "Cooking spray"
    			+ "\r\n");
    	
    	Label casseroleDirectionsLabel = new Label("Directions:");
    	casseroleDirectionsLabel.setFont(directionsFont);
    	Label casseroleRecipe = new Label();
    	casseroleRecipe.setText(
    			"Heat a large nonstick skillet over medium heat."
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
    	casseroleRecipeContainer.getChildren().addAll(casseroleNameLabel, casseroleIngredients, casseroleRecipeIngredients, 
    			casseroleDirectionsLabel, casseroleRecipe, doneButton);
    	
    	Scene breakfastCasseroleScene = new Scene(casseroleRecipeContainer, 609, 856);
   	   	applicationStage.setScene(breakfastCasseroleScene);
    }

    @FXML
    void showMisoSoupRecipe(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	
    	// Source: https://www.foodnetwork.com/recipes/food-network-kitchen/miso-soup-recipe-2102742
    	VBox soupRecipeContainer = new VBox();
    	soupRecipeContainer.setStyle("-fx-background-color: white");
    	HBox soupNameContainer = new HBox();
    	Label soupRecipeIngredients = new Label();
    	Label soupNameLabel = new Label("Miso Soup");
    	soupNameContainer.getChildren().add(soupNameLabel);
    	soupNameContainer.setAlignment(Pos.CENTER);
    	soupNameLabel.setFont(font);
    	Label soupIngredients = new Label("Ingredients:");
    	soupIngredients.setFont(ingredientsFont);
    	soupRecipeIngredients.setText(
    			"4 to 5 cups dashi, recipe follows"
    			+ "\r\n"
    			+ "2 tablespoons brown miso paste, plus more to taste"
    			+ "\r\n"
    			+ "2 tablespoons white miso paste, plus more to taste"
    			+ "\r\n"
    			+ "6 ounces firm tofu, cut into 1/2-inch cubes"
    			+ "\r\n"
    			+ "2 scallions, white and green, thinly sliced on the diagonal"
    			+ "\r\n"
    			+ "2 tablespoons aji mirin (sweetened rice wine), optional\r\n"
    			+ "\r\n"
    			+ "DASHI:"
    			+ "\r\n"
    			+ "6 cups cold water"
    			+ "\r\n"
    			+ "One 12-inch long piece of kombu, wiped with a damp cloth"
    			+ "\r\n"
    			+ "One .88-ounce/25 grams package shaved dried bonito flakes"
    			+ "\r\n");
    	Label soupDirectionsLabel = new Label("Directions:");
    	soupDirectionsLabel.setFont(directionsFont);
    	Label soupRecipe = new Label();
    	soupRecipe.setText(
    			"In a saucepan heat the dashi and whisk in the miso pastes."
    			+ "\r\n"
    			+ "Bring to a simmer and add the tofu, scallions, and mirin, if using."
    			+ "\r\n"
    			+ "Remove from the heat and serve immediately.\r\n"
    			+ "\r\n"
    			+ "DASHI:"
    			+ "\r\n"
    			+ "Yield: About 4 to 5 cups"
    			+ "\r\n"
    			+ "In a saucepan, combine the water and kombu. Bring to a simmer, uncovered, over medium heat."
    			+ "\r\n"
    			+ "Remove the kombu and discard. Bring the liquid to a boil, add the bonito flakes and"
    			+ "\r\n"
    			+ "immediately remove the pan from the heat. Allow the dashi to sit undisturbed for 2 minutes."
    			+ "\r\n"
    			+ "Strain through a fine mesh strainer into a medium bowl. Discard the bonito flakes."
    			+ "\r\n"
    			+ "Use immediately or store, covered, in the refrigerator for up to 3 days.");
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
    	soupRecipeContainer.getChildren().addAll(soupNameContainer, soupIngredients, soupRecipeIngredients, 
    			soupDirectionsLabel, soupRecipe, doneButtonContainer);
    	
    	Scene misoSoupScene = new Scene(soupRecipeContainer, 609, 856);
   	   	applicationStage.setScene(misoSoupScene);
    }

    @FXML
    void showSandwichRecipe(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	
    	// Source: https://www.foodnetwork.com/recipes/food-network-kitchen/miso-soup-recipe-2102742
    	VBox sandwichRecipeContainer = new VBox();
    	sandwichRecipeContainer.setStyle("-fx-background-color: white");
    	HBox sandwichNameContainer = new HBox();
    	Label sandwichRecipeIngredients = new Label();
    	Label sandwichNameLabel = new Label("Veggie Club Sandwich");
    	sandwichNameContainer.getChildren().add(sandwichNameLabel);
    	sandwichNameContainer.setAlignment(Pos.CENTER);
    	sandwichNameLabel.setFont(font);
    	Label sandwichIngredients = new Label("Ingredients:");
    	sandwichIngredients.setFont(ingredientsFont);
    	sandwichRecipeIngredients.setText(
    			"1/2 Hass avocado, pitted"
    			+ "\r\n"
    			+ "2 tablespoons white balsamic or white wine vinegar"
    			+ "\r\n"
    			+ "1 tablespoon finely chopped fresh oregano"
    			+ "\r\n"
    			+ "1 tablespoon fat-free plain Greek yogurt"
    			+ "\r\n"
    			+ "2 large cloves garlic, minced"
    			+ "\r\n"
    			+ "12 slices whole wheat or sprouted grain bread, lightly toasted, if desired"
    			+ "\r\n"
    			+ "1 cup packed baby arugula or mizuna"
    			+ "\r\n"
    			+ "2 1/2 ounces thinly sliced ready-to-eat smoked tofu or smoked mozzarella cheese"
    			+ "\r\n"
    			+ "1/2 cup thinly sliced red onion"
    			+ "\r\n"
    			+ "1/3 cup packed sun-dried tomatoes, fully rehydrated"
    			+ "\r\n"
    			+ "1/2 cup thinly sliced unpeeled English cucumber"
    			+ "\r\n"
    			+ "1/3 cup thinly sliced pepperoncini (about 1 ounce)"
    			+ "\r\n"
    			+ "2 1/2 ounces thinly sliced provolone"
    			+ "\r\n"
    			+ "1 large freshly roasted orange or red bell pepper, cut into 12 pieces, or 1/3 cup store-bought roasted peppers"
    			+ "\r\n");
    	Label soupDirectionsLabel = new Label("Directions:");
    	soupDirectionsLabel.setFont(directionsFont);
    	Label soupRecipe = new Label();
    	soupRecipe.setText(
    			"Squeeze or scoop the avocado from the skin into a small bowl."
    			+ "\r\n"
    			+ "Mash with a fork and stir in the vinegar, oregano, yogurt and garlic to make a smooth spread."
    			+ "\r\n"
    			+ "Thinly spread the avocado mixture onto one side of each slice of bread."
    			+ "\r\n"
    			+ "Top 4 of the slices of bread with the arugula, tofu, onions and sun-dried tomatoes."
    			+ "\r\n"
    			+ "Place 4 of the remaining slices on top, avocado-side down."
    			+ "\r\n"
    			+ "Top with the cucumbers, pepperoncini, provolone and roasted peppers."
    			+ "\r\n"
    			+ "Place the remaining bread slices on top, avocado-side down."
    			+ "\r\n"
    			+ "Insert bamboo picks into each sandwich, cut in half on the diagonal with a bread knife and serve.");
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
    	sandwichRecipeContainer.getChildren().addAll(sandwichNameContainer, sandwichIngredients, sandwichRecipeIngredients, 
    			soupDirectionsLabel, soupRecipe, doneButtonContainer);
    	
    	Scene misoSoupScene = new Scene(sandwichRecipeContainer, 609, 856);
   	   	applicationStage.setScene(misoSoupScene);
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
