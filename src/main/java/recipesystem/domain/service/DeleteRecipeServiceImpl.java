package recipesystem.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import recipesystem.domain.repository.RecipeRepository;

/**
 * {@link DeleteRecipeService}の実装クラス.
 * 実装後に削除する.
 */
@Component
public class DeleteRecipeServiceImpl implements DeleteRecipeService {

  @Autowired
  RecipeRepository recipeRepos;
  
  /**
   * {@inheritDoc}.
   */
  @Override
  public Boolean delete(Integer id) {
    try {
      recipeRepos.deleteById(id);
    } catch (IllegalArgumentException e) {
      return false;
    }
    return true;
  }

}
