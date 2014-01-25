package uz.micros.estore.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/*
The SecurityWebAppInitializer will automatically
register the springSecurityFilterChain Filter for every URL in
your application. If Filters are added within other
WebApplicationInitializer instances we can use @Order to
control the ordering of the Filter instances.
 */

public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {
}
