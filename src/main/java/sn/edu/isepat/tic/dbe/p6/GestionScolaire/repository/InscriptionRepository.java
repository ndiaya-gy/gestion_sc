package sn.edu.isepat.tic.dbe.p6.GestionScolaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.edu.isepat.tic.dbe.p6.GestionScolaire.entities.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
    
}
