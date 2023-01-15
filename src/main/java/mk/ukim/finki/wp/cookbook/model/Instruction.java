package mk.ukim.finki.wp.cookbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Instruction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long instructionId;
    String instructionText;

    public Instruction(String text) {
        this.instructionText = text;
    }

    public String getText() {
        return instructionText;
    }
}
