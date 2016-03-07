package io.khasang.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) {
        try {
            auth
                    .inMemoryAuthentication()
                    .withUser("user").password("user").roles("USER").and()
                    .withUser("admin").password("admin").roles("USER","ADMIN").and()
                    .withUser("superadmin").password("superadmin").roles("USER","ADMIN","SUPERADMIN");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void configure(HttpSecurity http){
        try {
            http.authorizeRequests()
                    .antMatchers("/protected").access("hasRole('ADMIN')")
                    .antMatchers("/confidential").access("hasRole('SUPERADMIN')")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().and()
                    .httpBasic();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
    protected void configureDB(AuthenticationManagerBuilder auth){ TODO JDBC AUTH
        try {
            DataSource dataSource = null;
            auth
                    .jdbcAuthentication()
                    .dataSource(dataSource)
                    .usersByUsernameQuery(
                            "select username, password, true " +
                                    "from Spitter where username=?")
                    .authoritiesByUsernameQuery(
                            "select username, 'ROLE_USER' from Spitter where username=?");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
}
