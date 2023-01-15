package mk.ukim.finki.wp.cookbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

//{"id":"000075604a",
// "images":[{"id":"6bdca6e490.jpg",
// "url":"https:\/\/img-global.cpcdn.com\/001_recipes\/5806945844854784\/0x0\/photo.jpg"}]},
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long imageId;
    String recipeId = "";
    @ManyToMany(fetch = FetchType.LAZY)
    List<Pair> imagePair;

    public Image(String recipeId, List<Pair> imagePair) {
        this.recipeId = recipeId;
        this.imagePair = imagePair;
    }
}
