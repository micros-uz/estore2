package uz.micros.estore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.micros.estore.entity.AppUser;
import uz.micros.estore.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService service;

    @Autowired(required = true)
    public CustomUserDetailsService(UserService service) {
        super();
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        AppUser user = service.getUserByName(userName);

        if (user != null)
            return new User(user.getName(), user.getPassword(), true,
                    true, true, true, getAuthorities());
        else
            return new User(userName, userName, true,
                    true, true, true, getAuthorities());
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> res = new ArrayList<>();
        return res;
    }
}
