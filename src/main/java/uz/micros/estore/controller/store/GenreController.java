package uz.micros.estore.controller.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.estore.controller.BaseController;
import uz.micros.estore.entity.store.Author;
import uz.micros.estore.entity.store.Book;
import uz.micros.estore.entity.store.Genre;
import uz.micros.estore.service.intf.store.BookService;
import uz.micros.estore.service.intf.store.GenreService;

import java.util.List;

@Controller
@RequestMapping("/store/genres")
public class GenreController extends BaseController{

    @Autowired
    private BookService bookSvc;

    @RequestMapping("/{id}/**")
    public ModelAndView getBooks(@PathVariable(value = "id") int id){

        List<Book> books = bookSvc.getByGenre(id);

        return new ModelAndView("store/books")
                .addObject("books", books);
    }
}
