package uz.micros.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.estore.entity.Post;
import uz.micros.estore.service.PostService;

import java.util.Date;

@Controller
@RequestMapping("/blog/posts")
public class PostController {
    private final PostService service;

    @Autowired
    public PostController(PostService ps) {
        service = ps;
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(ModelMap map){

        Post p = new Post();

        map.addAttribute("post", p);

        return "blog/createPost";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute(value = "post") Post post){
        service.save(post);

        return new ModelAndView("redirect:/blog");
    }
}
