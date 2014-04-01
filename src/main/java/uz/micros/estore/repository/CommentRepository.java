package uz.micros.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.micros.estore.entity.blog.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
}
