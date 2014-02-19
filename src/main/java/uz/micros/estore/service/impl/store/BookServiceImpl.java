package uz.micros.estore.service.impl.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.micros.estore.entity.store.Book;
import uz.micros.estore.repository.BookRepository;
import uz.micros.estore.service.intf.store.BookService;
import uz.micros.estore.service.intf.store.FileService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository rpstr;

    @Autowired
    private FileService fileSvc;

    @Override
    public List<Book> getByGenre(int id) {
        return rpstr.getByGenreId(id);
    }

    @Override
    public Book getById(int id) {
        return rpstr.findOne(id);
    }

    @Override
    public Book save(Book book, byte[] file) {
        Book res = rpstr.save(book);

        if (file != null){
            fileSvc.saveBookImage(res.getId(), file);
        }

        return res;
    }

    @Override
    public void delete(int id){
        rpstr.delete(id);
    }
}
