package mk.ukim.finki.wp.cookbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long ingredientId;
    String ingredientText;

    public Ingredient(String text) {
        this.ingredientText = text;
    }

    public String getText() {
        return ingredientText;
    }
}
