package uz.micros.estore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;

import javax.sql.DataSource;

//http://docs.spring.io/spring-security/site/docs/3.2.x/guides/helloworld.html

// http://stackoverflow.com/questions/21046062/spring-security-3-2-code-based-configuration-form-login-global-method-securit
/*
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }

}
*/

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.debug(true)
                .ignoring()
                .antMatchers("/webjars/**","/css/**","/img/**");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
/*        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(getUserQuery())
                .authoritiesByUsernameQuery(getAuthoritiesQuery())
                .rolePrefix("");*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().denyAll();/*
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/success-login", true)
                .failureUrl("/error-login")
                .loginProcessingUrl("/process-login")
                .usernameParameter("security_username")
                .passwordParameter("security_password")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .logoutUrl("/logout")
                .permitAll()
                .and()
                .rememberMe()
                .and()
                .csrf()
                .disable()*/;
    }

    private String getUserQuery() {
        return "SELECT e_mail as username, password as password, active as enabled "
                + "FROM employee "
                + "WHERE e_mail = ?";
    }

    private String getAuthoritiesQuery() {
        return "SELECT DISTINCT employee.e_mail as username, role.name as authority "
                + "FROM employee, employee_role, role "
                + "WHERE employee.id = employee_role.employee_id "
                + "AND role.id = employee_role.role_id "
                + "AND employee.e_mail = ? "
                + "AND employee.active = 1";
    }

}