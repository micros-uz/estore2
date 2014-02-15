package uz.micros.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.micros.estore.entity.store.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

}
