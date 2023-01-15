package mk.ukim.finki.wp.cookbook.repository;

import mk.ukim.finki.wp.cookbook.model.Ingredient;

import java.util.List;

public interface IngredientRepository {
    public List<Ingredient> getAllIngredients();
}
