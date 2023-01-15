package mk.ukim.finki.wp.cookbook.repository.inmemory;

import mk.ukim.finki.wp.cookbook.bootstrap.DataHolder;
import mk.ukim.finki.wp.cookbook.model.Recipe;
import mk.ukim.finki.wp.cookbook.repository.IngredientRepository;
import mk.ukim.finki.wp.cookbook.repository.RecipeRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class InMemoryRecipeRepository implements RecipeRepository {
    @Override
    public List<Recipe> getAllRecipes() {
        return DataHolder.recipes;
    }

}
