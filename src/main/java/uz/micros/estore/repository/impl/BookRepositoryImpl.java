package uz.micros.estore.repository.impl;

import org.springframework.stereotype.Repository;
import uz.micros.estore.entity.store.Book;
import uz.micros.estore.repository.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> getByGenreId(int id) {
        return em.createQuery("SELECT b FROM Book b WHERE b.genreId = :id")
                .setParameter("id", id)
                .getResultList();
    }
}
