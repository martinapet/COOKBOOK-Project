package mk.ukim.finki.wp.cookbook.service;

import mk.ukim.finki.wp.cookbook.model.Instruction;

import java.util.ArrayList;
import java.util.List;

public interface InstructionService {
    List<Instruction> listIngredients();
    List<Instruction> createInstructions(List<String> instructions);
    void deleteIngredient(Long id);
}
