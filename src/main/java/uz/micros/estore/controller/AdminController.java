package uz.micros.estore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.micros.estore.controller.viewmodels.ExecParams;
import uz.micros.estore.util.DbManager;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "sql", method = RequestMethod.GET)
    public String sql(ModelMap model) {
        String res = DbManager.connectToDb();

        model.addAttribute("res", res);

        return "admin/adminSql";
    }

    @RequestMapping(value = "exec", method = RequestMethod.GET)
    public String exec(ModelMap model) {
        ExecParams foo = new ExecParams();
        foo.setQuery("bar");

        model.addAttribute("ep", foo);

        return "admin/adminExec";
    }

    @RequestMapping(value = "exec", method = RequestMethod.POST)
    public String execPost(ModelMap model, @ModelAttribute(value="ep") ExecParams params) {
        model.addAttribute("header1", "fefe");
        ArrayList<String> data = new ArrayList<>();
        data.add(params.getQuery());
        data.add("fefe");
        model.addAttribute("data", data);

        return "admin/adminExec";
    }
}
