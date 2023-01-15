package mk.ukim.finki.wp.cookbook.repository.jpa;

import mk.ukim.finki.wp.cookbook.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
}
