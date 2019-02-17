package recipesystem.application.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import recipesystem.application.payload.RecipeInfoResponse;
import recipesystem.domain.model.ResponseRecipe;
import recipesystem.domain.model.RequestRecipe;
import recipesystem.domain.service.UpdateRecipeService;

/**
 * レシピ情報を取得するクラス.
 */
@RestController
@RequestMapping(value = "recipes")
public class UpdateRecipeController {
  @Autowired
  UpdateRecipeService recipeService;

  /**
   * 指定したIDのレシピを取得するメソッド.
   * @param id 更新対象レシピのID.
   * @param recipe レシピの更新情報.
   * @return 処理結果内容.
   */
  @PatchMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  public RecipeInfoResponse updateRecipe(@PathVariable("id") int id,
                                         @RequestBody RequestRecipe recipe) {
    ResponseRecipe updatedRecipe = recipeService.update(id, recipe);
    return generateRecipeResponse(updatedRecipe);
  }
  
  private RecipeInfoResponse generateRecipeResponse(ResponseRecipe updatedRecipe) {
    RecipeInfoResponse response = new RecipeInfoResponse();
    if (updatedRecipe == null) {
      response.setMessage("Fail to update Recipe");
    } else {
      response.setMessage("Recipe successfully updated!");
      response.setRecipe(new ArrayList<>());
      response.getRecipe().add(updatedRecipe);
    }
    return response;
  }
}
