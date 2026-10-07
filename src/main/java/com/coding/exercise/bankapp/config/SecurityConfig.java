package com.coding.exercise.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.coding.exercise.bankapp.service.UserService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Registered users from the database
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);

        // Built-in admin from application.yml (bankapp / changeit)
        auth.inMemoryAuthentication()
            .withUser("bankapp")
            .password(passwordEncoder.encode("changeit"))
            .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers(
                    "/", "/index.html", "/register.html",
                    "/css/**", "/js/**", "/images/**",
                    "/h2-console/**",
                    "/v2/api-docs", "/swagger-ui.html",
                    "/swagger-resources/**", "/webjars/**",
                    "/auth/register"          // public registration endpoint
                ).permitAll()
                .anyRequest().authenticated()
            .and()
            .httpBasic()
            .and()
            .csrf().disable()
            .headers().frameOptions().disable();
    }
}
