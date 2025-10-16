package com.fideljose.testSpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class Configurations {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated());

        http.sessionManagement(
                session -> session.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS));

        //http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        http.headers(headers -> headers.frameOptions(
                HeadersConfigurer.FrameOptionsConfig::sameOrigin
        ));
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public UserDetailsService  userDetailsService() {
        UserDetails users = User.builder()
                .username("user1")
                .password("{noop}password1")
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin1")
                .password("{noop}passwordAdmin1")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(users, admin);
    }

}
