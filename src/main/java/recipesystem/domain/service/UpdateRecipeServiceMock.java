package recipesystem.domain.service;

import org.springframework.stereotype.Component;

import recipesystem.application.payload.Recipe;

/**
 * {@link:UpdateRecipeService}のStub実装クラス.
 * 実装後に削除する.
 */
@Component
public class UpdateRecipeServiceMock implements UpdateRecipeService {

  @Override
  public Recipe update(int id, Recipe requestRecipe) {
    return createRecipe();
  }
  
  private Recipe createRecipe() {
    Recipe requestRecipe = new Recipe();
    requestRecipe.setTitle("トマトスープレシピ");
    requestRecipe.setMakingTime("15分");
    requestRecipe.setServes("5人");
    requestRecipe.setIngredients("玉ねぎ, トマト, スパイス, 水");
    requestRecipe.setCost("450");
    return requestRecipe;
  }

}
