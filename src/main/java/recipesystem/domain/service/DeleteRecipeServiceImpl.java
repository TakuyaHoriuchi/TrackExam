package recipesystem.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import recipesystem.domain.repository.RecipeRepository;

/**
 * {@link:DeleteRecipeService}のStub実装クラス.
 * 実装後に削除する.
 */
@Component
public class DeleteRecipeServiceImpl implements DeleteRecipeService {

  @Autowired
  RecipeRepository recipeRepos;
  
  @Override
  public Boolean delete(Integer id) {
    return (id < 5);
  }

}
