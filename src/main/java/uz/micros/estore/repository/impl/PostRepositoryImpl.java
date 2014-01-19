package uz.micros.estore.repository.impl;

import org.springframework.stereotype.Repository;
import uz.micros.estore.entity.Post;
import uz.micros.estore.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PostRepositoryImpl implements PostRepository {

    @PersistenceContext
    private EntityManager emf;

    @Override
    public Post get(int id) {
        return emf.find(Post.class, id);
    }

    @Override
    public void save(Post post) {
        if (post.getPostId() == 0)
            emf.persist(post);
        else
            emf.merge(post);
        emf.flush();
    }

    @Override
    public void remove(int id) {
        //Post p = emf.find(Post.class, id);
        //if (p != null) emf.remove(p);

        emf.createQuery(
                "DELETE FROM Post c WHERE c.postId = :id").setParameter("id", id).executeUpdate();
    }
}
