package recipesystem.application.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecipeInfoResponse {
  @JsonProperty("message")
  private String message;
  @JsonProperty("required")
  private String required;
  @JsonProperty("recipe")
  private List<Recipe> recipe;
  
}