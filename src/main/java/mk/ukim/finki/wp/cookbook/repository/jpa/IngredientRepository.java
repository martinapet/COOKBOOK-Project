package mk.ukim.finki.wp.cookbook.repository.jpa;

import mk.ukim.finki.wp.cookbook.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
