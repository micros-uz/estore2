package uz.micros.estore.entity.store;

import uz.micros.estore.entity.BaseEntity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Authors")
public class Author extends BaseEntity {

    public Author() {

    }

    @Column(name = "name", columnDefinition = "varchar(30)", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy="author")
    private Set<Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return name;
    }
}
