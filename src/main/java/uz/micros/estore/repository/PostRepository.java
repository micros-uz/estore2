package uz.micros.estore.repository;

import uz.micros.estore.entity.Post;

public interface PostRepository {
    Post get(int id);
    void save(Post post);
    void remove(int id);
}
