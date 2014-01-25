package uz.micros.estore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.micros.estore.entity.AppUser;
import uz.micros.estore.repository.UserRepository;
import uz.micros.estore.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository rpstr;

    @Override
    public List<AppUser> getUsers() {
        return rpstr.getUsers();
    }

    @Override
    public AppUser getUserByName(String name) {
        return rpstr.getUserByName(name);
    }


}
