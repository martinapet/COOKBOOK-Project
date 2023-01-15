package mk.ukim.finki.wp.cookbook.repository.inmemory;

import mk.ukim.finki.wp.cookbook.bootstrap.DataHolder;
import mk.ukim.finki.wp.cookbook.model.Instruction;
import mk.ukim.finki.wp.cookbook.repository.InstructionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryInstructionRepository implements InstructionRepository {
    @Override
    public List<Instruction> getAllInstructions() {
        return DataHolder.instructions;
    }
}
