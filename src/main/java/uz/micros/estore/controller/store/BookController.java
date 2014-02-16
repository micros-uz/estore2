package uz.micros.estore.controller.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.estore.controller.BaseController;
import uz.micros.estore.dto.CreateEditBookDto;
import uz.micros.estore.entity.store.Book;
import uz.micros.estore.service.intf.store.AuthorService;
import uz.micros.estore.service.intf.store.BookService;
import uz.micros.estore.service.intf.store.GenreService;

@Controller
@RequestMapping("/store/books")
public class BookController extends BaseController {

    @Autowired
    private BookService bookSvc;

    @Autowired
    private AuthorService authorSvc;

    @Autowired
    private GenreService genreSvc;

    @RequestMapping("/{id}/**")
    public ModelAndView details(@PathVariable(value = "id") int id){

        Book book = bookSvc.getById(id);

        if (book != null)
            return new ModelAndView("store/details")
                    .addObject("book", book);
        else
            return new ModelAndView("notFound");
    }

    @RequestMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("store/createEditBook")
                .addObject("book", new Book())
                .addObject("genres", getGenres())
                .addObject("authors", authorSvc.getAuthors());
    }

    @RequestMapping("/edit/{id}/**")
    public ModelAndView edit(@PathVariable(value = "id") int id){
        Book book = bookSvc.getById(id);

        if (book != null){
            return new ModelAndView("store/createEditBook")
                    .addObject("book", book)
                    .addObject("genres", getGenres())
                    .addObject("authors", authorSvc.getAuthors())
                    .addObject("useSideBar", false);
        }
        else
            return new ModelAndView("notFound");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute(value = "book") Book book){

        bookSvc.save(book);

        return new ModelAndView("store/createEditBook")
                .addObject("book", new Book());
    }
}
