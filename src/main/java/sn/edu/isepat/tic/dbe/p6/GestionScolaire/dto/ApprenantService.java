package sn.edu.isepat.tic.dbe.p6.GestionScolaire.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.entities.Apprenante;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.exception.ApiException;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.repository.ApprenantRepository;
@Slf4j
@RequiredArgsConstructor
@Service
public class ApprenantService {
    
    private final ApprenantRepository apprenantRepository;

    @GetMapping
    public List<Apprenante> getAllApprenantes() {
        log.trace("recuperation liste apprenants");
        return apprenantRepository.findAll();
    }
    public Apprenante findById(Integer idApprenante){
        if(idApprenante == null || idApprenante < 0) {
            throw new ApiException(450, "L'id '"+idApprenante+"' doit etre un nombre positif");
        }
        Optional<Apprenante> apprenantDb= apprenantRepository.findById(idApprenante);
        if(apprenantDb.isEmpty()){
            throw new ApiException(454, "L'Apprenant dont l'id est '"+idApprenante+"' n'existe pas");
        }
        Apprenante apprenante = apprenantDb.get();
        return apprenante;
    }
}
