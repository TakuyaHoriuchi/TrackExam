package recipesystem.domain.service;

import recipesystem.application.payload.Recipe;

/**
 * レシピ情報を更新するサービスクラス.
 */
public interface UpdateRecipeService {

  /**
   * レシピ更新メソッド.
   * @return 更新レシピ情報.
   */
  public Recipe update(int id, Recipe requestRecipe);

}
