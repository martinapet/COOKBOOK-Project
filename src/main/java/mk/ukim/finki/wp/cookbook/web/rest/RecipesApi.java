package mk.ukim.finki.wp.cookbook.web.rest;

import mk.ukim.finki.wp.cookbook.bootstrap.DataHolder;
import mk.ukim.finki.wp.cookbook.model.Image;
import mk.ukim.finki.wp.cookbook.model.Ingredient;
import mk.ukim.finki.wp.cookbook.model.Instruction;
import mk.ukim.finki.wp.cookbook.model.Recipe;
import mk.ukim.finki.wp.cookbook.model.exceptions.InvalidRecipeException;
import mk.ukim.finki.wp.cookbook.repository.jpa.ImageRepository;
import mk.ukim.finki.wp.cookbook.service.ImageService;
import mk.ukim.finki.wp.cookbook.service.RecipeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/recipes", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class RecipesApi {
    RecipeService recipeService;

    public RecipesApi(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public Page<Recipe> getAllRecipes(@RequestHeader(name = "page", defaultValue = "0", required = false) int page,
                                      @RequestHeader(name = "page-size", defaultValue = "20", required = false) int size) {
        return this.recipeService.getAllPages(page, size);
    }

    @GetMapping("/{id}/image")
    public String getImage(@PathVariable String id){
        return this.recipeService.getImageUrl(id);
    }

    @GetMapping("/{id}/ingredients")
    public List<Ingredient> getIngredients(@PathVariable String id) throws InvalidRecipeException {
        return recipeService.getRecipeIngredients(id);
    }

    @GetMapping("/{id}/instructions")
    public List<Instruction> getInstructions(@PathVariable String id) throws InvalidRecipeException {
        return recipeService.getRecipeInstructions(id);
    }

    @GetMapping("/salty")
    public Page<Recipe> getSalty() {
        return recipeService.getSalty();
    }

    @GetMapping("/sweet")
    public Page<Recipe> getSweet() {
        return recipeService.getSweet();
    }

    @GetMapping("/fit")
    public Page<Recipe> getFit() {
        return recipeService.getFit();
    }

    @GetMapping(params = "title")
    public Page<Recipe> searchRecipe(@RequestParam String title) {
        return recipeService.search(title);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Recipe createRecipe(@RequestHeader String recipeId,
                               @RequestParam("title") String title,
                               @RequestParam("recipeUrl") String recipeUrl,
                               @RequestParam("recipePartition") String recipePartition,
                               @RequestParam(name = "ingredients") String[] ingredients,
                               @RequestParam(name = "instructions") String[] instructions) {
        ArrayList<Instruction> ins = null;
        for(int i=0; i<instructions.length; i++) {
            ins.add(new Instruction(instructions[i]));
        }

        ArrayList<Ingredient> ing = null;
        for(int i=0; i<ingredients.length; i++) {
            ing.add(new Ingredient(ingredients[i]));
        }
        return this.recipeService.createRecipe(recipeId, title, recipeUrl, recipePartition, ing, ins);
    }

    @PatchMapping("/{id}")
    public Recipe upgradeRecipe(@PathVariable String id,
                                @RequestParam("title") String title,
                                @RequestParam("ingredients") List<Ingredient> ingredients,
                                @RequestParam(name = "instructions") List<Instruction> instructions) throws InvalidRecipeException {
        return this.recipeService.upgradeRecipe(id, title, ingredients, instructions);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable String id){
        this.recipeService.deleteRecipe(id);
    }

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable String id) throws InvalidRecipeException {
        return this.recipeService.getRecipe(id);
    }

}



















