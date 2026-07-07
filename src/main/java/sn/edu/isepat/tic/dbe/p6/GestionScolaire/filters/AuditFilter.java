package sn.edu.isepat.tic.dbe.p6.GestionScolaire.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Authenticator.RequestorType;
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
@Order(30)
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
        /*  String uri = request.getRequestURI();
        if(uri.endsWith("/apprenants")){
            log.warn("il ya un buy sur l'uri {}, la requete est interrompu",uri);
            PrintWriter out = response.getWriter();
            out.print("<h1>Bonjour je serveur est maintenance</h1>");
            out.flush(); 
            //response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            return;
        }*/
       String ip = request.getRemoteAddr();
       String url = request.getRequestURI();
       String method = request.getMethod();
       String query = request.getQueryString();
       LocalDateTime debut = LocalDateTime.now();
       
       
       RequestLogin requestLogin = RequestLogin.builder()
           .ip(ip)
           .url(url)
           .method(method)
           .queryString(query)
           .build();
           requestLoginRepository.save(requestLogin);
           filterChain.doFilter(request, response);   
           long duration = ChronoUnit.MILLIS.between(debut, LocalDateTime.now());
           requestLogin.setDuree(duration);
           requestLogin.setStatus(response.getStatus());
           requestLoginRepository.save(requestLogin); 
    }
}