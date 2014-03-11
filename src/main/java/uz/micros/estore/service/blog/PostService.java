package uz.micros.estore.service.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import uz.micros.estore.entity.blog.Post;
import uz.micros.estore.repository.PostRepository;

import java.util.Date;

@Service
//@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class PostService{

    private final PostRepository repository;

    @Autowired
    public PostService(PostRepository rpstr) {
        repository = rpstr;
    }

    @Transactional(readOnly = true)
    public Post get(int id) {
        return repository.findOne(id);
    }
//http://piotrnowicki.com/2012/11/types-of-entitymanagers-application-managed-entitymanager/

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(Post post) {
        post.setDate(new Date());
        repository.saveAndFlush(post);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(int id) {
        repository.delete(id);
    }
}
