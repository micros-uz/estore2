package uz.micros.estore.repository.impl;

import org.springframework.stereotype.Repository;
import uz.micros.estore.entity.Post;
import uz.micros.estore.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PostRepositoryImpl implements PostRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Post get(int id) {
        return em.find(Post.class, id);
    }

    @Override
    public void save(Post post) {
        if (post.getPostId() == 0)
            em.persist(post);
        else
            em.merge(post);
        em.flush();
    }

    @Override
    public void remove(int id) {
        //Post p = em.find(Post.class, id);
        //if (p != null) em.remove(p);

        em.createQuery(
                "DELETE FROM Post c WHERE c.postId = :id").setParameter("id", id).executeUpdate();
    }
}
