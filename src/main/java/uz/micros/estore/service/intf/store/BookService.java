package uz.micros.estore.service.intf.store;

import uz.micros.estore.entity.store.Book;

import java.util.List;

public interface BookService {
    List<Book> getByGenre(int id);

    Book getById(int id);
}
