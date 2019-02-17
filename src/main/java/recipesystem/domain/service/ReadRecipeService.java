package recipesystem.domain.service;

import java.util.List;

import recipesystem.domain.model.Recipe;

/**
 * レシピ情報を取得するサービスクラス.
 */
public interface ReadRecipeService {

  /**
   * 全レシピ取得メソッド.
   * @return レシピ情報.
   */
  public List<Recipe> readAll();

  /**
   * IDのレシピを取得するメソッド.
   * @param id 取得対象レシピのID.
   * @return レシピ情報.
   */
  public Recipe read(Integer id);

}
