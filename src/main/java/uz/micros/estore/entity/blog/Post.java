package uz.micros.estore.entity.blog;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Posts")
public class Post {
    @Id
    @Column(name = "postId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @Column(name = "Title", unique = true, columnDefinition = "varchar(50)")
    private String title;

    @Column(name = "Text", columnDefinition = "varchar(4096)")
    private String text;

    @Column(name = "Date", columnDefinition = "date")
    private Date date;

    public String getShortText(){
        return text != null && text.length() > 0
                ? (text.length() > 300 ? text.substring(0, 299) + "..." : text)
                : "";
    }

    public Post() {
        title = "";
        text = "";
    }

    public int getPostId(){
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

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
