package recipesystem.domain.service;

import recipesystem.domain.model.Recipe;

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
