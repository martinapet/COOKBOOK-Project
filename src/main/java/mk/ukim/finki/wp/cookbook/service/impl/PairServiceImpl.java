package mk.ukim.finki.wp.cookbook.service.impl;

import mk.ukim.finki.wp.cookbook.model.Pair;
import mk.ukim.finki.wp.cookbook.repository.jpa.*;
import mk.ukim.finki.wp.cookbook.service.PairService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PairServiceImpl implements PairService {
    PairRepository pairRepository;

    public PairServiceImpl(PairRepository pairRepository) {
        this.pairRepository = pairRepository;
    }

    @Override
    public List<String> getAllImages() {
        List<Pair> pair = pairRepository.findAll();
        List<String> result = new ArrayList<>();
        for(Pair p : pair)
            result.add(p.getImgUrl());
        return result;
    }
}
