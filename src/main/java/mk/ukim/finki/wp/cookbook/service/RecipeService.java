package mk.ukim.finki.wp.cookbook.service;

import mk.ukim.finki.wp.cookbook.model.Ingredient;
import mk.ukim.finki.wp.cookbook.model.Instruction;
import mk.ukim.finki.wp.cookbook.model.Recipe;
import mk.ukim.finki.wp.cookbook.model.exceptions.InvalidRecipeException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAll();
    Page<Recipe> getAllPages(int page, int size);
    Recipe createRecipe(String recipeId, String title, String recipeUrl, String recipePartition, List<Ingredient> ingredients, List<Instruction> instructions);
    Recipe upgradeRecipe(String id, String title, List<Ingredient> ingredients, List<Instruction> instructions) throws InvalidRecipeException;
    void deleteRecipe(String id);
    Recipe getRecipe(String id) throws InvalidRecipeException;
    List<Ingredient> getRecipeIngredients(String id) throws InvalidRecipeException;
    List<Instruction> getRecipeInstructions(String id) throws InvalidRecipeException;
    String getImageUrl(String id);
    void save(List<Recipe> recipes);
    Page<Recipe> getSalty();
    Page<Recipe> getSweet();
    Page<Recipe> getFit();
    Page<Recipe> search(String title);
}
