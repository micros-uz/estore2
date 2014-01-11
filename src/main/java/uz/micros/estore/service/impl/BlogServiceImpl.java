package uz.micros.estore.service.impl;

import org.springframework.stereotype.Service;
import uz.micros.estore.entity.Post;
import uz.micros.estore.service.BlogService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Override
    public List<Post> getAllPosts() {
        List<Post> res = new ArrayList<>();

        for (int k = 0; k < 4; k++) {
            Post p = new Post();
            p.setTitle("Post " + k);
            p.setText("Jan 09, 2014 7:52:17 PM org.springframework.web.context.support.AnnotationConfigWebApplicationContext loadBeanDefinitions\n" +
                    "INFO: Registering annotated classes: [class uz.micros.estore.config.DispatcherConfig]\n" +
                    "Jan 09, 2014 7:52:17 PM org.springframework.web.servlet.FrameworkServlet initServletBean\n" +
                    "INFO: FrameworkServlet 'dispatcher': initialization completed in 99 ms\n" +
                    "[2014-01-09 07:52:18,164] Artifa");
            res.add(p);
        }

        return res;
    }
}
