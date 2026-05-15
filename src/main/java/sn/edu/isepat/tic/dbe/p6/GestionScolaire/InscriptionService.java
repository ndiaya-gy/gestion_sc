package sn.edu.isepat.tic.dbe.p6.GestionScolaire;

import java.util.Optional;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.dto.InscriptionRequestDto;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.entities.Apprenante;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.entities.Inscription;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.exception.ApiException;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.exception.ErrorCode;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.repository.ApprenantRepository;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.repository.InscriptionRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class InscriptionService {

    private final ApprenantRepository apprenanteRepository;
    private final InscriptionRepository inscriptionRepository;
        @Transactional
        public void inscrire(InscriptionRequestDto inscriptionDto) {
            if (inscriptionDto.getEmail() == null || inscriptionDto.getEmail().isBlank()) {
                throw new ApiException(
                    400, 
                    ErrorCode.APPRENANTE_INVALID_DATA.getCode(), 
                    "L'adresse email est obligatoire pour l'inscription"
                );
            }
            if (inscriptionDto.getMontant() == null || inscriptionDto.getMontant() <= 0) {
                throw new ApiException(
                    400, 
                    ErrorCode.INSCRIPTION_INVALID_AMOUNT.getCode(), 
                    "Le montant de l'inscription doit être supérieur à 0"
                );
            }
            String email = inscriptionDto.getEmail();
            Optional<Apprenante> apprenantDb = apprenanteRepository.findByEmail(email);
            Apprenante apprenante;

            if (apprenantDb.isPresent()) {
                log.info("L'apprenante avec l'email '{}' existe déjà.", email);
                apprenante = apprenantDb.get();
            } else {
                log.info("Création d'une nouvelle apprenante pour l'email '{}'.", email);
                apprenante = Apprenante.builder()
                        .prenom(inscriptionDto.getPrenom())
                        .nom(inscriptionDto.getNom())
                        .email(email)
                        .genre(inscriptionDto.getGenre())
                        .etranger(inscriptionDto.getEtranger())
                        .promo(inscriptionDto.getPromo())
                        .telephone(inscriptionDto.getTelephone())
                        .adresse(inscriptionDto.getAdresse())
                        .build();

                apprenante = apprenanteRepository.save(apprenante);
            }
            Inscription nouvelleInscription = Inscription.builder()
                    .dateInscription(inscriptionDto.getDateInscription())
                    .montant(inscriptionDto.getMontant())
                    .adresseRecupBus(inscriptionDto.getAdresseRecupBus())
                    .apprenante(apprenante)
                    .build();

            inscriptionRepository.save(nouvelleInscription);
            log.info("Inscription enregistrée avec succès pour l'ID apprenante : {}", apprenante.getId());
        }
}