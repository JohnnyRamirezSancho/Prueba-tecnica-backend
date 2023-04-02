package com.pruebastecnicas.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.pruebastecnicas.backend.services.JpaUserDetailsService;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Autowired
        private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

        private JpaUserDetailsService service;

        public SecurityConfig(JpaUserDetailsService service) {
                this.service = service;
        }

        @Bean
        SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .cors(withDefaults())
                    .headers(header -> header.frameOptions().sameOrigin())
                    .csrf(csrf -> csrf.disable())
                    .formLogin(form -> form.disable())
                    .logout(logout -> logout
                            .logoutUrl("/api/logout")
                            .deleteCookies("JSESSIONID"))
                    .authorizeHttpRequests((auth) -> auth
                            .antMatchers("/api/courses/**").permitAll()
                            .antMatchers("/api/roles/**").hasRole("ADMIN")
                            .antMatchers("/api/users").hasRole("ADMIN")
                            .antMatchers("/api/users/**").hasAnyRole("ADMIN", "USER")
                            .antMatchers("/api/registers/**").hasAnyRole("ADMIN", "USER")
                            .anyRequest()
                            .authenticated())
                    .userDetailsService(service)
                    .sessionManagement(session -> session
                            .sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                    .httpBasic(basic -> basic
                            .authenticationEntryPoint(authenticationEntryPoint));
                return http.build();

        }

        @Bean
        PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }
}
