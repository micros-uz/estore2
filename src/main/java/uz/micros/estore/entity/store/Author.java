package uz.micros.estore.entity.store;

import uz.micros.estore.entity.BaseEntity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

    public Author() {

    }

    @Column(name = "name", unique = true, nullable = false)
    private String name;

/*    @OneToMany(mappedBy="author_id")
    private Set<Book> books;*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*    public Set<Book> getBooks() {
        return books;
    }*/
}
