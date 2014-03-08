package uz.micros.estore.controller.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.estore.controller.BaseController;
import uz.micros.estore.entity.store.Book;
import uz.micros.estore.service.intf.store.AuthorService;
import uz.micros.estore.service.intf.store.BookService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/store/books")
public class BookController extends BaseController {

    @Autowired
    private BookService bookSvc;

    @Autowired
    private AuthorService authorSvc;

    @RequestMapping("/{id}/**")
    public ModelAndView details(@PathVariable(value = "id") int id) {

        Book book = bookSvc.getById(id);

        if (book != null)
            return new ModelAndView("store/details")
                    .addObject("book", book);
        else
            return new ModelAndView("notFound");
    }

    @RequestMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("store/createEditBook")
                .addObject("book", new Book())
                .addObject("genres", getGenres())
                .addObject("authors", authorSvc.getAuthors());
    }

    @RequestMapping("/edit/{id}/**")
    public ModelAndView edit(@PathVariable(value = "id") int id) {
        Book book = bookSvc.getById(id);

        if (book != null) {
            return new ModelAndView("store/createEditBook")
                    .addObject("book", book)
                    .addObject("genres", getGenres())
                    .addObject("authors", authorSvc.getAuthors())
                    .addObject("useSideBar", false);
        } else
            return new ModelAndView("notFound");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute(value = "book") Book book,
                             BindingResult result,
                             @RequestParam(value = "file", required = false) MultipartFile file) {
        ModelAndView res = null;

        if (result.hasErrors()){
            return new ModelAndView("store/createEditBook")
                    .addObject("book", book)
                    .addObject("genres", getGenres())
                    .addObject("authors", authorSvc.getAuthors())
                    .addObject("useSideBar", false);
        }

        try {
            book = bookSvc.save(book, (file != null) ? file.getBytes() : null);
            res = new ModelAndView("store/details")
                    .addObject("book", book);
        } catch (IOException e) {
            res = new ModelAndView("error")
                    .addObject("errorCode", 0)
                    .addObject("errorMessage", e.getMessage());
        }

        return res;
    }

    @RequestMapping("/delete/{id}/**")
    public ModelAndView delete(@PathVariable(value = "id") int id) {
        ModelAndView res;
        Book book = bookSvc.getById(id);

        if (book != null) {
            bookSvc.delete(id);

            List<Book> books = bookSvc.getByGenre(book.getGenre().getId());

            res = new ModelAndView("store/books")
                    .addObject("books", books);
        } else
            res = new ModelAndView("notFound");

        return res;
    }
}
