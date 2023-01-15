package mk.ukim.finki.wp.cookbook.service;

import mk.ukim.finki.wp.cookbook.model.exceptions.InvalidRecipeException;

import java.util.List;

public interface ImageService {
    String getImageUrl(String recipe);
    List<String> getAll();
}
