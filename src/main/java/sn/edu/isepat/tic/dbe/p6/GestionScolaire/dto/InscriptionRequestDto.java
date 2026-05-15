package sn.edu.isepat.tic.dbe.p6.GestionScolaire.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.entities.Genre;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InscriptionRequestDto {
    
    private String prenom;

    private String nom;
    
    private Boolean etranger;

    private Genre genre;

    private String adresse;

    private String telephone;

    private Integer promo;
    
    private LocalDate dateInscription;

    private Double montant;

    private String adresseRecupBus;

    private String email;
}
