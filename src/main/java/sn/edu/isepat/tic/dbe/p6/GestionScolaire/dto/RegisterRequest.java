package sn.edu.isepat.tic.dbe.p6.GestionScolaire.dto;

import java.util.List;

public record RegisterRequest( 
    String prenom,
    String nom,
    String telephone,
    String adresse,
    String email,
    String password,
    List <String> roles
) {
   

}
