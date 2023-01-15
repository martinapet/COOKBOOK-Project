package mk.ukim.finki.wp.cookbook.service.impl;

import mk.ukim.finki.wp.cookbook.model.Image;
import mk.ukim.finki.wp.cookbook.model.Pair;
import mk.ukim.finki.wp.cookbook.model.exceptions.InvalidRecipeException;
import mk.ukim.finki.wp.cookbook.repository.jpa.ImageRepository;
import mk.ukim.finki.wp.cookbook.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public String getImageUrl(String recipe) {
        Image image = imageRepository.findAll().stream().filter(img -> img.getRecipeId().equals(recipe + "")).findAny().orElse(null);
        if(image == null)
            return "https:\\/\\/www.lovefood.com\\/images\\/content\\/body\\/plait1.jpg";
        return image.getImagePair().get(0).getImgUrl();
    }

    @Override
    public List<String> getAll() {
        List<Image> images = imageRepository.findAll();
        List<Pair> pairs = new ArrayList<>();
        for(Image i : images)
            pairs.addAll(i.getImagePair());
        List<String> result = new ArrayList<>();
        for(Pair p : pairs)
            result.add(p.getImgUrl());
        return result;
    }
}
