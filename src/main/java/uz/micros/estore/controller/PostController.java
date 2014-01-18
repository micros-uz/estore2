package uz.micros.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.micros.estore.service.PostService;

@Controller
@RequestMapping("/blog/posts")
public class PostController {
    private final PostService service;

    @Autowired
    public PostController(PostService ps) {
        service = ps;
    }
}
