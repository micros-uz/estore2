package uz.micros.estore.repository;

import uz.micros.estore.entity.store.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getByGenreId(int id);
}