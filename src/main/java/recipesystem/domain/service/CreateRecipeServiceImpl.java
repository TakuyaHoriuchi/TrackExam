package recipesystem.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import recipesystem.domain.model.Recipe;
import recipesystem.domain.repository.RecipeRepository;
import recipesystem.infrastructure.model.RecipeEntity;

/**
 * {@link:CreateRecipeService}の実装クラス.
 */
@Component
public class CreateRecipeServiceImpl implements CreateRecipeService {

  @Autowired
  RecipeRepository recipeRepos;
  
  /**
   * {@inheritDoc}.
   */
  @Override
  public Recipe create(Recipe recipe) {
    if (recipe.getTitle() == null
        || recipe.getServes() == null
        || recipe.getMakingTime() == null
        || recipe.getIngredients() == null
        || recipe.getCost() == null) {
      return null;
    } else {
      RecipeEntity entity = new RecipeEntity(null,
                                             recipe.getTitle(),
                                             recipe.getMakingTime(),
                                             recipe.getServes(),
                                             recipe.getIngredients(),
                                             Integer.parseInt(recipe.getCost()));
      RecipeEntity result = recipeRepos.save(entity);
      return mapperResultToResponse(result);
    }
  }

  private Recipe mapperResultToResponse(RecipeEntity result) {
    Recipe response = new Recipe();
    response.setTitle(result.getTitle());
    response.setMakingTime(result.getMakingTime());
    response.setServes(result.getServes());
    response.setIngredients(result.getIngredients());
    response.setCost(result.getCost().toString());
    return response;
  }

}
