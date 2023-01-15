package mk.ukim.finki.wp.cookbook.repository;

import mk.ukim.finki.wp.cookbook.model.Instruction;

import java.util.List;

public interface InstructionRepository {
    List<Instruction> getAllInstructions();
}
