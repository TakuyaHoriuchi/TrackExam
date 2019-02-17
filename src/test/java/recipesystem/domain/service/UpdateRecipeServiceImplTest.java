package recipesystem.domain.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import recipesystem.domain.model.Recipe;
import recipesystem.domain.model.ResponseRecipe;
import recipesystem.domain.repository.RecipeRepository;
import recipesystem.infrastructure.model.RecipeEntity;

/**
 * {@link UpdateRecipeServiceImpl}のテスト.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UpdateRecipeServiceImplTest {
  
  UpdateRecipeServiceImpl testTarget = new UpdateRecipeServiceImpl();
  
  @Autowired
  private TestEntityManager entityManager;
  
  @Autowired
  RecipeRepository recipeRepository;

  private RecipeEntity recipe1 = new RecipeEntity(null, "チキンカレー", "45分", "4人", "玉ねぎ,肉,スパイス", 1000);
  private RecipeEntity recipe2 = new RecipeEntity(null, "オムライス", "30分", "2人", "玉ねぎ,卵,スパイス,醤油", 700);
  private RecipeEntity recipe3 = 
      new RecipeEntity(null, "トマトスープ", "15分", "5人", "玉ねぎ, トマト, スパイス, 水", 450);
  
  /** テスト実施前のセットアップ. */
  @Before   public void setup() {
    testTarget.recipeRepos = recipeRepository;
    entityManager.persist(recipe1);
    entityManager.persist(recipe2);
    entityManager.persist(recipe3);
  }
  
  @Test
  public void test_SuccessToUpdateRecipe() {
    if (recipeRepository.count() != 3) {
      fail("Tableの初期化に失敗しました。");
    }
    Recipe requestRecipe = createRequestRecipe();
    ResponseRecipe actual = testTarget.update(2, requestRecipe);
    ResponseRecipe expected = createExpectedRequestRecipe();
    
    assertThat(actual, is(samePropertyValuesAs(expected)));
    Optional<RecipeEntity> findResult = recipeRepository.findById(2);
    assertThat(findResult.isPresent(), is(equalTo(true)));
    RecipeEntity readEntity = findResult.get();
    assertThat(recipeRepository.count(), is(equalTo(3L)));
    assertThat(readEntity.getId(), is(equalTo(2)));
    assertThat(readEntity.getTitle(), is(equalTo("トマトスープレシピ")));
    assertThat(readEntity.getMakingTime(), is(equalTo("15分")));
    assertThat(readEntity.getServes(), is(equalTo("5人")));
    assertThat(readEntity.getIngredients(), is(equalTo("玉ねぎ, トマト, スパイス, 水")));
    assertThat(readEntity.getCost(), is(equalTo(450)));
    
  }

  private Recipe createRequestRecipe() {
    Recipe requestRecipe = new Recipe();
    requestRecipe.setTitle("トマトスープレシピ");
    requestRecipe.setMakingTime("15分");
    requestRecipe.setServes("5人");
    requestRecipe.setIngredients("玉ねぎ, トマト, スパイス, 水");
    requestRecipe.setCost(450);
    return requestRecipe;
  }
  
  private ResponseRecipe createExpectedRequestRecipe() {
    ResponseRecipe expectedRecipe = new ResponseRecipe();
    expectedRecipe.setTitle("トマトスープレシピ");
    expectedRecipe.setMakingTime("15分");
    expectedRecipe.setServes("5人");
    expectedRecipe.setIngredients("玉ねぎ, トマト, スパイス, 水");
    expectedRecipe.setCost("450");
    return expectedRecipe;
  }

}
