package sn.edu.isepat.tic.dbe.p6.GestionScolaire.init;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.entities.Apprenante;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.entities.Genre;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.repository.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;
@RequiredArgsConstructor
@Order(1)
@Component
@Profile({"dev", "test"})
@Slf4j
public class InitApprenant implements CommandLineRunner {
    @Value("${isepat.administration.directeur.contact.email}")
    private String emaildirecteur;
    @Autowired
    private final ApprenantRepository apprenantRepository;
    @Value("${isep.taux.fille}")
    private Double tauxfille;
    @Value("${isep.taux.etranger}")
    private Double tauxetranger;
    @Value("${isep.dbe.nbreApprenant}")
    private Integer nbreApprenant;
    @Override
    public void run(String... args) throws Exception {
        /*log.info("Initialisation des Apprenant .");
        long nbApprenant=apprenantRepository.count();
        log.info("Nombr d'Apprenants dans la base: {}",nbApprenant);
        if(nbApprenant==0){
            log.error("Aucun apprenant inscrit");
            log.warn("Initialisation des apprenants dans base");
            log.warn("ecrit un message au directeur via l'adresse email "+emaildirecteur);
            Apprenant apprenant= new Apprenant();
            apprenant.setPrenom("Ami");
            apprenant.setNom("fall");
            apprenant.setPromo(6);
            apprenantRepository.save(apprenant);

        }*/
        log.info("Iniciando apprenant");
        log.info( tauxetranger+" etrangers ");
        log.info( tauxfille+" filles ");
        log.info("nbreApprenant " + nbreApprenant+ " Apprenants");
        generateApprenant(50, 1);
        generateApprenant(10, 9);
        generateApprenant(70, 8);
        generateApprenant(5, 5);
        generateApprenant(59, 51);

    }
    private String getRandom(String[] tableau){
        Random random = new Random();
        int indice = random.nextInt(tableau.length);
        return tableau[indice];
    }
    public void generateApprenant(int nbre, int promo){
        for(int i=0; i<nbre; i++){
            String nom;
            String prenom ;
            Genre genre;
            boolean etranger;
            double aleaEtranger= Math.random();
            double aleaFille= Math.random();
            log.info("aleaEtranger{} " , aleaEtranger);
            log.info("alertFille{} " , aleaFille);
            if(aleaEtranger<tauxetranger){
                etranger=true;
            }else {
                etranger=false;
            }
            if(aleaFille<tauxfille){
                genre = Genre.Feminin;
            }else {
                genre= Genre.Masculin;
            }

            if(aleaEtranger<tauxetranger){
                log.info("on va generer un etranger");
                nom=getRandom(DataUtils.nomsAfricains);
                if(aleaFille<tauxfille){
                    prenom=getRandom(DataUtils.prenomsFillesAfricains);
                }else {
                    prenom=getRandom(DataUtils.prenomsGarconsAfricains );
                }
            }else{
                log.info("on va generer un senegalais");
                nom=getRandom(DataUtils.nomsSenegalais);
                if(aleaFille<tauxfille){
                    prenom=getRandom(DataUtils.prenomsFillesSenegalais);
                }else {
                    prenom= getRandom(DataUtils.prenomsFillesSenegalais);
                }
            }
            String email=prenom+nom+promo+"_"+i+"@gmail.edu.sn";
            log.info("prenom: {} ",prenom);
            log.info("nom:{} ",nom);
            log.info("sexe: {} ",genre);
            log.info("etranger: {} ",etranger);
            Apprenante apprenant= new Apprenante();
            apprenant.setNom(nom);
            apprenant.setPrenom(prenom);
            apprenant.setGenre(genre);
            apprenant.setEtranger(etranger);
            apprenant.setPromo(promo);
            apprenant.setEmail(email);
            apprenantRepository.save(apprenant);
        }
    }
}