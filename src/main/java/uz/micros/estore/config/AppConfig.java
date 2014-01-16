package uz.micros.estore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import uz.micros.estore.util.DateFormatter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "uz.micros.estore")
//@Profile("openshift")
@EnableTransactionManagement

@Import({WebInitializer.class, DispatcherConfig.class})
public class AppConfig {

    @Bean(name = "dateFormatter")
    public DateFormatter getDateFormatter() {
        return new DateFormatter();
    }
}