package sn.edu.isepat.tic.dbe.p6.GestionScolaire.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@Table(name = "request_login")
@Builder
@NoArgsConstructor  
@AllArgsConstructor
public class RequestLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String ip;
    
    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String method;

    @Column(nullable = false)
    private String queryString;
    
    @Column(nullable = false)
    private LocalDateTime requesDate;

    private Long duree;

    private Integer status;
}
