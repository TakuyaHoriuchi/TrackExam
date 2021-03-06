package recipesystem.domain.service;

/**
 * レシピを削除するサービスクラス.
 */
public interface DeleteRecipeService {

  /**
   * レシピ削除メソッド.
   * @param id 削除対象レシピのID.
   * @return 削除処理結果.
   */
  Boolean delete(Integer id);

}
