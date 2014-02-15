package uz.micros.estore.util;

import org.springframework.security.core.context.SecurityContext;

public interface SecurityContextFacade {
    SecurityContext getContext();

    boolean isAdmin();

    void setContext(SecurityContext securityContext);
}
