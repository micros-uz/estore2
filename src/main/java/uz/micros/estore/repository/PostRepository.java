package uz.micros.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.micros.estore.entity.blog.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
