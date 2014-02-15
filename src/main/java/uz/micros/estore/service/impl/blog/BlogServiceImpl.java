package uz.micros.estore.service.impl.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.micros.estore.entity.blog.Post;
import uz.micros.estore.repository.PostRepository;
import uz.micros.estore.service.intf.blog.blog.BlogService;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private PostRepository rpstr;

    @Override
    @Transactional(readOnly = true)
    public List<Post> getAllPosts() {
        return rpstr.findAll();
    }
}
