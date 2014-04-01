package uz.micros.estore.service.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.micros.estore.entity.blog.Comment;
import uz.micros.estore.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void save(Comment comment) {
        commentRepository.saveAndFlush(comment);
    }
}
