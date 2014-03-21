package uz.micros.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import uz.micros.estore.entity.store.Genre;
import uz.micros.estore.service.store.GenreService;

import java.util.List;

public abstract class BaseStoreController extends GenericController {
    @Autowired
    private GenreService service;

    @ModelAttribute("genres")
    public List<Genre> getGenres(){
        return service.getGenres();
    }
}
