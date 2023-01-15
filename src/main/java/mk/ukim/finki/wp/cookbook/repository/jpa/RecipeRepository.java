package mk.ukim.finki.wp.cookbook.repository.jpa;

import mk.ukim.finki.wp.cookbook.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {
}
