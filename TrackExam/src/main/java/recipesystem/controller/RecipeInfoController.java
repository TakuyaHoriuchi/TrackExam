package recipesystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RecipeInfoController {

  /**
   * レシピを新規追加するメソッド.
   * @return 処理結果内容.
   */
  @RequestMapping(value = "/")
  public String rootAccess() {
    return "root";
  }

}
