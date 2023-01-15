package mk.ukim.finki.wp.cookbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.ManyToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Recipe {
    @Id
    String recipeId;
    String title;
    String recipeUrl;
    String recipePartition;
    @ManyToMany(fetch = FetchType.LAZY)
    List<Ingredient> ingredients;
    @ManyToMany(fetch = FetchType.LAZY)
    List<Instruction> instructions;

    //private static long identity = -1;

    public Recipe(String title, List<Ingredient> ingredients, List<Instruction> instructions) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        Helper.setIdentity(Helper.identity++);
        this.recipeId = Helper.identity + "";
    }

    public boolean hasSugar() {
        for(int i=0; i<ingredients.size(); i++) {
            if(ingredients.get(i).ingredientText.contains("Sugar")
            || ingredients.get(i).ingredientText.contains("sugar"))
                return true;
        }
        return false;
    }

    public boolean isFit() {
        for(int i=0; i<ingredients.size(); i++) {
            if(ingredients.get(i).ingredientText.contains("Brown Sugar")
                    || ingredients.get(i).ingredientText.contains("brown sugar")
                    || ingredients.get(i).ingredientText.contains("Yogurt")
                    || ingredients.get(i).ingredientText.contains("Stevia"))
                return true;
        }
        return false;
    }
}

class Helper {
    public static long identity;

    public static void setIdentity(long identity) {
        Helper.identity = identity;
    }
}