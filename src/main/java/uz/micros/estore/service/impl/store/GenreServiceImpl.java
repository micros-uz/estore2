package uz.micros.estore.service.impl.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.micros.estore.entity.store.Genre;
import uz.micros.estore.repository.GenreRepository;
import uz.micros.estore.service.intf.store.GenreService;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository rpstr;

    @Override
    public List<Genre> getGenres() {
        return rpstr.getGenres();
    }
}
