package uz.micros.estore.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserDetails getUser(String name);
}
