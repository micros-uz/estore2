package uz.micros.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.micros.estore.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer> {
    AppUser getUserByUserName(String name);
}
