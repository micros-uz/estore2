package uz.micros.estore.service;

import uz.micros.estore.entity.Post;

public interface PostService {
    Post get(int id);
    void save(Post post);
    void delete(int id);
}
