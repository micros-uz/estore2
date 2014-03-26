package uz.micros.estore.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import uz.micros.estore.entity.store.Author;
import uz.micros.estore.entity.store.Book;
import uz.micros.estore.entity.store.Genre;
import uz.micros.estore.service.store.AuthorService;
import uz.micros.estore.service.store.BookService;
import uz.micros.estore.service.store.GenreService;

import java.util.List;

@Controller
@RequestMapping("api")
public class StoreApiController  {
    @Autowired
    private AuthorService authorSvc;

    @Autowired
    private GenreService genreSvc;
    @Autowired
    private BookService bookSvc;

    @RequestMapping("authors")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<Author> authors(){
        return authorSvc.getAuthors();
    }

    @RequestMapping("genres")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<Genre> genres(){
        return genreSvc.getGenres();
    }

    @RequestMapping("books")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<Book> books(){
        return bookSvc.getAll();
    }

}
