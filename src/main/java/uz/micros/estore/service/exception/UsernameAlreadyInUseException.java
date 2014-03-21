package uz.micros.estore.service.exception;

import org.hibernate.service.spi.ServiceException;

public class UsernameAlreadyInUseException extends ServiceException {
    public UsernameAlreadyInUseException(String username) {
        super("The username '" + username + "' is already in use.");
    }
}
