package uz.micros.estore.service.store;

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
    private FileService fileSvc;

    public List<Book> getByGenre(int id) {
        return rpstr.getByGenreId(id);
    }

    public Book getById(int id) {
        return rpstr.findOne(id);
    }

    public Book save(Book book, byte[] file) {
        Book res = rpstr.save(book);

        if (file != null){
            fileSvc.saveBookImage(res.getId(), file);
        }

        return res;
    }

    public void delete(int id){
        rpstr.delete(id);
    }

    public List<Book> getAll() {
        return rpstr.findAll();
    }

    public List<Book> search(String query) {
        return getAll();
    }
}
