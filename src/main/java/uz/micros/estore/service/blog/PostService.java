package uz.micros.estore.service.blog;

import uz.micros.estore.entity.blog.Post;

public interface PostService {
    Post get(int id);
    void save(Post post);
    void delete(int id);
}
