package recipesystem.application.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import recipesystem.domain.model.ResponseRecipe;

/**
 * レシピのレスポンスクラス.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecipeInfoResponse {
  /* メッセージ. */
  @JsonProperty("message")
  private String message;
  
  /* 必須パラメータ文言. */
  @JsonProperty("required")
  private String required;
  
  /* レシピ. */
  @JsonProperty("recipe")
  private List<ResponseRecipe> recipe;
  
}