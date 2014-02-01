package uz.micros.estore.service.intf;

import uz.micros.estore.entity.AppUser;

import java.util.List;

public interface UserService {
    List<AppUser> getUsers();
    AppUser getUserByName(String name);
    AppUser addUser(AppUser user);
}
