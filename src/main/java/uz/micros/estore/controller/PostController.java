package uz.micros.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.estore.entity.blog.Post;
import uz.micros.estore.service.PostService;

@Controller
@RequestMapping("/blog/posts")
public class PostController {
    private final PostService service;

    @Autowired
    public PostController(PostService ps) {
        service = ps;
    }

    @RequestMapping(value = "create")
    public String create(ModelMap map){
        map.addAttribute("post", new Post());

        return "blog/editPost";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute(value = "post") Post post){
        service.save(post);

        return new ModelAndView("redirect:/blog");
    }

    @RequestMapping("/{id}/**")
    public ModelAndView get(@PathVariable("id") int id){
        Post post = service.get(id);

        return post != null
            ? new ModelAndView("blog/post").addObject("post", post)
            : new ModelAndView("redirect:/blog");//new ModelAndView("notFound");
    }

    @RequestMapping("/edit/{id}")
    public String edit(ModelMap map, @PathVariable("id") int id){

        Post post = service.get(id);

        if (post != null){
            map.addAttribute("post", post);
            return "blog/editPost";
        }else
            return "notFound";
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id){
        service.delete(id);

        return new ModelAndView("redirect:/blog");
    }
}
