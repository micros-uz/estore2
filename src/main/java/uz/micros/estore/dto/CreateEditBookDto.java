package uz.micros.estore.dto;

import uz.micros.estore.entity.store.Author;
import uz.micros.estore.entity.store.Book;
import uz.micros.estore.entity.store.Genre;

import java.util.List;

public class CreateEditBookDto {
    private Book book;
    private List<Genre> genres;
    private List<Author> authors;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
