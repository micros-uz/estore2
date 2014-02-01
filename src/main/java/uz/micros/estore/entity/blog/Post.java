package uz.micros.estore.entity.blog;

import uz.micros.estore.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Posts")
public class Post extends BaseEntity {

    @Column(name = "Title", unique = true, columnDefinition = "varchar(50)", nullable = false)
    private String title;

    @Column(name = "Text", columnDefinition = "varchar(4096)", nullable = false)
    private String text;

    @Column(name = "Date", columnDefinition = "date", nullable = false)
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
