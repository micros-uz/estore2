package uz.micros.estore.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class PathHelper {

    @Autowired
    private HttpServletRequest request;

    public String getPath(){
        return request.getSession().getServletContext().getRealPath("/resources/images");
    }
}
