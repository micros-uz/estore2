package uz.micros.estore.repository;

import uz.micros.estore.entity.store.Genre;

import java.util.List;

public interface GenreRepository {
    List<Genre> getGenres();
}
