package com.npci.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
public class NpciSecurityConfiguration {

    private NpciAuthenticationProvider npciAuthenticationProvider;

    public NpciSecurityConfiguration(NpciAuthenticationProvider npciAuthenticationProvider) {
        this.npciAuthenticationProvider = npciAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return new ProviderManager(List.of(npciAuthenticationProvider));
    }

    @Bean
    public NpciAuthenticationFilter npciAuthenticationFilter(AuthenticationManager authenticationManager) {
        NpciAuthenticationFilter etsAuthenticationFilter = new NpciAuthenticationFilter(authenticationManager);
        etsAuthenticationFilter.setFilterProcessesUrl("/authenticate");
        return etsAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/","/login").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form->form
                        .loginPage("/login")
                )
                .addFilterBefore(npciAuthenticationFilter(authenticationManager(http)),
                        UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
