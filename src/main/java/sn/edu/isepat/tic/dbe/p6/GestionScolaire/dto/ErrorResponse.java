package sn.edu.isepat.tic.dbe.p6.GestionScolaire.dto;

import java.time.LocalDateTime;

public record ErrorResponse (
    Integer status,
    Integer errorCode,
    String message, 
    LocalDateTime timestamp){
    
}
