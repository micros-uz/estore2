package uz.micros.estore.service.impl.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.micros.estore.entity.blog.Post;
import uz.micros.estore.repository.BlogRepository;
import uz.micros.estore.service.blog.BlogService;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private BlogRepository repository;

    @Autowired
    public BlogServiceImpl(BlogRepository rpstr) {
        repository = rpstr;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> getAllPosts() {
        return repository.getPosts();
    }
}
