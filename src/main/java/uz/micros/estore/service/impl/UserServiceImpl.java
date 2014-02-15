package uz.micros.estore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.micros.estore.entity.AppUser;
import uz.micros.estore.repository.UserRepository;
import uz.micros.estore.service.intf.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository rpstr;

    @Override
    @Transactional(readOnly = true)
    public List<AppUser> getUsers() {
        return rpstr.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public AppUser getUserByName(String name) {
        return rpstr.getUserByName(name);
    }

    @Override
    @Transactional(readOnly = false)
    public AppUser addUser(AppUser user) {
        return rpstr.saveAndFlush(user);
    }
}
