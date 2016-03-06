package io.khasang.webstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/account").access("hasRole('USER')")
                .and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").failureUrl("/login?error").permitAll()
                .and().logout().logoutUrl("/account").logoutSuccessUrl("/?logout").permitAll()
                .and().exceptionHandling().accessDeniedPage("/WEB-INF/views/403.jsp");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        auth.inMemoryAuthentication().passwordEncoder(md5PasswordEncoder)
                .withUser("user").password(md5PasswordEncoder.encodePassword("user", null)).roles("USER").and()
                .withUser("admin").password(md5PasswordEncoder.encodePassword("admin", null)).roles("USER", "ADMIN");
    }
}
