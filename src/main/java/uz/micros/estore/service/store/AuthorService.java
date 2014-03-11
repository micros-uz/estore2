package uz.micros.estore.service.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.micros.estore.entity.store.Author;
import uz.micros.estore.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository rpstr;

    public List<Author> getAuthors() {
        return rpstr.findAll();
    }
}
