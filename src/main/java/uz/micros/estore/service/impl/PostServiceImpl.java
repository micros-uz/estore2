package uz.micros.estore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import uz.micros.estore.entity.Post;
import uz.micros.estore.repository.PostRepository;
import uz.micros.estore.service.PostService;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository repository;

    @Autowired
    public PostServiceImpl(PostRepository rpstr) {
        repository = rpstr;
    }

    @Override
    public Post get(int id) {
        return repository.get(id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(Post post) {
        repository.save(post);
    }

    @Override
    public void delete(int id) {
        repository.remove(id);
    }
}
