package recipesystem.domain.service;

import org.springframework.stereotype.Component;

import recipesystem.domain.model.Recipe;

/**
 * {@link:CreateRecipeService}のStub実装クラス.
 * 実装後に削除する.
 */
//@Component
public class CreateRecipeServiceMock implements CreateRecipeService {

  @Override
  public Recipe create(Recipe recipe) {
    if (recipe.getTitle() == null
        || recipe.getServes() == null
        || recipe.getMakingTime() == null
        || recipe.getIngredients() == null
        || recipe.getCost() == null) {
      return null;
    } else {
      return recipe;
    }
  }
}
