package uz.micros.estore.service.impl.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.micros.estore.entity.store.Author;
import uz.micros.estore.repository.AuthorRepository;
import uz.micros.estore.service.intf.store.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository rpstr;

    @Override
    public List<Author> getAuthors() {
        return rpstr.findAll();
    }
}
