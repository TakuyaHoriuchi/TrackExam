package recipesystem.domain.service;

import recipesystem.domain.model.Recipe;

/**
 * レシピ情報を更新するサービスクラス.
 */
public interface UpdateRecipeService {

  /**
   * レシピ更新メソッド.
   * @param id 更新対象レシピのID.
   * @param recipe レシピの更新情報.
   * @return 更新レシピ情報.
   */
  public Recipe update(int id, Recipe recipe);

}
