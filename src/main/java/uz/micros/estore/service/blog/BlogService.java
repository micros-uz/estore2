package uz.micros.estore.service.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.micros.estore.entity.blog.Post;
import uz.micros.estore.repository.PostRepository;

import java.util.List;

@Service
public class BlogService  {

    @Autowired
    private PostRepository rpstr;

    @Transactional(readOnly = true)
    public List<Post> getAllPosts() {
        return rpstr.findAll();
    }
}
