package uz.micros.estore.controller.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.micros.estore.entity.blog.Blog;
import uz.micros.estore.entity.blog.Post;
import uz.micros.estore.service.blog.BlogService;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    private final BlogService service;

    @Autowired
    public BlogController(BlogService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String blogIndex(ModelMap model) {
        Blog blog = new Blog();
        blog.setTitle("eStore corporative blog!");

        List<Post> posts = service.getAllPosts();

        for (Post post : posts)
            blog.addPost(post);

        model.addAttribute("blog", blog);

        return "blog/blog";
    }
}
