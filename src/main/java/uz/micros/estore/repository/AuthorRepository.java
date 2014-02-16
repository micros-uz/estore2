package uz.micros.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.micros.estore.entity.store.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
