package recipesystem.application.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import recipesystem.application.controller.CreateRecipeController;
import recipesystem.application.payload.RecipeInfoResponse;
import recipesystem.domain.model.Recipe;
import recipesystem.domain.service.CreateRecipeService;

/**
 * {@link:CreateRecipeController}のテスト.
 *
 */
public class CreateRecipeControllerTest {
  @InjectMocks
  CreateRecipeController testTarget;
  @Mock
  CreateRecipeService recipeService;
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }
  
  @Test
  public void test_SuccessToCreateRecipe() {
    // setup
    Recipe requestRecipe = createSuccessRecipe();
    when(recipeService.create(requestRecipe)).thenReturn(requestRecipe);
    
    RecipeInfoResponse actual = testTarget.createRecipe(requestRecipe);
    // expected
    String expectedMessage = "Recipe successfully created!";
    
    assertThat(actual.getMessage(), is(equalTo(expectedMessage)));
    assertThat(actual.getRecipe().get(0), is(samePropertyValuesAs(requestRecipe)));
  }
  
  @Test
  public void test_FailToCreateRecipe() {
    // setup
    Recipe requestRecipe = new Recipe();
    when(recipeService.create(requestRecipe)).thenReturn(null);
    
    RecipeInfoResponse actual = testTarget.createRecipe(requestRecipe);
    // expected
    String expectedMessage = "Recipe creation failed!";
    String expectedRequired = "title, making_time, serves, ingredients, cost";
    
    assertThat(actual.getMessage(), is(equalTo(expectedMessage)));
    assertThat(actual.getRequired(), is(equalTo(expectedRequired)));
  }

  private Recipe createSuccessRecipe() {
    Recipe requestRecipe = new Recipe();
    requestRecipe.setCost("450");
    requestRecipe.setMakingTime("15分");
    requestRecipe.setIngredients("玉ねぎ, トマト, スパイス, 水");
    requestRecipe.setServes("5人");
    requestRecipe.setTitle("トマトスープ");
    return requestRecipe;
  }
}
