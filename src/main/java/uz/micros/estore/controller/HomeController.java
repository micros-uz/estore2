package uz.micros.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.micros.estore.service.store.GenreService;

import java.util.Date;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private GenreService service;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hi,OUR NEW eStore!");
        Date curDate = new Date();
        model.addAttribute("curDate", curDate.toString());

        model.addAttribute("genres", service.getGenres());

        return "home";
    }
}