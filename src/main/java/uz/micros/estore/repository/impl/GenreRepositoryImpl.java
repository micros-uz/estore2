package uz.micros.estore.repository.impl;

import org.springframework.stereotype.Repository;
import uz.micros.estore.entity.store.Genre;
import uz.micros.estore.repository.GenreRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GenreRepositoryImpl implements GenreRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Genre> getGenres() {
        return em.createQuery("from Genre").getResultList();
    }
}
