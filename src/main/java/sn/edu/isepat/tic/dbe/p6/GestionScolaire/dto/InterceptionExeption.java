package sn.edu.isepat.tic.dbe.p6.GestionScolaire.dto; 

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import sn.edu.isepat.tic.dbe.p6.GestionScolaire.exception.ApiException;

@ControllerAdvice
public class InterceptionExeption {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleExecption(ApiException ex){
        return ex.getErrorResponse();
    }
    @ExceptionHandler(Exception.class)
        public ResponseEntity<?> handleException(Exception ex){
            return ResponseEntity.status(538).body("un probleme est survenue");
        }

}