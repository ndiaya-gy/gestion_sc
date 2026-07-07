package sn.edu.isepat.tic.dbe.p6.GestionScolaire.filters;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.entities.RequestLogin;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.repository.RequestLoginRepository;

@Order(40)
@Slf4j
@Component 
@RequiredArgsConstructor 
public class AuditFilter extends OncePerRequestFilter {

    private final RequestLoginRepository requestLoginRepository;

    @Override
    protected void doFilterInternal(
        HttpServletRequest request, 
        HttpServletResponse response, 
        FilterChain filterChain) throws ServletException, IOException {
        
        // Début aller
        log.warn("Début aller AuditFilter");
        String ip = request.getRemoteAddr();
        String url = request.getRequestURI();
        String method = request.getMethod();
        
        // 🛠️ FIX: Sécurisation contre le crash "Column 'query_string' cannot be null"
        String query = request.getQueryString();
        if (query == null) {
            query = ""; // Remplace le null par du texte vide pour la BDD
        }
        
        LocalDateTime debut = LocalDateTime.now();
        
        RequestLogin requestLogin = RequestLogin.builder()
            .ip(ip)
            .url(url)
            .method(method)
            .queryString(query) // Utilise la variable nettoyée
            .requesDate(debut)  // (Optionnel) N'oubliez pas d'assigner la date si nécessaire !
            .build();
            
        // Premier enregistrement à l'aller (Sauvegarde l'entité et récupère son ID généré)
        requestLogin = requestLoginRepository.save(requestLogin);
        
        // Fin aller
        log.warn("Fin aller AuditFilter");
        
        // Transmission de la requête au filtre suivant / contrôleur
        filterChain.doFilter(request, response);   

        // Début retour
        log.warn("Début retour AuditFilter");
        long duration = ChronoUnit.MILLIS.between(debut, LocalDateTime.now());
        
        // Mise à jour de l'entité existante avec la durée et le statut HTTP final
        requestLogin.setDuree(duration);
        requestLogin.setStatus(response.getStatus());
        requestLoginRepository.save(requestLogin); 
        
        // Fin retour
        log.warn("Fin retour AuditFilter");
    }
}