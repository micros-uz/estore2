package uz.micros.estore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.micros.estore.entity.AppUser;
import uz.micros.estore.repository.UserRepository;
import uz.micros.estore.service.exception.ServiceException;
import uz.micros.estore.service.exception.UsernameAlreadyInUseException;

import javax.persistence.PersistenceException;
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
    public AppUser getUserByUserName(String username) {
        return rpstr.getUserByUserName(username);
    }

    @Transactional(readOnly = false, rollbackFor = ServiceException.class)
    public AppUser addUser(AppUser user) throws ServiceException {
        try{
            return rpstr.saveAndFlush(user);
        }
        catch(DuplicateKeyException e){
            throw new UsernameAlreadyInUseException(user.getUsername());
        }
        catch(PersistenceException e){
            throw new ServiceException(e);
        }
    }
}
