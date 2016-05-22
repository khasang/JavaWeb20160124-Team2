package io.khasang.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) {
        try {
            auth
                    .inMemoryAuthentication()
                    .withUser("user").password("user").roles("USER").and()
                    .withUser("admin").password("admin").roles("ADMIN").and()
                    .withUser("superadmin").password("superadmin").roles("SUPERADMIN");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void configure(HttpSecurity httpSecurity){ //simple default configuration specifies
        try {
            httpSecurity
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().and()
                    .httpBasic();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
    @Override
    protected void configure(HttpSecurity http){
        try {
            http
                    .authorizeRequests()
                        .antMatchers("/protected").access("hasRole('ROLE_ADMIN')")
                        .antMatchers(HttpMethod.POST, "/protected").access("hasRole('ROLE_ADMIN')")
                        .anyRequest().permitAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected void configureDB(AuthenticationManagerBuilder auth){
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
