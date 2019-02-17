package recipesystem.application.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import recipesystem.domain.model.Recipe;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecipesInfoResponse {
  @JsonProperty("message")
  private String message;
  @JsonProperty("recipes")
  private List<Recipe> recipes;
}
