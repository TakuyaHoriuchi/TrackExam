package recipesystem.domain.service;

import recipesystem.application.payload.RequestRecipe;
import recipesystem.domain.model.Recipe;

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
  public Recipe create(RequestRecipe recipe);
  
}
