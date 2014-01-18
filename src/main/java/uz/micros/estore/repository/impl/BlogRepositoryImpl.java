package uz.micros.estore.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.micros.estore.entity.Post;
import uz.micros.estore.repository.BlogRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository {

    @PersistenceContext
    private EntityManager entityManager;
/*    @Autowired
    public BlogRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }*/

    //private EntityManagerFactory factory;
    //private SessionFactory sessionFactory;

    @Override
    public List<Post> getPosts() {
        return entityManager.createQuery("from Post").getResultList();
        //return sessionFactory.getCurrentSession().createQuery("from Post").list();
        //EntityManagerFactory d = factory.getObject();
        //return d.createEntityManager().createQuery("from Post").getResultList();
    }

    //public void addPost(Post post){
        //sessionFactory.getCurrentSession().save(post);
    //}

    //public SessionFactory getSessionFactory() {
        //return sessionFactory;
    //}
}
