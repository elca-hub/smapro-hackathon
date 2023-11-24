package com.mokimaki.arput.infrastructure.security;

import com.mokimaki.arput.infrastructure.security.utils.CryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    public void configureProvider(
            AuthenticationManagerBuilder auth,
            MyUserDetailsService myUserDetailService,
            MyAuthenticationUserDetailService myAuthenticationUserDetailService
    ) throws Exception {
        var preAuthenticatedAuthenticationProvider = new PreAuthenticatedAuthenticationProvider();
        preAuthenticatedAuthenticationProvider.setPreAuthenticatedUserDetailsService(myAuthenticationUserDetailService);
        preAuthenticatedAuthenticationProvider.setUserDetailsChecker(new AccountStatusUserDetailsChecker());
        auth.authenticationProvider(preAuthenticatedAuthenticationProvider);

        var daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(myUserDetailService);
        daoAuthenticationProvider.setPasswordEncoder(CryptPasswordEncoder.fetch());
        auth.authenticationProvider(daoAuthenticationProvider);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/user/create", "user/login").permitAll()
                .anyRequest().authenticated()
        );

        http.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf(AbstractHttpConfigurer::disable);

        var authManager = authenticationManager((AuthenticationConfiguration) http.getSharedObject(AuthenticationManager.class));

        http.addFilter(new MyUsernamePasswordAuthenticationFilter(authManager));
        http.addFilter(new MyRequestHeaderAuthenticationFilter(authManager));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return CryptPasswordEncoder.fetch();
    }
}
