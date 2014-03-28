package uz.micros.estore.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/cart")
@Scope("request")
public class ShoppingController {
    @Autowired
    private ShoppingCart cart;

    @RequestMapping("add/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public String addToCart(@PathVariable("id") int id)
    {
        return "OK";
    }
}
