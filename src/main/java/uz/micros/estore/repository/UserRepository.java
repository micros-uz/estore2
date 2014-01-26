package uz.micros.estore.repository;

import uz.micros.estore.entity.AppUser;

import java.util.List;

public interface UserRepository {
    public List<AppUser> getUsers();

    AppUser getUserByName(String name);

    AppUser addUser(AppUser user);
}
