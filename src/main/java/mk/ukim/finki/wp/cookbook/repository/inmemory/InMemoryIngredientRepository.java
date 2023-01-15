package mk.ukim.finki.wp.cookbook.repository.inmemory;

import mk.ukim.finki.wp.cookbook.bootstrap.DataHolder;
import mk.ukim.finki.wp.cookbook.model.Ingredient;
import mk.ukim.finki.wp.cookbook.repository.IngredientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryIngredientRepository implements IngredientRepository {
    @Override
    public List<Ingredient> getAllIngredients() {
        return DataHolder.ingredients;
    }
}
