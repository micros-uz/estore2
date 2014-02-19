package uz.micros.estore.controller.store;

import com.sun.net.httpserver.HttpsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.estore.controller.BaseController;
import uz.micros.estore.entity.store.Book;
import uz.micros.estore.service.intf.store.AuthorService;
import uz.micros.estore.service.intf.store.BookService;
import uz.micros.estore.service.intf.store.GenreService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

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
    public ModelAndView save(@ModelAttribute(value = "book") Book book,
                             @RequestParam(value = "file", required = false) MultipartFile file,
                             //HttpServletRequest request,
                             BindingResult result) {

        ModelAndView res;
/*
        String path;
        try {
            path = new String(request.getServletPath().getBytes(
                    "ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
*/

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
