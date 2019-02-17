package recipesystem.domain.service;

/**
 * {@link:DeleteRecipeService}のStub実装クラス.
 * 実装後に削除する.
 */
//@Component
public class DeleteRecipeServiceMock implements DeleteRecipeService {

  @Override
  public Boolean delete(Integer id) {
    return (id < 5);
  }

}
