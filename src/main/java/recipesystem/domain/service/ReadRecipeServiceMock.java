package recipesystem.domain.service;

import java.util.ArrayList;
import java.util.List;

import recipesystem.domain.model.Recipe;

/**
 * {@link:ReadRecipeService}のStub実装クラス.
 * 実装後に削除する.
 */
public class ReadRecipeServiceMock implements ReadRecipeService {

  /**
   * {@inheritDoc}.
   */
  @Override
  public List<Recipe> readAll() {
    return createAllRecipes();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Recipe read(Integer id) {
    return createRecipe();
  }
  
  private List<Recipe> createAllRecipes() {
    Recipe firstRecipe = new Recipe();
    firstRecipe.setId(Long.valueOf(1));
    firstRecipe.setTitle("チキンカレー");
    firstRecipe.setMakingTime("45分");
    firstRecipe.setServes("4人");
    firstRecipe.setIngredients("玉ねぎ,肉,スパイス");
    firstRecipe.setCost("1000");
    
    Recipe secondRecipe = new Recipe();
    secondRecipe.setId(Long.valueOf(2));
    secondRecipe.setTitle("オムライス");
    secondRecipe.setMakingTime("30分");
    secondRecipe.setServes("2人");
    secondRecipe.setIngredients("玉ねぎ,卵,スパイス,醤油");
    secondRecipe.setCost("700");
    
    Recipe thirdRecipe = new Recipe();
    thirdRecipe.setId(Long.valueOf(3));
    thirdRecipe.setTitle("トマトスープ");
    thirdRecipe.setMakingTime("15分");
    thirdRecipe.setServes("5人");
    thirdRecipe.setIngredients("玉ねぎ, トマト, スパイス, 水");
    thirdRecipe.setCost("450");
    
    List<Recipe> recipes = new ArrayList<>();
    recipes.add(firstRecipe);
    recipes.add(secondRecipe);
    recipes.add(thirdRecipe);
    
    return recipes;
  }
  
  private Recipe createRecipe() {
    Recipe recipe = new Recipe();
    recipe.setCost("1000");
    recipe.setMakingTime("45分");
    recipe.setIngredients("玉ねぎ,肉,スパイス");
    recipe.setServes("4人");
    recipe.setTitle("チキンカレー");
    return recipe;
  }

}
