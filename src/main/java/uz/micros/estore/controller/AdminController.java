package uz.micros.estore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.micros.estore.controller.viewmodels.ExecParams;
import uz.micros.estore.util.DbManager;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "sql", method = RequestMethod.GET)
    public String sql(ModelMap model) {
        //Pair<String, Connection> res = DbManager.connectToDb();

       // model.addAttribute("res", res.getKey());

        return "admin/adminSql";
    }

    @RequestMapping(value = "exec", method = RequestMethod.GET)
    public String exec(ModelMap model) {
        ExecParams foo = new ExecParams();
        foo.setQuery("select * from Posts");

        model.addAttribute("ep", foo);

        return "admin/adminExec";
    }

    @RequestMapping(value = "exec", method = RequestMethod.POST)
    public String execPost(ModelMap model, @ModelAttribute(value="ep") ExecParams params) {
        model.addAttribute("header1", "fefe");

        List<Map<String, Object>> res = DbManager.runQuery(params.getQuery());

        ExecParams ep = new ExecParams();
        ep.setErr("NO");

        if (res.size() > 0)
            ep.setResult(res);

        model.addAttribute("ep", ep);

        return "admin/adminExec";
    }
}
