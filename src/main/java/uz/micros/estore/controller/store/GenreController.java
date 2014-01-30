package uz.micros.estore.controller.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.estore.entity.store.Genre;
import uz.micros.estore.service.store.GenreService;

import java.util.List;

@Controller
public class GenreController {

    @Autowired
    private GenreService service;


/*    @RequestMapping
    public ModelAndView getGenres(ModelMap model){
        List<Genre> genres = service.getGenres();

        model.addAttribute("genres", genres);

        return "blog/blog";
    }*/
}
