package uz.micros.estore.repository.impl;

import org.springframework.stereotype.Repository;
import uz.micros.estore.entity.AppUser;
import uz.micros.estore.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<AppUser> getUsers() {
        return em.createQuery("from AppUser").getResultList();
    }

    @Override
    public AppUser getUserByName(String name) {
        TypedQuery<AppUser> qry = em.createQuery("select u from AppUser u where u.name = ?1", AppUser.class);

        try {
            return qry.setParameter(1, name).getSingleResult();
        }
        catch(NoResultException ex)
        {
            return null;
        }
    }
}
