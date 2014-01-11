package uz.micros.estore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.micros.estore.util.DbManager;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value="sql", method = RequestMethod.GET)
    public String sql(ModelMap model){
        String res = DbManager.connectToDb();

        model.addAttribute("res", res);

        return "adminSql";
    }
}
