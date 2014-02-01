package uz.micros.estore.service.intf.store;

import uz.micros.estore.entity.store.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getGenres();
}
