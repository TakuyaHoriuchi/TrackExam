package recipesystem.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipesystem.infrastructure.model.RecipeEntity;


@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer> {
}
