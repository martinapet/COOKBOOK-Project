package mk.ukim.finki.wp.cookbook.service.impl;

import mk.ukim.finki.wp.cookbook.model.Ingredient;
import mk.ukim.finki.wp.cookbook.model.Instruction;
import mk.ukim.finki.wp.cookbook.repository.jpa.InstructionRepository;
import mk.ukim.finki.wp.cookbook.service.InstructionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructionServiceImpl implements InstructionService {
    InstructionRepository instructionRepository;

    public InstructionServiceImpl(InstructionRepository instructionRepository) {
        this.instructionRepository = instructionRepository;
    }

    @Override
    public List<Instruction> listIngredients() {
        return this.instructionRepository.findAll();
    }

    @Override
    public List<Instruction> createInstructions(List<String> instructions) {
        List<Instruction> instructionsList = new ArrayList<>();
        for (String instruction : instructions)
            instructionsList.add(new Instruction(instruction));
        return this.instructionRepository.saveAll(instructionsList);
    }

    @Override
    public void deleteIngredient(Long id) {
        this.instructionRepository.deleteById(id);
    }
}
