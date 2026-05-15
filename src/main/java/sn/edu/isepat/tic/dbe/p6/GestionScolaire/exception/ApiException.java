package sn.edu.isepat.tic.dbe.p6.GestionScolaire.exception; // Utilise un package .exception plutôt que .repository

import java.time.LocalDateTime;
import lombok.Getter;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.dto.ErrorResponse;

@Getter
public class ApiException extends RuntimeException {
    private final ErrorResponse errorResponse;

    public ApiException(Integer status, Integer errorCode, String message) {
        super(message);
        this.errorResponse = new ErrorResponse(status, errorCode, message, LocalDateTime.now());
    }
}