package mk.ukim.finki.wp.cookbook.web.rest;

        import mk.ukim.finki.wp.cookbook.model.Ingredient;
        import mk.ukim.finki.wp.cookbook.model.Instruction;
        import mk.ukim.finki.wp.cookbook.model.Recipe;
        import mk.ukim.finki.wp.cookbook.service.IngredientService;
        import mk.ukim.finki.wp.cookbook.service.InstructionService;
        import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
        import org.springframework.http.HttpStatus;
        import org.springframework.util.MimeTypeUtils;
        import org.springframework.web.bind.WebDataBinder;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.util.UriComponentsBuilder;

        import javax.servlet.http.HttpServletResponse;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/instructions", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class InstructionsApi {
    private final InstructionService instructionService;

    public InstructionsApi(InstructionService instructionService) {
        this.instructionService = instructionService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(
                String[].class,
                new StringArrayPropertyEditor(null));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Instruction> createIngredients(@RequestParam(value = "instructions") String[] instructions) {
        List<String> list = Arrays.stream(instructions).collect(Collectors.toList());
        return this.instructionService.createInstructions(list);
    }
}
