package uz.micros.estore.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.micros.estore.entity.Post;
import uz.micros.estore.repository.PostRepository;

import javax.persistence.EntityManagerFactory;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public PostRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Post get(int id) {
        return null;
    }

    @Override
    public void save(Post post) {
        entityManagerFactory.createEntityManager().persist(post);
        entityManagerFactory.createEntityManager().flush();
    }

    @Override
    public void remove(int id) {
        //entityManagerFactory.createEntityManager().
        //entityManagerFactory.createEntityManager().remove(post);
    }
}
