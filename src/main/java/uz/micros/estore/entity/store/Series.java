package uz.micros.estore.entity.store;

import uz.micros.estore.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "Series")
public class Series extends BaseEntity {

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "descriptor")
    private String desc;

    @ManyToOne()
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Column(name = "genre_id", insertable = false, updatable = false)
    private int genre_id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
