package uz.micros.estore.entity.blog;

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

    @Column(columnDefinition = "varchar(20)", nullable = false)
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
