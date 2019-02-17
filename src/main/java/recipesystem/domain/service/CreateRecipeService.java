package recipesystem.domain.service;

import recipesystem.domain.model.ResponseRecipe;
import recipesystem.domain.model.RequestRecipe;

/**
 * レシピの新規作成サービス.
 */
public interface CreateRecipeService {

  /** 
   * レシピの新規作成を実施するメソッド.
   * 
   * @param recipe 新規作成するレシピ情報.
   * @return 作成されたレシピ情報.
   */
  public ResponseRecipe create(RequestRecipe recipe);
  
}
