package uz.micros.estore.entity;

import java.util.ArrayList;

public class Blog {
    private String title;
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
