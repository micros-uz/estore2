package uz.micros.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.estore.dto.RegUserDto;
import uz.micros.estore.entity.AppUser;
import uz.micros.estore.service.intf.UserService;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error,
                        @RequestParam(value="logout", required = false) String logout,
                        @RequestParam(value="registered", required = false) String registered) {
        //map.addAttribute()
        return "account/logon";
    }

    @RequestMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("account/register")
                .addObject("newUser", new RegUserDto());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(@ModelAttribute("newUser") RegUserDto dto,
                               BindingResult result, Locale locale,
                               HttpSession session
    ) {
        if (dto.getPassword().equals(dto.getPassword2())) {
            service.addUser(new AppUser(dto.getUsername(),
                    dto.getPassword(), dto.getEmail(), AppUser.ROLE_USER));

            return "redirect:/login?registered";
        }
        else
            return "redirect:/register";
    }
}
