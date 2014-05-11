package uz.micros.estore.service.store;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.micros.estore.entity.store.Book;
import uz.micros.estore.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository rpstr;

    @Autowired
    private FullTextEntityManager fullTextEntityManager;

    @Autowired
    private FileService fileSvc;

    public List<Book> getByGenre(int id) {
        return rpstr.getByGenreId(id);
    }

    public Book getById(int id) {
        return rpstr.findOne(id);
    }

    public Book save(Book book, byte[] file) {
        Book res = rpstr.save(book);

        if (file != null) {
            fileSvc.saveBookImage(res.getId(), file);
        }

        return res;
    }

    public void delete(int id) {
        rpstr.delete(id);
    }

    public List<Book> getAll() {
        return rpstr.findAll();
    }

    public List<Book> search(String query) {
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(Book.class).get();
        org.apache.lucene.search.Query qry = qb
                .keyword()
                .onFields("title", "desc")
                .matching(query)
                .createQuery();

        javax.persistence.Query persistenceQuery =
                fullTextEntityManager.createFullTextQuery(qry, Book.class);

        List result = persistenceQuery.getResultList();

        return (List<Book>)result;
    }
}
