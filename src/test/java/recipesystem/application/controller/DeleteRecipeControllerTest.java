package recipesystem.application.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import recipesystem.application.controller.DeleteRecipeController;
import recipesystem.application.payload.RecipeInfoResponse;
import recipesystem.domain.service.DeleteRecipeService;

/**
 * {@link:DeleteRecipeController}のテスト.
 *
 */
public class DeleteRecipeControllerTest {
  @InjectMocks
  DeleteRecipeController testTarget;
  @Mock
  DeleteRecipeService recipeService;
  
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }
  
  @Test
  public void test_SuccessToDeleteRecipe() {
    // setup
    when(recipeService.delete(1)).thenReturn(true);
    
    // execute
    RecipeInfoResponse actual = testTarget.deleteRecipe(1);
    
    // expected
    String expectedMessage = "Recipe successfully removed!";
    
    // assert
    assertThat(actual.getMessage(), is(equalTo(expectedMessage)));
  }
  
  @Test
  public void test_FailToDeleteRecipe() {
    // setup
    when(recipeService.delete(100)).thenReturn(false);
    
    // execute
    RecipeInfoResponse actual = testTarget.deleteRecipe(100);
    
    // expected
    String expectedMessage = "No Recipe found";
    
    // assert
    assertThat(actual.getMessage(), is(equalTo(expectedMessage)));
  }

}
