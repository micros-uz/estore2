package uz.micros.estore.entity.store;

import uz.micros.estore.entity.BaseEntity;
import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Book extends BaseEntity {
    public Book() {
    }

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "author_id", insertable = false, updatable = false)
    private int author_id;

    @Column(name = "genre_id", insertable = false, updatable = false)
    private int genre_id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
