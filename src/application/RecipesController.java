package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * The RecipesController class will display healthy recipes the user can recreate to progress through
 * their health and fitness journey.
 * 
 * @author Camila Hernandez, Mariam Masri & Enes Gisi
 *
 */
public class RecipesController {
	Stage applicationStage;
	
	User user;
	
	/**
	 * This method will allow for the same User object to be passed between different controllers.
	 * The user can access the same properties in each scene.
	 * @param user This is the User object.
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	// Creating fonts that are used in all recipe labels
	Font font = Font.font("System", FontWeight.BOLD, 18);
	Font ingredientsFont = Font.font("System", FontWeight.BOLD, 16);
	Font directionsFont = Font.font("System", FontWeight.BOLD, 16);
	
	/**
     * This method will open a new scene with a list of ingredients and the instructions to how to make a breakfast burrito.
     * @param breakfastBurritoRecipeEvent This ActionEvent will change the scene to show the user the recipe.
     */
    @FXML
    void showBreakfastBurritoRecipe(ActionEvent breakfastBurritoRecipeEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	// Source: https://www.foodnetwork.com/recipes/ellie-krieger/breakfast-burrito-recipe-1953146
    	
    	// Creating container and labels
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
    	
    	// Writing ingredients
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
    	
    	// Creating label for instructions
    	Label burritoDirectionsLabel = new Label("Directions:");
    	burritoDirectionsLabel.setFont(directionsFont);
    	
    	Label burritoRecipe = new Label();
    	// Writing recipe
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
    	
    	// Creating container for button
    	HBox doneButtonContainer = new HBox();
    	Font buttonFont = Font.font("System", FontWeight.BOLD, 16);
    	Button doneButton = new Button("Done");
    	doneButton.setFont(buttonFont);
    	doneButton.setStyle("-fx-background-color: orange");
    	doneButton.setTextFill(Color.WHITE);
    	
    	// Added button to container
    	doneButtonContainer.getChildren().add(doneButton);
    	doneButtonContainer.setAlignment(Pos.CENTER);
    	doneButtonContainer.setPadding(new Insets(200,0,0,0));
    	
    	// Set action for button
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	burritoRecipeContainer.getChildren().addAll(burritoNameContainer, burritoIngredients, burritoRecipeIngredients, 
    			burritoDirectionsLabel, burritoRecipe, doneButtonContainer);
    	
    	// Creating and setting a new scene
    	Scene breakfastBurritoScene = new Scene(burritoRecipeContainer, 609, 856);
   	   	applicationStage.setScene(breakfastBurritoScene);
    }

    /**
     * This method will open a new scene with a list of ingredients and the instructions to how to make apple pancakes.
     * @param applePancakesRecipeEvent This ActionEvent will change the scene to show the user the recipe.
     */
    @FXML
    void showApplePancakesRecipe(ActionEvent applePancakesRecipeEvent) {
    	Scene mainScene = applicationStage.getScene();
    
    	// Source: https://www.foodnetwork.com/recipes/ellie-krieger/whole-wheat-apple-pancakes-recipe-2012287
    	
    	// Creating container and labels
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
    	
    	// Creating ingredients
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
    	// Creating labels for instructions
    	Label pancakesDirectionsLabel = new Label("Directions:");
    	pancakesDirectionsLabel.setFont(directionsFont);
    	
    	Label pancakesRecipe = new Label();
    	// Writing recipe
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
    	
    	// Creating a button container
    	HBox doneButtonContainer = new HBox();
    	Font buttonFont = Font.font("System", FontWeight.BOLD, 16);
    	Button doneButton = new Button("Done");
    	doneButton.setFont(buttonFont);
    	doneButton.setStyle("-fx-background-color: orange");
    	doneButton.setTextFill(Color.WHITE);
    	
    	// Added button to container
    	doneButtonContainer.getChildren().add(doneButton);
    	doneButtonContainer.setPadding(new Insets(200,0,0,0));
    	doneButtonContainer.setAlignment(Pos.CENTER);
    	
    	// Set action for button
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	pancakesRecipeContainer.getChildren().addAll(pancakesNameLabel, pancakesIngredients, pancakesRecipeIngredients, 
    			pancakesDirectionsLabel, pancakesRecipe, doneButton);
    	
    	// Craeting and setting a new scene
    	Scene applePancakesScene = new Scene(pancakesRecipeContainer, 609, 856);
   	   	applicationStage.setScene(applePancakesScene);
    
    }

    /**
     * This method will open a new scene with a list of ingredients and the instructions to how to make breakfast casserole.
     * @param breakfastCasseroleRecipeEvent This ActionEvent will change the scene to show the user the recipe.
     */
    @FXML
    void showBreakfastCasseroleRecipe(ActionEvent breakfastCasseroleRecipeEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	// Source: https://www.foodnetwork.com/recipes/food-network-kitchen/breakfast-casserole-3362652
    	
    	// Creating container and labels
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
    	
    	// Writing ingredients
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
    	
    	// Creating labels for instructions
    	Label casseroleDirectionsLabel = new Label("Directions:");
    	casseroleDirectionsLabel.setFont(directionsFont);
    	
    	Label casseroleRecipe = new Label();
    	// Writing recipe
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
    	
    	// Creating a button container
    	HBox doneButtonContainer = new HBox();
    	Font buttonFont = Font.font("System", FontWeight.BOLD, 16);
    	Button doneButton = new Button("Done");
    	doneButton.setFont(buttonFont);
    	doneButton.setStyle("-fx-background-color: orange");
    	doneButton.setTextFill(Color.WHITE);
    	
    	// Added button to container
    	doneButtonContainer.getChildren().add(doneButton);
    	doneButtonContainer.setPadding(new Insets(200,0,0,0));
    	doneButtonContainer.setAlignment(Pos.CENTER);
    	
    	// Set action for button
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	casseroleRecipeContainer.getChildren().addAll(casseroleNameLabel, casseroleIngredients, casseroleRecipeIngredients, 
    			casseroleDirectionsLabel, casseroleRecipe, doneButton);
    	
    	// Creating and setting a new scene
    	Scene breakfastCasseroleScene = new Scene(casseroleRecipeContainer, 609, 856);
   	   	applicationStage.setScene(breakfastCasseroleScene);
    }

    /**
     * This method will open a new scene with a list of ingredients and the instructions to how to make miso soup.
     * @param misoSoupRecipeEvent This ActionEvent will change the scene to show the user the recipe.
     */
    @FXML
    void showMisoSoupRecipe(ActionEvent misoSoupRecipeEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	// Source: https://www.foodnetwork.com/recipes/food-network-kitchen/miso-soup-recipe-2102742
    	
    	// Creating container and labels
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
    	// Writing ingredients
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
    	
    	// Creating labels for instructions
    	Label soupDirectionsLabel = new Label("Directions:");
    	soupDirectionsLabel.setFont(directionsFont);
    	
    	Label soupRecipe = new Label();
    	// Writing recipe
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
    	
    	// Creating a button container
    	HBox doneButtonContainer = new HBox();
    	Font buttonFont = Font.font("System", FontWeight.BOLD, 16);
    	Button doneButton = new Button("Done");
    	doneButton.setFont(buttonFont);
    	doneButton.setStyle("-fx-background-color: orange");
    	doneButton.setTextFill(Color.WHITE);
    	
    	// Added a button to container
    	doneButtonContainer.getChildren().add(doneButton);
    	doneButtonContainer.setAlignment(Pos.CENTER);
    	doneButtonContainer.setPadding(new Insets(200,0,0,0));
    	
    	// Set action for button
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	soupRecipeContainer.getChildren().addAll(soupNameContainer, soupIngredients, soupRecipeIngredients, 
    			soupDirectionsLabel, soupRecipe, doneButtonContainer);
    	
    	// Creating and setting a new scene
    	Scene misoSoupScene = new Scene(soupRecipeContainer, 609, 856);
   	   	applicationStage.setScene(misoSoupScene);
    }

    /**
     * This method will open a new scene with a list of ingredients and the instructions to how to make a 
     * veggie club sandwich.
     * @param sandwichRecipeEvent This ActionEvent will change the scene to show the user the recipe.
     */
    @FXML
    void showSandwichRecipe(ActionEvent sandwichRecipeEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	// Source: https://www.foodnetwork.com/recipes/food-network-kitchen/veggie-lovers-club-sandwich-recipe-2120987
    	
    	// Creating a container and labels
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
    	
    	// Writing the ingredients
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
    	
    	// Creating a label for instructions
    	Label soupDirectionsLabel = new Label("Directions:");
    	soupDirectionsLabel.setFont(directionsFont);
    	
    	Label soupRecipe = new Label();
    	// Writing a recipe
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
    	
    	// Creating a button container
    	HBox doneButtonContainer = new HBox();
    	Font buttonFont = Font.font("System", FontWeight.BOLD, 16);
    	Button doneButton = new Button("Done");
    	doneButton.setFont(buttonFont);
    	doneButton.setStyle("-fx-background-color: orange");
    	doneButton.setTextFill(Color.WHITE);
    	
    	// Added a button to the container
    	doneButtonContainer.getChildren().add(doneButton);
    	doneButtonContainer.setAlignment(Pos.CENTER);
    	doneButtonContainer.setPadding(new Insets(200,0,0,0));
    	
    	// Set action for button
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	sandwichRecipeContainer.getChildren().addAll(sandwichNameContainer, sandwichIngredients, sandwichRecipeIngredients, 
    			soupDirectionsLabel, soupRecipe, doneButtonContainer);
    	
    	// Creating and setting a new scene
    	Scene sandwichScene = new Scene(sandwichRecipeContainer, 609, 856);
   	   	applicationStage.setScene(sandwichScene);
    }

    /**
     * This method will open a new scene with a list of ingredients and the instructions to how to make tacos and salad.
     * @param tacosAndSaladRecipeEvent This ActionEvent will change the scene to show the user the recipe.
     */
    @FXML
    void showTacosAndSaladRecipe(ActionEvent tacosAndSaladRecipeEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	// Source: https://www.foodnetwork.com/recipes/food-network-kitchen/chicken-tacos-with-avocado-salad-3364227
    	
    	// Creating container and labels
    	VBox tacosRecipeContainer = new VBox();
    	tacosRecipeContainer.setStyle("-fx-background-color: white");
    	HBox tacosNameContainer = new HBox();
    	Label tacosRecipeIngredients = new Label();
    	Label tacosNameLabel = new Label("Chicken Tacos with Avocado Salad");
    	tacosNameContainer.getChildren().add(tacosNameLabel);
    	tacosNameContainer.setAlignment(Pos.CENTER);
    	tacosNameLabel.setFont(font);
    	Label tacosIngredients = new Label("Ingredients:");
    	tacosIngredients.setFont(ingredientsFont);
    	
    	// Writing ingredients
    	tacosRecipeIngredients.setText(
    			"1 1/4 pounds skinless, boneless chicken thighs (about 6)"
    			+ "\r\n"
    			+ "1 cup jarred salsa"
    			+ "\r\n"
    			+ "Juice of 2 limes, plus wedges for serving"
    			+ "\r\n"
    			+ "1/4 cup vegetable oil"
    			+ "\r\n"
    			+ "1/4 cup sour cream"
    			+ "\r\n"
    			+ "1 bunch cilantro, leaves chopped (about 3/4 cup)"
    			+ "\r\n"
    			+ "Kosher salt and freshly ground pepper"
    			+ "\r\n"
    			+ "1 14-ounce can hearts of palm, drained and sliced 1/2 inch thick"
    			+ "\r\n"
    			+ "1 avocado, chopped"
    			+ "\r\n"
    			+ "6 radishes, thinly sliced"
    			+ "\r\n"
    			+ "16 corn tortillas"
    			+ "\r\n"
    			+ "Shredded lettuce and/or diced red onion, for topping"
    			+ "\r\n");
    	
    	// Creating labels for the recipe
    	Label tacosDirectionsLabel = new Label("Directions:");
    	tacosDirectionsLabel.setFont(directionsFont);
    	
    	Label tacosRecipe = new Label();
    	// Writing recipe
    	tacosRecipe.setText(
    			"Toss the chicken with 1/2 cup salsa, the juice of 1 lime and 1 tablespoon vegetable oil in a large bowl;"
    			+ "\r\n"
    			+ "let marinate 10 minutes. Mix the remaining 1/2 cup salsa, the sour cream and 2 tablespoons cilantro in a small bowl;"
    			+ "\r\n"
    			+ "season with salt and pepper. Cover and refrigerate."
    			+ "\r\n"
    			+ "Gently toss the hearts of palm, avocado, radishes, the remaining cilantro, 1 tablespoon vegetable oil and"
    			+ "\r\n"
    			+ "the juice of the remaining lime in a medium bowl; season with salt and pepper."
    			+ "\r\n"
    			+ "Heat the remaining 2 tablespoons vegetable oil in a large cast-iron skillet or grill pan over medium-high heat."
    			+ "\r\n"
    			+ "Add the chicken along with the marinade and cook until slightly charred and cooked through,"
    			+ "\r\n"
    			+ "about 7 minutes per side. Transfer to a cutting board and chop; season with salt."
    			+ "\r\n"
    			+ "Warm the tortillas as the label directs. Using 2 stacked tortillas per taco, fill with the chicken,"
    			+ "\r\n"
    			+ "salsa-sour cream mixture and lettuce and/or red onion. Serve with the avocado salad and lime wedges.");
    	
    	// Creating container for button
    	HBox doneButtonContainer = new HBox();
    	Font buttonFont = Font.font("System", FontWeight.BOLD, 16);
    	Button doneButton = new Button("Done");
    	doneButton.setFont(buttonFont);
    	doneButton.setStyle("-fx-background-color: orange");
    	doneButton.setTextFill(Color.WHITE);
    	
    	// Added a button into the container
    	doneButtonContainer.getChildren().add(doneButton);
    	doneButtonContainer.setAlignment(Pos.CENTER);
    	doneButtonContainer.setPadding(new Insets(200,0,0,0));
    	
    	// Set action for button
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	tacosRecipeContainer.getChildren().addAll(tacosNameContainer, tacosIngredients, tacosRecipeIngredients, 
    			tacosDirectionsLabel, tacosRecipe, doneButtonContainer);
    	
    	// Creating and setting a new scene
    	Scene tacosScene = new Scene(tacosRecipeContainer, 609, 856);
   	   	applicationStage.setScene(tacosScene);
    }

    /**
     * This method will open a new scene with a list of ingredients and the instructions to how to make roasted salmon.
     * @param roastedSalmonRecipeEvent This ActionEvent will change the scene to show the user the recipe.
     */
    @FXML
    void showRoastedSalmonRecipe(ActionEvent roastedSalmonRecipeEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	// Source: https://www.foodnetwork.com/recipes/food-network-kitchen/mustard-maple-roasted-salmon-recipe-2112041
    	
    	// Creating container and labels
    	VBox salmonRecipeContainer = new VBox();
    	salmonRecipeContainer.setStyle("-fx-background-color: white");
    	HBox salmonNameContainer = new HBox();
    	Label salmonRecipeIngredients = new Label();
    	Label salmonNameLabel = new Label("Maple-Mustard Roasted Salmon");
    	salmonNameContainer.getChildren().add(salmonNameLabel);
    	salmonNameContainer.setAlignment(Pos.CENTER);
    	salmonNameLabel.setFont(font);
    	Label salmonIngredients = new Label("Ingredients:");
    	salmonIngredients.setFont(ingredientsFont);
    	
    	// Writing ingredients
    	salmonRecipeIngredients.setText(
    			"2 tablespoons Dijon mustard"
    			+ "\r\n"
    			+ "2 tablespoons finely chopped fresh cilantro"
    			+ "\r\n"
    			+ "1 tablespoon light mayonnaise"
    			+ "\r\n"
    			+ "2 teaspoons pure maple syrup"
    			+ "\r\n"
    			+ "Four 5-ounce skinless center-cut salmon fillets"
    			+ "\r\n"
    			+ "Kosher salt and freshly ground black pepper"
    			+ "\r\n");
    	
    	// Creating label for instructions
    	Label salmonDirectionsLabel = new Label("Directions:");
    	salmonDirectionsLabel.setFont(directionsFont);
    	
    	Label salmonRecipe = new Label();
    	// Writing recipe
    	salmonRecipe.setText(
    			"Preheat the oven to 400 degrees F. Line a rimmed baking sheet with aluminum foil."
    			+ "\r\n"
    			+ "Mix together the mustard, 1 tablespoon of the cilantro, the mayonnaise and maple syrup in a bowl."
    			+ "\r\n"
    			+ "Put the salmon fillets on the baking sheet and sprinkle with 1/4 teaspoon each salt and pepper."
    			+ "\r\n"
    			+ "Spread some of the mustard mixture evenly over each fillet."
    			+ "\r\n"
    			+ "Bake until just cooked through, 10 to 12 minute."
    			+ "\r\n"
    			+ "Sprinkle with the remaining 1 tablespoon cilantro and serve.");
    	
    	// Creating button container
    	HBox doneButtonContainer = new HBox();
    	Font buttonFont = Font.font("System", FontWeight.BOLD, 16);
    	Button doneButton = new Button("Done");
    	doneButton.setFont(buttonFont);
    	doneButton.setStyle("-fx-background-color: orange");
    	doneButton.setTextFill(Color.WHITE);
    	
    	// Added button to container
    	doneButtonContainer.getChildren().add(doneButton);
    	doneButtonContainer.setAlignment(Pos.CENTER);
    	doneButtonContainer.setPadding(new Insets(200,0,0,0));
    	
    	// Set action for button
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	salmonRecipeContainer.getChildren().addAll(salmonNameContainer, salmonIngredients, salmonRecipeIngredients, 
    			salmonDirectionsLabel, salmonRecipe, doneButtonContainer);
    	
    	// Creating and setting a new scene
    	Scene salmonScene = new Scene(salmonRecipeContainer, 609, 856);
   	   	applicationStage.setScene(salmonScene);
    }

    /**
     * This method will open a new scene with a list of ingredients and the instructions to how to make beef stir fry.
     * @param beefStirFryRecipeEvent This ActionEvent will change the scene to show the user the recipe.
     */
    @FXML
    void showBeefStirFryRecipe(ActionEvent beefStirFryRecipeEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	// Source: https://www.foodnetwork.com/recipes/beef-stir-fry-3364942
    	
    	// Creating containers and labels
    	VBox stirFryRecipeContainer = new VBox();
    	stirFryRecipeContainer.setStyle("-fx-background-color: white");
    	HBox stirFryNameContainer = new HBox();
    	Label stirFryRecipeIngredients = new Label();
    	Label stirFryNameLabel = new Label("Beef Stir Fry");
    	stirFryNameContainer.getChildren().add(stirFryNameLabel);
    	stirFryNameContainer.setAlignment(Pos.CENTER);
    	stirFryNameLabel.setFont(font);
    	Label stirFryIngredients = new Label("Ingredients:");
    	stirFryIngredients.setFont(ingredientsFont);
    	
    	// Writing the ingredients
    	stirFryRecipeIngredients.setText(
    			"1 1/2 pounds skirt steak, cut into 4-inch-long pieces, then cut against the grain into 1/4-inch-thick slices"
    			+ "\r\n"
    			+ "Salt and freshly ground pepper"
    			+ "\r\n"
    			+ "1/4 cup low-sodium soy sauce"
    			+ "\r\n"
    			+ "1 serrano chile pepper, seeded and finely chopped"
    			+ "\r\n"
    			+ "2 teaspoons sugar"
    			+ "\r\n"
    			+ "2 tablespoons freshly squeezed lime juice (1 to 2 limes)"
    			+ "\r\n"
    			+ "2 tablespoons olive oil"
    			+ "\r\n"
    			+ "2 cloves garlic, grated"
    			+ "\r\n"
    			+ "1 bunch scallions, thinly sliced"
    			+ "\r\n"
    			+ "6 ounces fresh mushrooms, sliced"
    			+ "\r\n"
    			+ "1/4 pound snow peas or green beans"
    			+ "\r\n"
    			+ "1 12-ounce can baby corn, drained"
    			+ "\r\n"
    			+ "1 red bell pepper, thinly sliced (optional)"
    			+ "\r\n");
    	
    	// Creating label for instructions
    	Label stirFryDirectionsLabel = new Label("Directions:");
    	stirFryDirectionsLabel.setFont(directionsFont);
    	
    	Label stirFryRecipe = new Label();
    	// Writing recipe
    	stirFryRecipe.setText(
    			"Season the steak with salt and pepper. In a medium bowl, whisk together the soy sauce, chile pepper,"
    			+ "\r\n"
    			+ "sugar and lime juice until the sugar is dissolved. Add the beef, toss to coat and set aside."
    			+ "\r\n"
    			+ "In a large skillet over medium-high heat, heat the oil until shimmering, about 1 minute."
    			+ "\r\n"
    			+ "Add the beef and cook, stirring, until cooked through, 3 to 5 minutes."
    			+ "\r\n"
    			+ "Remove the beef from the skillet and set aside. Allow the liquid in the pan to reduce until thickened,"
    			+ "\r\n"
    			+ " about 4 minutes."
    			+ "\r\n"
    			+ "Add the garlic and scallions and cook 1 minute more. Add the mushrooms and cook for 2 to 3 minutes more."
    			+ "\r\n"
    			+ "Add the snow peas, baby corn and bell pepper and continue cooking until all the"
    			+ "\r\n"
    			+ "vegetables are crisp-tender, about 2 minutes. Return the beef to the skillet and toss to combine.");
    	
    	// Creating a button container
    	HBox doneButtonContainer = new HBox();
    	Font buttonFont = Font.font("System", FontWeight.BOLD, 16);
    	Button doneButton = new Button("Done");
    	doneButton.setFont(buttonFont);
    	doneButton.setStyle("-fx-background-color: orange");
    	doneButton.setTextFill(Color.WHITE);
    	
    	// Add button to container
    	doneButtonContainer.getChildren().add(doneButton);
    	doneButtonContainer.setAlignment(Pos.CENTER);
    	doneButtonContainer.setPadding(new Insets(200,0,0,0));
    	
    	// Set action for button
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	stirFryRecipeContainer.getChildren().addAll(stirFryNameContainer, stirFryIngredients, stirFryRecipeIngredients, 
    			stirFryDirectionsLabel, stirFryRecipe, doneButtonContainer);
    	
    	//Creating and setting a new scene
    	Scene stirFryScene = new Scene(stirFryRecipeContainer, 609, 856);
   	   	applicationStage.setScene(stirFryScene);
    }
    
    /**
     * This method will open a new scene with a list of ingredients and the instructions to how to make grilled chicken.
     * @param grilledChickenRecipeEvent This ActionEvent will change the scene to show the user the recipe.
     */
    @FXML
    void showGrilledChickenRecipe(ActionEvent grilledChickenRecipeEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	// Source: https://www.foodnetwork.com/recipes/food-network-kitchen/grilled-chicken-with-avocado-pesto-3796532
    	
    	// Create containers and labels
    	VBox chickenRecipeContainer = new VBox();
    	chickenRecipeContainer.setStyle("-fx-background-color: white");
    	HBox chickenNameContainer = new HBox();
    	Label chickenRecipeIngredients = new Label();
    	Label chickenNameLabel = new Label("Grilled Chicken with Avocado Pesto");
    	chickenNameContainer.getChildren().add(chickenNameLabel);
    	chickenNameContainer.setAlignment(Pos.CENTER);
    	chickenNameLabel.setFont(font);
    	Label chickenIngredients = new Label("Ingredients:");
    	chickenIngredients.setFont(ingredientsFont);
    	// Writing the ingredients
    	chickenRecipeIngredients.setText(
    			"4 tablespoons extra-virgin olive oil, plus more for brushing the grill grates"
    			+ "\r\n"
    			+ "Zest of 1 lemon plus 2 tablespoons juice"
    			+ "\r\n"
    			+ "2 1/4 pounds boneless, skinless chicken breasts, cut into 1-inch pieces"
    			+ "\r\n"
    			+ "Kosher salt and freshly ground black pepper"
    			+ "\r\n"
    			+ "1/4 cup pine nuts"
    			+ "\r\n"
    			+ "1 cup loosely packed fresh basil leaves"
    			+ "\r\n"
    			+ "1 cup loosely packed fresh parsley leaves"
    			+ "\r\n"
    			+ "1 clove garlic, crushed and peeled"
    			+ "\r\n"
    			+ "1 large ripe avocado"
    			+ "\r\n");
    	
    	// Creating labels for recipe
    	Label chickenDirectionsLabel = new Label("Directions:");
    	chickenDirectionsLabel.setFont(directionsFont);
    	
    	Label chickenRecipe = new Label();
    	// Writing the recipe
    	chickenRecipe.setText(
    			"\r\n"
    			+ "Special equipment: Six 12-inch metal skewers or twelve 6-inch bamboo skewers"
    			+ "\r\n"
    			+ "\r\n"
    			+ "Prepare an outdoor grill or a grill pan for medium heat."
    			+ "\r\n"
    			+ "Whisk together 1 tablespoon of the oil and the lemon zest in a large bowl."
    			+ "\r\n"
    			+ "Add the chicken to the oil and toss to coat. Sprinkle with salt and pepper."
    			+ "\r\n"
    			+ "Divide the chicken and thread onto metal or bamboo skewers."
    			+ "\r\n"
    			+ "Toast the pine nuts in a small skillet over medium heat, tossing frequently,"
    			+ "\r\n"
    			+ "until light golden, 3 to 4 minutes. Let cool."
    			+ "\r\n"
    			+ "Combine the pine nuts, basil, parsley, garlic, 1/2 teaspoon salt and several grinds of pepper in a"
    			+ "\r\n"
    			+ "food processor. Process to make a coarse paste. Add the avocado, lemon juice and"
    			+ "\r\n"
    			+ "remaining 3 tablespoons oil and process until mostly smooth."
    			+ "\r\n"
    			+ "Grill the chicken, turning often, until just cooked through, 5 to 7 minutes."
    			+ "\r\n"
    			+ "Serve the chicken dolloped with the pesto and any extra pesto on the side.");
    	
    	// Created a button container
    	HBox doneButtonContainer = new HBox();
    	Font buttonFont = Font.font("System", FontWeight.BOLD, 16);
    	Button doneButton = new Button("Done");
    	doneButton.setFont(buttonFont);
    	doneButton.setStyle("-fx-background-color: orange");
    	doneButton.setTextFill(Color.WHITE);
    	
    	// Added button to container
    	doneButtonContainer.getChildren().add(doneButton);
    	doneButtonContainer.setAlignment(Pos.CENTER);
    	doneButtonContainer.setPadding(new Insets(200,0,0,0));
    	
    	// Set action for button
    	doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
    	chickenRecipeContainer.getChildren().addAll(chickenNameContainer, chickenIngredients, chickenRecipeIngredients, 
    			chickenDirectionsLabel, chickenRecipe, doneButtonContainer);
    	
    	// Created and set a new scene
    	Scene chickenScene = new Scene(chickenRecipeContainer, 609, 856);
   	   	applicationStage.setScene(chickenScene);
    }

    /**
     * /**
	 * This ActionEvent changes the scene back to the main page while passing the same User
	 * object and setting various labels in the main window.
     * @param returnToMainPagevent Changes the scene back to the main window.
     */
    @FXML
    void returnToMainPage(ActionEvent returnToMainPagevent) {
    	try {
 		   FXMLLoader loader = new FXMLLoader();
 		   BorderPane root = loader.load(new FileInputStream("src/application/FitnessTrackerView.fxml"));
 		   FitnessTrackerController controller = (FitnessTrackerController)loader.getController();
 		   
 		   controller.setUser(user);
 		   controller.setGoalsCompletedLabel();
 		   controller.setNameLabel();
 		   controller.setDisplayLabel();
 		   controller.applicationStage = applicationStage;
 		   
 		   Scene scene = new Scene(root);
 		   applicationStage.setScene(scene);
 		   applicationStage.show();
 		   
 		
 	   } catch(Exception e) {
 		   e.printStackTrace();
 	   }
    }
}
