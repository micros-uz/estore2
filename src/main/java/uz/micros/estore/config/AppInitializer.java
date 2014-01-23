package uz.micros.estore.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import sun.org.mozilla.javascript.internal.SecurityController;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebMvcConfig.class, PersistenceConfig.class, SecurityController.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
