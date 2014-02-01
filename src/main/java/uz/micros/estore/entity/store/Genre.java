package uz.micros.estore.entity.store;

import uz.micros.estore.entity.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Genres")
public class Genre extends BaseEntity {

    @Column(name = "title", unique = true, nullable = false)
    private String title;
/*
    @OneToMany(mappedBy = "genre_id")
    private Set<Book> books;*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

/*    public Set<Book> getBooks() {
        return books;
    }*/
}
