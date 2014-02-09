package uz.micros.estore.controller.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.estore.controller.BaseController;
import uz.micros.estore.entity.store.Book;
import uz.micros.estore.service.intf.store.BookService;
import uz.micros.estore.service.intf.store.GenreService;

@Controller
@RequestMapping("/store/books")
public class BookController extends BaseController {

    @Autowired
    private BookService bookSvc;

    @RequestMapping("/{id}/**")
    public ModelAndView details(@PathVariable(value = "id") int id){

        Book book = bookSvc.getById(id);

        if (book != null)
            return new ModelAndView("store/details")
                    .addObject("book", book);
        else
            return new ModelAndView("notFound");
    }
}
