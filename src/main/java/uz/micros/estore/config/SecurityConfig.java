package uz.micros.estore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import uz.micros.estore.security.CustomUserDetailsService;

/*

    Main reference - http://docs.spring.io/spring-security/site/docs/3.2.x/reference/htmlsingle/


    http://docs.spring.io/spring-security/site/docs/3.2.x/guides/hellomvc.html

*/

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService customDetailsUserService;

    @Autowired
    public void registerGlobalAuthentication(
            AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customDetailsUserService);
                //.inMemoryAuthentication()
                //.withUser("user").password("password").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/login/**").permitAll()
            .antMatchers("/webjars/**").permitAll()
            .antMatchers("/resources/**").permitAll()
            .antMatchers("/register").permitAll()
            .antMatchers("/blog").permitAll()
            .antMatchers("/").permitAll()
            .anyRequest().authenticated();
        http
            .formLogin()
                .loginPage("/login")
                .permitAll();
    }
}