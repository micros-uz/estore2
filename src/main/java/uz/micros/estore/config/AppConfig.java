package uz.micros.estore.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import uz.micros.estore.util.DateFormatter;
import uz.micros.estore.util.SecurityContextFacade;
import uz.micros.estore.util.SecurityContextHolderFacade;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "uz.micros.estore")
@EnableTransactionManagement
@PropertySource("classpath:app.properties")
public class AppConfig {

    @Bean
    public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer()
    {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("app.properties"));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }

    @Bean(name = "dateFormatter")
    public DateFormatter getDateFormatter() {
        return new DateFormatter();
    }

    @Bean(name="securityContextFacade")
    public SecurityContextFacade getSecurityContextFacade(){
        return new SecurityContextHolderFacade();
    }
}