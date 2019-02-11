package recipesystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RecipeInfoController {
  // TODO Domain層のInterfaceを用意・Controller層のテストケースを用意して最低限実装する.
  // TODO Controller層の実装.
  // TODO Infrastructure層のInterfaceを用意・Domain層のテストケースを用意して最低限実装する.
  // TODO Domain層の実装.
  // TODO Infrastructure層の実装及び(あれば)テストケース追加.
  // TODO RuntimeExceptionMapper追加.
  // TODO ログ追加.
    
  /**
   * レシピを新規追加するメソッド.
   * @return 処理結果内容.
   */
  @RequestMapping(value = "/")
  public String rootAccess() {
    return "root";
  }

}
