package mk.ukim.finki.wp.cookbook.web.rest;

import mk.ukim.finki.wp.cookbook.model.Ingredient;
import mk.ukim.finki.wp.cookbook.model.Instruction;
import mk.ukim.finki.wp.cookbook.model.Recipe;
import mk.ukim.finki.wp.cookbook.service.IngredientService;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/ingredients", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class IngredientsApi {
    private final IngredientService ingredientService;

    public IngredientsApi(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(
                String[].class,
                new StringArrayPropertyEditor(null));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Ingredient> createIngredients(@RequestParam(value = "ingredients") String[] ingredients) {
        List<String> list = Arrays.stream(ingredients).collect(Collectors.toList());
        return this.ingredientService.createIngredients(list);
    }
}
