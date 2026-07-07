package sn.edu.isepat.tic.dbe.p6.GestionScolaire.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod; 

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            // 1. Configuration de la politique de confidentialité
            .csrf(CsrfConfigurer::disable)
            
            // 2. Configuration des autorisations
        
            .authorizeHttpRequests(req -> req
                .requestMatchers("/auth/**").permitAll() // Accessible à tous
                .requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN") // Réservé aux ADMIN
                .requestMatchers("/compta/**").hasAnyRole("ADMIN", "COMPTABLE") // ADMIN ou COMPTABLE
                //.anyRequest().authenticated() // Tout le reste nécessite une authentification
                .requestMatchers(HttpMethod.POST,"/apprenants").permitAll()
                .requestMatchers(HttpMethod.DELETE,"/apprenants/**").hasAuthority("delApp")
                .requestMatchers(HttpMethod.GET,"/apprenants").hasAnyRole("ADMIN")
                .anyRequest().denyAll()
            )
            
            // 3. Construction de la chaîne de filtres
            .build();
    }
}