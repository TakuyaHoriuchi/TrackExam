package recipesystem.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * レスポンス表示用のレシピクラス.
 *
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseRecipe {
  /* レシピid. */
  @JsonProperty("id")
  private Long id;
  
  /* レシピ名. */
  @JsonProperty("title")
  private String title;
  
  /* 作成時間. */
  @JsonProperty("making_time")
  private String makingTime;
  
  /* 給仕人数. */
  @JsonProperty("serves")
  private String serves;
  
  /* 材料. */
  @JsonProperty("ingredients")
  private String ingredients;
  
  /* コスト. */
  @JsonProperty("cost")
  private String cost;

}

