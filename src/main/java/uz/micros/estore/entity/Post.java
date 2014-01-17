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

    @Column(name = "Title")
    private String title;

    @Column(name = "Text")
    private String text;

    @Column(name = "Date")
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
