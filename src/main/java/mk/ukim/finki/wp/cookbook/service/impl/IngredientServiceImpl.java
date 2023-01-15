package mk.ukim.finki.wp.cookbook.service.impl;

import mk.ukim.finki.wp.cookbook.model.Ingredient;
import mk.ukim.finki.wp.cookbook.repository.jpa.IngredientRepository; // mora da e od datotekata jpa, isto se imenuvani
import mk.ukim.finki.wp.cookbook.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> listIngredients() {
        return this.ingredientRepository.findAll();
    }

    @Override
    public List<Ingredient> createIngredients(List<String> ingredients) {
        List<Ingredient> ingredientsList = new ArrayList<>();
        for(int i=0; i<ingredients.size(); i++)
            ingredientsList.add(new Ingredient(ingredients.get(i)));
        return this.ingredientRepository.saveAll(ingredientsList);
    }

    @Override
    public void deleteIngredient(Long id) {
        this.ingredientRepository.deleteById(id);
    }
}
