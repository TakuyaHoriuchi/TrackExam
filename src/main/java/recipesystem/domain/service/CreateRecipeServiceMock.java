package recipesystem.domain.service;

import org.springframework.stereotype.Component;

import recipesystem.application.payload.Recipe;

/**
 * {@link:CreateRecipeService}のStub実装クラス.
 * 実装後に削除する.
 */
@Component
public class CreateRecipeServiceMock implements CreateRecipeService {

  @Override
  public Recipe create(Recipe recipe) {
    return recipe;
  }
}
