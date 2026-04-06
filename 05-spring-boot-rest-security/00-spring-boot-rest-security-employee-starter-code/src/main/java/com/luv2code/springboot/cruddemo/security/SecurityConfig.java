package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    UserDetailsManager getInMemoryUserDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
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
                authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.PATCH, "/api/employees/**").hasRole("MANAGER");
                authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN");
            }
        });

        httpSecurity.httpBasic(Customizer.withDefaults());
//        Disable Cross Site Request Forgery (CSRF)
        httpSecurity.csrf(csrfConfigurer -> csrfConfigurer.disable());
        return httpSecurity.build();
    }
}
