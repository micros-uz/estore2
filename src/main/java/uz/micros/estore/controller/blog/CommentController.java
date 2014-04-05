package uz.micros.estore.controller.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.estore.entity.AppUser;
import uz.micros.estore.entity.blog.Comment;
import uz.micros.estore.service.UserService;
import uz.micros.estore.service.blog.CommentService;

import java.util.Date;

@Controller
@RequestMapping("/blog/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute(value = "post") Comment comment){
        comment.setDate(new Date());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        AppUser appUser = userService.getUserByUserName(userName);
        comment.setAuthor(appUser);

        commentService.save(comment);

        return new ModelAndView("redirect:/blog/posts/" + comment.getPost().getId());
    }
}
