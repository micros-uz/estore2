package uz.micros.estore.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.estore.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public abstract class GenericController {
    @ExceptionHandler(ServiceException.class)
    public ModelAndView fefe(HttpServletRequest req, Exception exception) {
        return new ModelAndView("error")
                .addObject("errorCode", 0)
                .addObject("errorMessage", exception.getMessage());
    }

}
