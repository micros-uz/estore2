package uz.micros.estore.repository;

import uz.micros.estore.entity.Post;

import java.util.List;

//@Repository
public interface BlogRepository{ //extends JpaRepository<Post, Long> {
    public List<Post> getPosts();
}
