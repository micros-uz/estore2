package uz.micros.estore.service.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.micros.estore.entity.store.Genre;
import uz.micros.estore.repository.GenreRepository;

import java.util.List;

@Service
public class GenreService {

    //@Autowired
    private GenreRepository rpstr;

    @Autowired
    public GenreService(GenreRepository rpstr) {
        this.rpstr = rpstr;
    }

    public List<Genre> getGenres() {
        return rpstr.findAll();
    }
}
