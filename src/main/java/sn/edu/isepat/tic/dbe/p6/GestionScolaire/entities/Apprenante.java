package sn.edu.isepat.tic.dbe.p6.GestionScolaire.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor  
@AllArgsConstructor
public class Apprenante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 100, nullable = false)
    private String prenom;

    private String email;

    @Column(length = 50, nullable = false)
    private String nom;
    
    @Column(nullable = false)
    private Boolean etranger;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String adresse;

    private String telephone;

    @Column(nullable = false)
    private Integer promo;

    private LocalDate dateInscription; 

    private Double montant;
    
    private String adresseRecupBus;
}

