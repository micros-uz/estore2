package uz.micros.estore.service.impl.store;

import org.springframework.stereotype.Service;
import uz.micros.estore.entity.store.Genre;
import uz.micros.estore.service.store.GenreService;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Override
    public List<Genre> getGenres() {
        ArrayList<Genre> res = new ArrayList<Genre>();

        Genre g = new Genre();
        g.setTitle("genre 1");
        res.add(g);
        g = new Genre();
        g.setTitle("genre 34");
        res.add(g);

        return res;
    }
}
