package uz.micros.estore.entity.store;

import uz.micros.estore.entity.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Genres")
public class Genre extends BaseEntity {

    @Column(name = "title", unique = true, nullable = false, columnDefinition = "varchar(25)")
    private String title;

    @Column(name = "descriptor", nullable = true, columnDefinition = "varchar(250)")
    private String desc;

    @OneToMany(mappedBy = "genre")
    private Set<Book> books;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
