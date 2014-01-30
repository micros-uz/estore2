package uz.micros.estore.entity.store;

import javax.persistence.*;

@Entity
@Table(name = "Genres")
public class Genre/* extends BaseEntity*/ {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
