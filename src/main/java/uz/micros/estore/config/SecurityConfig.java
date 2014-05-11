package uz.micros.estore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.UserIdSource;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;
import uz.micros.estore.security.CustomSocialUserDetailsService;
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
                .antMatchers("/api/**").permitAll()
                .antMatchers("/admin/**").permitAll()
                .antMatchers("/auth/**", "/signin/**", "/signup/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/content/**").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/blog/**").permitAll()
                .antMatchers("/store/**").permitAll()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
            //.and()
                //.rememberMe()
            .and()
                .apply(new SpringSocialConfigurer())
            .and()
                .formLogin()
                    .loginPage("/signin")
                    .loginProcessingUrl("/signin/authenticate")
                    //.failureUrl("/signin?error=true")
                    .permitAll()
                 .and()
                    .logout()
                        .logoutSuccessUrl("/")
                        .logoutUrl("/signout")
                        .deleteCookies("JSESSIONID");
    }

    @Bean
    public SocialUserDetailsService socialUsersDetailService() {
        return new CustomSocialUserDetailsService(userDetailsService());
    }

    @Bean
    public UserIdSource userIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public TextEncryptor textEncryptor() {
        return Encryptors.noOpText();
    }
}