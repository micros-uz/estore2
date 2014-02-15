package uz.micros.estore.util;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextHolderFacade implements SecurityContextFacade {

    public SecurityContext getContext() {
        return SecurityContextHolder.getContext();
    }

    public boolean isAdmin(){
        return getContext().getAuthentication().getName().equals("admin");
    }

    public void setContext(SecurityContext securityContext) {
        SecurityContextHolder.setContext(securityContext);
    }

}