package uz.micros.estore.service.intf.store;

import uz.micros.estore.entity.store.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();
}
