package sn.edu.isepat.tic.dbe.p6.GestionScolaire.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.entities.Apprenante;

public interface ApprenantRepository extends JpaRepository<Apprenante, Integer> {

    // Pas de 'static', pas de '{ ... }', juste un point-virgule à la fin.
    Optional<Apprenante> findByEmail(String email);

}