package uz.micros.estore.entity.blog;

import uz.micros.estore.entity.AppUser;
import uz.micros.estore.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Comments")
public class Comment extends BaseEntity {

    @Column(columnDefinition = "varchar(512)", nullable = false)
    private String text;

    @Column(columnDefinition = "date", nullable = false)
    private Date date;

    @Column(name = "author_id", insertable = false, updatable = false)
    private int author_id;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private AppUser author;

    @Column(name = "post_id", insertable = false, updatable = false)
    private int post_id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public Comment() {
        text = "";
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public AppUser getAuthor() {
        return author;
    }

    public void setAuthor(AppUser author) {
        this.author = author;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }
}
