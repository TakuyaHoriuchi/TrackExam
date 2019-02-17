package recipesystem.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import recipesystem.application.payload.RecipeInfoResponse;
import recipesystem.domain.service.DeleteRecipeService;

/**
 * レシピ情報を取得するクラス.
 */
@RestController
@RequestMapping(value = "recipes")
public class DeleteRecipeController {
  @Autowired
  DeleteRecipeService recipeService;

  /**
   * 指定したIDのレシピを取得するメソッド.
   * @param id 削除対象レシピのID.
   * @return 処理結果内容.
   */
  @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  public RecipeInfoResponse deleteRecipe(@PathVariable("id") Integer id) {
    Boolean deleteResult = recipeService.delete(id);
    return generateRecipeResponse(deleteResult);
  }
  
  private RecipeInfoResponse generateRecipeResponse(Boolean deleteResult) {
    RecipeInfoResponse response = new RecipeInfoResponse();
    if (deleteResult) {
      response.setMessage("Recipe successfully removed!");
    } else {
      response.setMessage("No Recipe found");
    }
    return response;
  }
}
