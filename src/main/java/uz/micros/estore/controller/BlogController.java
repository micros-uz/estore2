package uz.micros.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.micros.estore.entity.Blog;
import uz.micros.estore.entity.Post;
import uz.micros.estore.service.BlogService;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/blog")
public class BlogController {

    //private final BlogService service;

    //@Autowired
    public BlogController(/*BlogService service*/) {
        //this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String blogIndex(ModelMap model) {
        Blog blog = new Blog();
        blog.setTitle("eStore corporative Blog!");

        for(int k = 0; k < 4;k++){
            Post p = new Post();
            p.setTitle("Post " + k);
            p.setText("Jan 09, 2014 7:52:17 PM org.springframework.web.context.support.AnnotationConfigWebApplicationContext loadBeanDefinitions\n" +
                    "INFO: Registering annotated classes: [class uz.micros.estore.config.DispatcherConfig]\n" +
                    "Jan 09, 2014 7:52:17 PM org.springframework.web.servlet.FrameworkServlet initServletBean\n" +
                    "INFO: FrameworkServlet 'dispatcher': initialization completed in 99 ms\n" +
                    "[2014-01-09 07:52:18,164] Artifa");
            blog.addPost(p);
        }

        model.addAttribute("blog", blog);

        return "blog";

    }
}
