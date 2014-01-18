package uz.micros.estore.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Posts")
public class Post {
    @Id
    @Column(name = "PostId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PostId;

    @Column(name = "Title", unique = true, columnDefinition = "varchar(50)")
    private String title;

    @Column(name = "Text", columnDefinition = "varchar(4096)")
    private String text;

    @Column(name = "Date", columnDefinition = "date")
    private Date date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
