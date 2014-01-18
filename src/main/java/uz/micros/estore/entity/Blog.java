package uz.micros.estore.entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Blogs")
public class Blog {
    @Id
    @Column(name = "BlogId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BlogId;

    @Column(name = "Title", unique = true, columnDefinition = "varchar(50)")
    private String title;

    @Transient
    private ArrayList<Post> posts;

    public Blog() {
        posts = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post){
        posts.add(post);
    }

}
