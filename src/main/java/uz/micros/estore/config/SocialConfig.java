package uz.micros.estore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

@Configuration

public class SocialConfig {
    @Value("${facebook.clientId}")
    private String facebookClientId;
    @Value("${facebook.clientSecret}")
    private String facebookClientSecret;

    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new FacebookConnectionFactory(facebookClientId,facebookClientSecret));
        //registry.addConnectionFactory(new TwitterConnectionFactory());

        return registry;
    }

    @Autowired
    private Environment environment;
}
