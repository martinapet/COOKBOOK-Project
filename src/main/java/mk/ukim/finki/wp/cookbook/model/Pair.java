package mk.ukim.finki.wp.cookbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Pair {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long pairId;
    String imageName = "";
    String imgUrl = "";

    public Pair(String imageName, String imgUrl) {
        this.imgUrl = imgUrl;
        this.imageName = imageName;
    }
}

