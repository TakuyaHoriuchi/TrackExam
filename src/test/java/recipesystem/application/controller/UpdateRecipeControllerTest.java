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
import recipesystem.application.controller.UpdateRecipeController;
import recipesystem.application.payload.RecipeInfoResponse;
import recipesystem.domain.model.Recipe;
import recipesystem.domain.model.ResponseRecipe;
import recipesystem.domain.service.UpdateRecipeService;

/**
 * {@link UpdateRecipeController}のテスト.
 *
 */
public class UpdateRecipeControllerTest {
  @InjectMocks
  UpdateRecipeController testTarget;
  @Mock
  UpdateRecipeService recipeService;
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }
  
  @Test
  public void test_SuccessToUpdateRecipe() {
    // setup
    Recipe requestRecipe = createSuccessRequestRecipe();
    ResponseRecipe responseRecipe = createSuccessResponseRecipe();
    when(recipeService.update(2, requestRecipe)).thenReturn(responseRecipe);
    
    // execute
    RecipeInfoResponse actual = testTarget.updateRecipe(2, requestRecipe);
    
    // expected
    String expectedMessage = "Recipe successfully updated!";
    
    // assert
    assertThat(actual.getMessage(), is(equalTo(expectedMessage)));
    assertThat(actual.getRecipe().get(0), is(samePropertyValuesAs(responseRecipe)));
  }

  @Test
  public void test_FailToUpdateRecipe() {
    // setup
    Recipe recipe = new Recipe();
    when(recipeService.update(100, recipe)).thenReturn(null);
    
    // execute
    RecipeInfoResponse actual = testTarget.updateRecipe(100, recipe);
    
    // expected
    String expectedMessage = "Fail to update Recipe";
    
    // assert
    assertThat(actual.getMessage(), is(equalTo(expectedMessage)));
  }
  
  private Recipe createSuccessRequestRecipe() {
    Recipe requestRecipe = new Recipe();
    requestRecipe.setTitle("トマトスープレシピ");
    requestRecipe.setMakingTime("15分");
    requestRecipe.setServes("5人");
    requestRecipe.setIngredients("玉ねぎ, トマト, スパイス, 水");
    requestRecipe.setCost(450);
    return requestRecipe;
  }

  private ResponseRecipe createSuccessResponseRecipe() {
    ResponseRecipe requestRecipe = new ResponseRecipe();
    requestRecipe.setTitle("トマトスープレシピ");
    requestRecipe.setMakingTime("15分");
    requestRecipe.setServes("5人");
    requestRecipe.setIngredients("玉ねぎ, トマト, スパイス, 水");
    requestRecipe.setCost("450");
    return requestRecipe;
  }
  
}
