package mk.ukim.finki.wp.cookbook.repository;

import mk.ukim.finki.wp.cookbook.model.Recipe;

import java.util.List;

public interface RecipeRepository {
    public List<Recipe> getAllRecipes();
}
