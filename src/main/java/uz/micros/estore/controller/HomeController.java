package uz.micros.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.micros.estore.entity.store.Genre;
import uz.micros.estore.service.intf.store.GenreService;

import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController{

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(Locale locale, ModelMap model) {
        model.addAttribute("message", "\u041f\u0440\u0438\u0432\u0435\u0442, магазин!");
        model.addAttribute("locale", locale.toString());
        Date curDate = new Date();
        model.addAttribute("curDate", curDate.toString());

        return "home";
    }
}