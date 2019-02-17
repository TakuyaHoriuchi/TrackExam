package recipesystem.application.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import recipesystem.application.controller.ReadRecipeController;
import recipesystem.application.payload.RecipeInfoResponse;
import recipesystem.application.payload.RecipesInfoResponse;
import recipesystem.domain.model.ResponseRecipe;
import recipesystem.domain.service.ReadRecipeService;

/**
 * {@link ReadRecipeController}のテスト.
 *
 */
public class ReadRecipeControllerTest {
  @InjectMocks
  ReadRecipeController testTarget;
  @Mock
  ReadRecipeService recipeService;
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }
  
  @Test
  public void test_SuccessToReadAllRecipes() {
    // setup
    List<ResponseRecipe> allRecipes = createSuccessAllRecipes();
    when(recipeService.readAll()).thenReturn(allRecipes);
    
    // execute
    RecipesInfoResponse actual = testTarget.readAllRecipes();
    
    // assert
    assertThat(actual.getRecipes(), is(samePropertyValuesAs(allRecipes)));
  }
  
  @Test
  public void test_FailToReadAllRecipes() {
    // setup
    List<ResponseRecipe> emptyRecipes = new ArrayList<>();
    when(recipeService.readAll()).thenReturn(emptyRecipes);
    
    // execute
    RecipesInfoResponse actual = testTarget.readAllRecipes();
    
    // expected
    String expectedMessage = "No Recipe found";
    
    // assert
    assertThat(actual.getMessage(), is(equalTo(expectedMessage)));
  }
  

  @Test
  public void test_SuccessToReadRecipeFromId() {
    // setup
    ResponseRecipe recipe = createSuccessRecipe();
    when(recipeService.read(1)).thenReturn(recipe);
    
    // execute
    RecipeInfoResponse actual = testTarget.readRecipeFromId(1);
    
    // expected
    String expectedMessage = "Recipe details by id";
    
    // assert
    assertThat(actual.getMessage(), is(equalTo(expectedMessage)));
    assertThat(actual.getRecipe().get(0), is(samePropertyValuesAs(recipe)));
  }
  
  @Test
  public void test_FailToReadRecipeFromId() {
    // setup
    when(recipeService.read(100)).thenReturn(null);
    
    // execute
    RecipeInfoResponse actual = testTarget.readRecipeFromId(100);
    
    // expected
    String expectedMessage = "No Recipe found";
    
    // assert
    assertThat(actual.getMessage(), is(equalTo(expectedMessage)));
  }

  private List<ResponseRecipe> createSuccessAllRecipes() {
    ResponseRecipe firstRecipe = new ResponseRecipe();
    firstRecipe.setId(Long.valueOf(1));
    firstRecipe.setTitle("チキンカレー");
    firstRecipe.setMakingTime("45分");
    firstRecipe.setServes("4人");
    firstRecipe.setIngredients("玉ねぎ,肉,スパイス");
    firstRecipe.setCost("1000");
    
    ResponseRecipe secondRecipe = new ResponseRecipe();
    secondRecipe.setId(Long.valueOf(2));
    secondRecipe.setTitle("オムライス");
    secondRecipe.setMakingTime("30分");
    secondRecipe.setServes("2人");
    secondRecipe.setIngredients("玉ねぎ,卵,スパイス,醤油");
    secondRecipe.setCost("700");
    
    ResponseRecipe thirdRecipe = new ResponseRecipe();
    thirdRecipe.setId(Long.valueOf(3));
    thirdRecipe.setTitle("トマトスープ");
    thirdRecipe.setMakingTime("15分");
    thirdRecipe.setServes("5人");
    thirdRecipe.setIngredients("玉ねぎ, トマト, スパイス, 水");
    thirdRecipe.setCost("450");
    
    List<ResponseRecipe> recipes = new ArrayList<>();
    recipes.add(firstRecipe);
    recipes.add(secondRecipe);
    recipes.add(thirdRecipe);
    
    return recipes;
  }
  
  private ResponseRecipe createSuccessRecipe() {
    ResponseRecipe recipe = new ResponseRecipe();
    recipe.setCost("1000");
    recipe.setMakingTime("45分");
    recipe.setIngredients("玉ねぎ,肉,スパイス");
    recipe.setServes("4人");
    recipe.setTitle("チキンカレー");
    return recipe;
  }
  
  
}
