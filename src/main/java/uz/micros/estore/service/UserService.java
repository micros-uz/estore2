package uz.micros.estore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.micros.estore.entity.AppUser;
import uz.micros.estore.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository rpstr;

    @Transactional(readOnly = true)
    public List<AppUser> getUsers() {
        return rpstr.findAll();
    }

    @Transactional(readOnly = true)
    public AppUser getUserByName(String name) {
        return rpstr.getUserByName(name);
    }

    @Transactional(readOnly = false)
    public AppUser addUser(AppUser user) {
        return rpstr.saveAndFlush(user);
    }
}
