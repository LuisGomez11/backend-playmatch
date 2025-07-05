package com.lgsoftworks.infrastructure.security;

import com.lgsoftworks.domain.exception.UserByEmailNotFoundException;
import com.lgsoftworks.infrastructure.adapter.out.persistence.repository.FieldAdminRepository;
import com.lgsoftworks.infrastructure.adapter.out.persistence.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class AuthenticationConfig {

    private final PlayerRepository playerRepository;
    private final FieldAdminRepository fieldAdminRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> playerRepository.findByEmail(username)
                .map(user -> (UserDetails) user)
                .or(() -> fieldAdminRepository.findByEmail(username)
                        .map(admin -> (UserDetails) admin))
                .orElseThrow(() -> new UserByEmailNotFoundException(username));
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
