package uz.micros.estore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SigninController {

    @RequestMapping("/signin")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        @RequestParam(value = "signedup", required = false) String signedup) {
        //map.addAttribute()
        return "account/signin";
    }

}
