package sn.edu.isepat.tic.dbe.p6.GestionScolaire.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.dto.RegisterRequest;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {
      @PostMapping("/register")
      public ResponseEntity<Void> register(@RequestBody RegisterRequest request){
       log.info("Register request {}",request);
       return ResponseEntity.ok().build();
      }
}
