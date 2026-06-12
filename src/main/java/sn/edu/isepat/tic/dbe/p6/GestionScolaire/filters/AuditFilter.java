package sn.edu.isepat.tic.dbe.p6.GestionScolaire.filters;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Order(30)
@Component 
public class AuditFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(
        HttpServletRequest request, 
        HttpServletResponse response, 
        FilterChain filterChain) throws ServletException, IOException {
            
        PrintWriter out = response.getWriter();
        out.print("<h1>Bonjour je serveur est maintenance</h1>");
        out.flush();    
    }
}