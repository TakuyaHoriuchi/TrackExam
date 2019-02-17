package recipesystem.domain.service;

import java.util.List;
import recipesystem.domain.model.ResponseRecipe;

/**
 * レシピ情報を取得するサービスクラス.
 */
public interface ReadRecipeService {

  /**
   * 全レシピ取得メソッド.
   * @return レシピ情報.
   */
  public List<ResponseRecipe> readAll();

  /**
   * IDのレシピを取得するメソッド.
   * @param id 取得対象レシピのID.
   * @return レシピ情報.
   */
  public ResponseRecipe read(Integer id);

}
