package uz.micros.estore.service.impl.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.micros.estore.entity.store.Book;
import uz.micros.estore.repository.BookRepository;
import uz.micros.estore.service.intf.store.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository rpstr;

    @Override
    public List<Book> getByGenre(int id) {
        return null;
    }
}
