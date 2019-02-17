package recipesystem.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import recipesystem.domain.model.Recipe;
import recipesystem.domain.repository.RecipeRepository;

/**
 * {@link:CreateRecipeService}の実装クラス.
 */
public class CreateRecipeServiceImpl implements CreateRecipeService {

  @Autowired
  RecipeRepository recipeRepos;
  
  /**
   * {@inheritDoc}.
   */
  @Override
  public Recipe create(Recipe recipe) {
    return recipe;
  }

}
