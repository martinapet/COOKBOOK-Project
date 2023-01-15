package mk.ukim.finki.wp.cookbook.web.rest;

import mk.ukim.finki.wp.cookbook.model.Recipe;
import mk.ukim.finki.wp.cookbook.service.PairService;
import org.springframework.data.domain.Page;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/images", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class PairApi {
    PairService pairService;

    public PairApi(PairService pairService) {
        this.pairService = pairService;
    }

    @GetMapping
    public List<String> getAll() {
        return this.pairService.getAllImages();
    }
}
