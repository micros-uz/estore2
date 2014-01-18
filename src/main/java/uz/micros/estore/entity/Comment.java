package uz.micros.estore.entity;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @Column(name = "CommentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @Column(columnDefinition = "varchar(512)")
    private String text;

    @Column(columnDefinition = "date")
    private Date date;

    @Column(columnDefinition = "varchar(20)")
    private String author;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
