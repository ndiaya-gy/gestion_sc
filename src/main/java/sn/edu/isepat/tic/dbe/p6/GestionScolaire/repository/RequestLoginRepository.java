package sn.edu.isepat.tic.dbe.p6.GestionScolaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import sn.edu.isepat.tic.dbe.p6.GestionScolaire.entities.RequestLogin;

@Repository
public interface RequestLoginRepository extends JpaRepository<RequestLogin, Long> {

    

    
}
