package uz.micros.estore.service;

import uz.micros.estore.entity.blog.Post;

import java.util.List;

public interface BlogService {
    List<Post> getAllPosts();
}
