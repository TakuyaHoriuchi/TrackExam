package recipesystem.application.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import recipesystem.application.payload.RecipeInfoResponse;
import recipesystem.application.payload.RecipesInfoResponse;
import recipesystem.domain.model.ResponseRecipe;
import recipesystem.domain.service.ReadRecipeService;

/**
 * レシピ情報を取得するクラス.
 */
@RestController
@RequestMapping(value = "recipes")
public class ReadRecipeController {
  @Autowired
  ReadRecipeService recipeService;
  
  /**
   * 指定したIDのレシピを取得するメソッド.
   * @return 処理結果内容.
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  public RecipesInfoResponse readAllRecipes() {
    List<ResponseRecipe> readRecipes = recipeService.readAll();
    return generateRecipesResponse(readRecipes);
  }

  /**
   * 指定したIDのレシピを取得するメソッド.
   * @param id 取得対象レシピのID.
   * @return 処理結果内容.
   */
  @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  public RecipeInfoResponse readRecipeFromId(@PathVariable("id") Integer id) {
    ResponseRecipe readRecipe = recipeService.read(id);
    return generateRecipeResponse(readRecipe);
  }

  private RecipesInfoResponse generateRecipesResponse(List<ResponseRecipe> readRecipes) {
    RecipesInfoResponse response = new RecipesInfoResponse();
    if (readRecipes.isEmpty()) {
      response.setMessage("No Recipe found");
    } else {
      response.setRecipes(readRecipes);
    }
    return response;
  }
  
  private RecipeInfoResponse generateRecipeResponse(ResponseRecipe readRecipe) {
    RecipeInfoResponse response = new RecipeInfoResponse();
    if (readRecipe == null) {
      response.setMessage("No Recipe found");
    } else {
      response.setMessage("Recipe details by id");
      response.setRecipe(new ArrayList<>());
      response.getRecipe().add(readRecipe);
    }
    return response;
  }
}
