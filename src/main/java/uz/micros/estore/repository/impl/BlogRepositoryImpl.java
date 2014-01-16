package uz.micros.estore.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.micros.estore.entity.Post;
import uz.micros.estore.repository.BlogRepository;

import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Post> getPosts() {
        return sessionFactory.getCurrentSession().createQuery("from Post").list();
    }

    public void addPost(Post post){
        sessionFactory.getCurrentSession().save(post);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
