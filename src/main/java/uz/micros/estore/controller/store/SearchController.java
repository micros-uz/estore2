package uz.micros.estore.controller.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.estore.entity.store.Book;
import uz.micros.estore.service.store.BookService;

import java.util.List;

@Controller
@RequestMapping("/store/search")
public class SearchController {

    @Autowired
    private BookService bookSvc;

    public ModelAndView go(@RequestParam("query") String query){
        List<Book> books = bookSvc.search(query);

        return new ModelAndView("store/books")
                .addObject("genreId", 1) // todo: should not use!
                .addObject("books", books);
    }
}
