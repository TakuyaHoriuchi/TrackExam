package recipesystem.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import recipesystem.domain.model.Recipe;
import recipesystem.domain.repository.RecipeRepository;
import recipesystem.infrastructure.model.RecipeEntity;

/**
 * {@link:ReadRecipeService}の実装クラス.
 * 実装後に削除する.
 */
@Component
public class ReadRecipeServiceImpl implements ReadRecipeService {

  @Autowired
  RecipeRepository recipeRepos;
  
  /**
   * {@inheritDoc}.
   */
  @Override
  public List<Recipe> readAll() {
    List<RecipeEntity> allRecipes = recipeRepos.findAll();
    return mapperRecipesResponseFromResult(allRecipes);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Recipe read(Integer id) {
    Optional<RecipeEntity> result = recipeRepos.findById(id);
    if (!result.isPresent()) {
      return null;
    }
    return mapperRecipeResponseFromResult(result);
  }

  
  private List<Recipe> mapperRecipesResponseFromResult(List<RecipeEntity> allRecipes) {
    List<Recipe> response = new ArrayList<>();
    for (RecipeEntity entity: allRecipes) {
      Recipe recipe = new Recipe();
      recipe.setTitle(entity.getTitle());
      recipe.setMakingTime(entity.getMakingTime());
      recipe.setServes(entity.getServes());
      recipe.setIngredients(entity.getIngredients());
      recipe.setCost(entity.getCost().toString());
      response.add(recipe);
    }
    return response;
  }

  private Recipe mapperRecipeResponseFromResult(Optional<RecipeEntity> result) {
    RecipeEntity recipeEntity = result.get();
    Recipe response = new Recipe();
    response.setTitle(recipeEntity.getTitle());
    response.setMakingTime(recipeEntity.getMakingTime());
    response.setServes(recipeEntity.getServes());
    response.setIngredients(recipeEntity.getIngredients());
    response.setCost(recipeEntity.getCost().toString());
    return response;
  }

}
