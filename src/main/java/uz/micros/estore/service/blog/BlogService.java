package uz.micros.estore.service.blog;

import uz.micros.estore.entity.blog.Post;

import java.util.List;

public interface BlogService {
    List<Post> getAllPosts();
}
