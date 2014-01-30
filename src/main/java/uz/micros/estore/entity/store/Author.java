package uz.micros.estore.entity.store;


import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author /*extends BaseEntity*/ {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
