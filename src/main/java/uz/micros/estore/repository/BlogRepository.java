package uz.micros.estore.repository;

import uz.micros.estore.entity.Post;

import java.util.List;

public interface BlogRepository {
    public List<Post> getPosts();
}
