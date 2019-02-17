package recipesystem.domain.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import recipesystem.domain.repository.RecipeRepository;
import recipesystem.infrastructure.model.RecipeEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DeleteRecipeServiceImplTest {
  
  DeleteRecipeServiceImpl testTarget = new DeleteRecipeServiceImpl();
  
  @Autowired
  private TestEntityManager entityManager;
  
  @Autowired
  RecipeRepository recipeRepository;

  private RecipeEntity recipe1 = new RecipeEntity(null, "チキンカレー", "45分", "4人", "玉ねぎ,肉,スパイス", 1000);
  private RecipeEntity recipe2 = 
      new RecipeEntity(null, "トマトスープレシピ", "15分", "5人", "玉ねぎ, トマト, スパイス, 水油", 450);
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
  public void test_SuccessToReadRecipeFromId() {
    if (recipeRepository.count() != 3) {
      fail("Tableの初期化に失敗しました。");
    }
    Boolean actual = testTarget.delete(2);
    
    assertThat(actual, is(true));
//    assertThat(recipeRepository.count(), is(equalTo(2L)));
//    RecipeEntity secondEntity = entityManager.find(RecipeEntity.class, 2);
//    assertThat(secondEntity.getId(), is(equalTo(2)));
//    assertThat(secondEntity.getTitle(), is(equalTo("トマトスープ")));
//    assertThat(secondEntity.getMakingTime(), is(equalTo("15分")));
//    assertThat(secondEntity.getServes(), is(equalTo("5人")));
//    assertThat(secondEntity.getIngredients(), is(equalTo("玉ねぎ, トマト, スパイス, 水")));
//    assertThat(secondEntity.getCost(), is(450));
  }
  
  
}
