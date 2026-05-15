package sn.edu.isepat.tic.dbe.p6.GestionScolaire.init;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.InscriptionService;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.dto.InscriptionRequestDto;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.entities.Genre;

@Slf4j
@Component
@Order(20)
@RequiredArgsConstructor
public class TestInscriptionService implements CommandLineRunner{
     private final InscriptionService inscriptionService;
    @Override
    public void run(String... args) throws Exception {
        log.info("Test Incription service started");
        InscriptionRequestDto inscriptNdiaya=InscriptionRequestDto.builder()
           .prenom("Ndiaya")
           .nom("Gaye")
           .etranger(false)
           .telephone("T45DA")
           .promo(6)
           .dateInscription(LocalDate.of(2006, 01, 21))
           .genre(Genre.Feminin)
           .email("ndiaya@gmail.com")
           .montant(50000.0)
            .build();
            inscriptionService.inscrire(inscriptNdiaya);
            log.info("le Test est terminer");

    }
    
}
