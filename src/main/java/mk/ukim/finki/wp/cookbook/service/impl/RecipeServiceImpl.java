package mk.ukim.finki.wp.cookbook.service.impl;

import mk.ukim.finki.wp.cookbook.model.Image;
import mk.ukim.finki.wp.cookbook.model.Ingredient;
import mk.ukim.finki.wp.cookbook.model.Instruction;
import mk.ukim.finki.wp.cookbook.model.Recipe;
import mk.ukim.finki.wp.cookbook.model.exceptions.InvalidRecipeException;
import mk.ukim.finki.wp.cookbook.repository.jpa.ImageRepository;
import mk.ukim.finki.wp.cookbook.repository.jpa.IngredientRepository;
import mk.ukim.finki.wp.cookbook.repository.jpa.InstructionRepository;
import mk.ukim.finki.wp.cookbook.repository.jpa.RecipeRepository;
import mk.ukim.finki.wp.cookbook.service.RecipeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {
    RecipeRepository recipeRepository;
    ImageRepository imageRepository;
    IngredientRepository ingredientRepository;
    InstructionRepository instructionRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository, ImageRepository imageRepository, IngredientRepository ingredientRepository, InstructionRepository instructionRepository) {
        this.recipeRepository = recipeRepository;
        this.imageRepository = imageRepository;
        this.ingredientRepository = ingredientRepository;
        this.instructionRepository = instructionRepository;
    }

    @Override
    public List<Recipe> getAll() {
        return this.recipeRepository.findAll();
    }

    @Override
    public Page<Recipe> getAllPages(int page, int size) {
        return this.recipeRepository.findAll(PageRequest.of(page, size, Sort.by("title")));
    }

    @Override
    public Recipe createRecipe(String recipeId, String title, String recipeUrl, String recipePartition, List<Ingredient> ingredients, List<Instruction> instructions) {
        for(int i=0; i<ingredients.size(); i++)
            this.ingredientRepository.saveAndFlush(ingredients.get(i));
        for(int i=0; i<instructions.size(); i++)
            this.instructionRepository.saveAndFlush(instructions.get(i));
        List<Ingredient> pom1 = new ArrayList<>();
        pom1.add(ingredientRepository.findAll().get(0));
        List<Instruction> pom2 = new ArrayList<>();
        pom2.add(instructionRepository.findAll().get(0));
        return this.recipeRepository.saveAndFlush(new Recipe(recipeId, title, recipeUrl, recipePartition, pom1 , pom2));
    }


    @Override
    public Recipe upgradeRecipe(String id, String title, List<Ingredient> ingredients, List<Instruction> instructions) throws InvalidRecipeException {
        Recipe recipe = this.recipeRepository.findById(id).orElseThrow(InvalidRecipeException::new);
        recipe.setIngredients(ingredients);
        recipe.setTitle(title);
        recipe.setInstructions(instructions);
        return this.recipeRepository.save(recipe);
    }

    @Override
    public void deleteRecipe(String id) {
        this.recipeRepository.deleteById(id);
    }

    @Override
    public Recipe getRecipe(String id) throws InvalidRecipeException {
        return this.recipeRepository.findById(id).orElseThrow(InvalidRecipeException::new);
    }

    @Override
    public List<Ingredient> getRecipeIngredients(String id) throws InvalidRecipeException {
        Recipe recipe =  this.recipeRepository.findById(id).orElseThrow(InvalidRecipeException::new);
        return recipe.getIngredients();
    }

    @Override
    public List<Instruction> getRecipeInstructions(String id) throws InvalidRecipeException {
        Recipe recipe =  this.recipeRepository.findById(id).orElseThrow(InvalidRecipeException::new);
        return recipe.getInstructions();
    }

    @Override
    public String getImageUrl(String id) {
        Image image = imageRepository.findAll().stream().filter(img -> img.getRecipeId().equals(id + "")).findAny().orElse(null);
        return image.getImagePair().get(0).getImgUrl();
    }

    @Override
    public void save(List<Recipe> recipes) {
        this.recipeRepository.saveAll(recipes);
    }

    @Override
    public Page<Recipe> getSalty() {
        List<Recipe> result = this.recipeRepository.findAll().stream().filter(recipe -> !recipe.hasSugar() && !recipe.isFit()).collect(Collectors.toList());
        return new PageImpl<>(result);
    }

    @Override
    public Page<Recipe> getSweet() {
        List<Recipe> result = this.recipeRepository.findAll().stream().filter(Recipe::hasSugar).collect(Collectors.toList());
        return new PageImpl<>(result);
    }

    @Override
    public Page<Recipe> getFit() {
        List<Recipe> result = this.recipeRepository.findAll().stream().filter(Recipe::isFit).collect(Collectors.toList());
        return new PageImpl<>(result);

    }

    @Override
    public Page<Recipe> search(String title) {
        List<Recipe> result = this.recipeRepository.findAll().stream()
                .filter(recipe -> recipe.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
        return new PageImpl<>(result);
    }
}
