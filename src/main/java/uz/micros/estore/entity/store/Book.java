package uz.micros.estore.entity.store;

import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Book /*extends BaseEntity*/{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
	private String title;

/*    @ManyToOne
    @JoinColumn(name = "author_id")
	private Author author;*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

/*    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }*/
}
