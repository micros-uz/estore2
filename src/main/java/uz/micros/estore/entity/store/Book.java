package uz.micros.estore.entity.store;

import uz.micros.estore.entity.BaseEntity;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Books")
public class Book extends BaseEntity {
    public Book() {
    }

    @Column(name = "title", columnDefinition = "varchar(200)", nullable = false, unique = true)
    private String title;

    @Column(name = "author_id", insertable = false, updatable = false)
    private int author_id;

    @Column(name = "genre_id", insertable = false, updatable = false)
    private int genre_id;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name="series_id", nullable = true)
    private Series series;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "year", nullable = false)
    private short year;

    @Column(name = "pages", nullable = false)
    private short pages;

    @Column(name = "isbn", nullable = false, columnDefinition = "varchar(20)")
    private String isbn;

    @Column(name = "description", nullable = false, columnDefinition = "varchar(3072)")
    private String desc;

    @Column(name = "imageFile")
    @org.hibernate.annotations.Type(type="pg-uuid")
    private UUID imageFile;

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

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public short getPages() {
        return pages;
    }

    public void setPages(short pages) {
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String shortTitle(){
        return title.length() <= 40 ? title
                : title.substring(0, 39);
    }
}
