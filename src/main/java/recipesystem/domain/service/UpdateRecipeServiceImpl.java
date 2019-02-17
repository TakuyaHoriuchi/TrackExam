package recipesystem.domain.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import recipesystem.domain.model.Recipe;
import recipesystem.domain.repository.RecipeRepository;
import recipesystem.infrastructure.model.RecipeEntity;

/**
 * {@link:UpdateRecipeService}の実装クラス.
 * 実装後に削除する.
 */
@Component
public class UpdateRecipeServiceImpl implements UpdateRecipeService {

  @Autowired
  RecipeRepository recipeRepos;
  
  /**
   * {@inheritDoc}.
   */
  @Override
  public Recipe update(int id, Recipe requestRecipe) {
    Optional<RecipeEntity> result = recipeRepos.findById(id);
    if (!result.isPresent()) {
      return null;
    }
    RecipeEntity recipeEntity = result.get();
    mapperPayloadToRequest(requestRecipe, recipeEntity);
    RecipeEntity savedEntity = recipeRepos.save(recipeEntity);
    return mapperResponseFromResult(savedEntity);
  }

  private Recipe mapperResponseFromResult(RecipeEntity savedEntity) {
    Recipe response = new Recipe();
    response.setTitle(savedEntity.getTitle());
    response.setMakingTime(savedEntity.getMakingTime());
    response.setServes(savedEntity.getServes());
    response.setIngredients(savedEntity.getIngredients());
    response.setCost(savedEntity.getCost().toString());
    return response;
  }

  private void mapperPayloadToRequest(Recipe requestRecipe, RecipeEntity recipeEntity) {
    recipeEntity.setTitle(requestRecipe.getTitle());
    recipeEntity.setMakingTime(requestRecipe.getMakingTime());
    recipeEntity.setServes(requestRecipe.getServes());
    recipeEntity.setIngredients(requestRecipe.getIngredients());
    recipeEntity.setCost(Integer.parseInt(requestRecipe.getCost()));
  }

}
