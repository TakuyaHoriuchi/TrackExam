package recipesystem.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import recipesystem.domain.model.ResponseRecipe;
import recipesystem.domain.repository.RecipeRepository;
import recipesystem.infrastructure.model.RecipeEntity;

/**
 * {@link ReadRecipeService}の実装クラス.
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
  public List<ResponseRecipe> readAll() {
    List<RecipeEntity> allRecipes = recipeRepos.findAll();
    return mapperRecipesResponseFromResult(allRecipes);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public ResponseRecipe read(Integer id) {
    Optional<RecipeEntity> result = recipeRepos.findById(id);
    if (!result.isPresent()) {
      return null;
    }
    return mapperRecipeResponseFromResult(result);
  }

  
  private List<ResponseRecipe> mapperRecipesResponseFromResult(List<RecipeEntity> allRecipes) {
    List<ResponseRecipe> response = new ArrayList<>();
    for (RecipeEntity entity: allRecipes) {
      ResponseRecipe recipe = new ResponseRecipe();
      recipe.setId(Long.valueOf(entity.getId()));
      recipe.setTitle(entity.getTitle());
      recipe.setMakingTime(entity.getMakingTime());
      recipe.setServes(entity.getServes());
      recipe.setIngredients(entity.getIngredients());
      recipe.setCost(entity.getCost().toString());
      response.add(recipe);
    }
    return response;
  }

  private ResponseRecipe mapperRecipeResponseFromResult(Optional<RecipeEntity> result) {
    RecipeEntity recipeEntity = result.get();
    ResponseRecipe response = new ResponseRecipe();
    response.setTitle(recipeEntity.getTitle());
    response.setMakingTime(recipeEntity.getMakingTime());
    response.setServes(recipeEntity.getServes());
    response.setIngredients(recipeEntity.getIngredients());
    response.setCost(recipeEntity.getCost().toString());
    return response;
  }

}
