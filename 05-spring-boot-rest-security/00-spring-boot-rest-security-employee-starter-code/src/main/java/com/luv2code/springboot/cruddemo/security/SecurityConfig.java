package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Consumer;

@Configuration
public class SecurityConfig {

    @Bean
    InMemoryUserDetailsManager getInMemoryUserDetailsManager() {
        UserDetails userDetails = User.builder()
                .username("user")
                .password("{noop}password")
                .roles("EMPLOYEE")
                .build();

        UserDetails managerDetails = User.builder()
                .username("manager")
                .password("{noop}password")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails adminetails = User.builder()
                .username("admin")
                .password("{noop}password")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails, managerDetails, adminetails);
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) {
        httpSecurity.authorizeHttpRequests(new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
            @Override
            public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorizationManagerRequestMatcherRegistry) {
                authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE");
                authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE");
                authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER");
                authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER");
                authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN");
            }
        });

        httpSecurity.httpBasic(Customizer.withDefaults());
//        Disable Cross Site Request Forgery (CSRF)
        httpSecurity.csrf(csrfConfigurer -> csrfConfigurer.disable());
        return httpSecurity.build();
    }
}
