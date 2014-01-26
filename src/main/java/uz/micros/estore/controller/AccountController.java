package uz.micros.estore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.estore.dto.RegUserDto;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class AccountController {
    @RequestMapping("/login")
    public String login(ModelMap map) {
        return "account/logon";
    }

    @RequestMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("account/register")
                .addObject("newUser", new RegUserDto());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(@ModelAttribute("newUser")RegUserDto dto,
                               BindingResult result, Locale locale,
                               HttpSession session
    ){
        return "redirect:/login?registered";
    }
}
