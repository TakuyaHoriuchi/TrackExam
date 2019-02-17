package recipesystem.application.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import recipesystem.application.payload.RecipeInfoResponse;
import recipesystem.domain.model.Recipe;
import recipesystem.domain.model.ResponseRecipe;
import recipesystem.domain.service.CreateRecipeService;

/**
 * レシピを新規作成するクラス.
 */
@RestController
@RequestMapping(value = "recipes")
public class CreateRecipeController {
  @Autowired
  CreateRecipeService recipeService;
  
  /**
   * レシピを新規追加するメソッド.
   * @param recipe 新規に追加するレシピ情報.
   * @return 処理結果内容.
   */
  @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  public RecipeInfoResponse createRecipe(@RequestBody Recipe recipe) {
    ResponseRecipe createdRecipe = recipeService.create(recipe);
    return generateResponse(createdRecipe);
  }

  private RecipeInfoResponse generateResponse(ResponseRecipe createdRecipe) {
    RecipeInfoResponse response = new RecipeInfoResponse();
    if (createdRecipe == null) {
      response.setMessage("Recipe creation failed!");
      response.setRequired("title, making_time, serves, ingredients, cost");
    } else {
      response.setMessage("Recipe successfully created!");
      response.setRecipe(new ArrayList<>());
      response.getRecipe().add(createdRecipe);
    }
    return response;
  }
}
