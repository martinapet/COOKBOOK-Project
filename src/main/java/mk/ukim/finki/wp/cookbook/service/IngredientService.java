package mk.ukim.finki.wp.cookbook.service;

import mk.ukim.finki.wp.cookbook.model.Ingredient;

import java.util.ArrayList;
import java.util.List;

public interface IngredientService {
    List<Ingredient> listIngredients();
    List<Ingredient> createIngredients(List<String> ingredients);
    void deleteIngredient(Long id);
}
