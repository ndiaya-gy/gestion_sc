package sn.edu.isepat.tic.dbe.p6.GestionScolaire.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.dto.ApprenantService;
import sn.edu.isepat.tic.dbe.p6.GestionScolaire.entities.Apprenante;

@Slf4j
@RequiredArgsConstructor
@RequestMapping
@RestController
public class ApprenantController {
    private final ApprenantService apprenantService;
    
    @Operation(
        summary = "resumé",
        description = "description",
        responses = {
            @ApiResponse(
                responseCode =  "200",
                description = "La liste des apprenants est retournée avec succes",
                content = {
                    @Content(
                        examples = { 
                        @ExampleObject(
                            name = "response normale",
                            description = "Reponse contenant une liste non vide des apprenant",
                            value = "[\r\n" + //
                                                "    \"id\": 25,\r\n" + //
                                                "    \"prenom\": \"Yaye\",\r\n" + //
                                                "    \"email\": \"YayeDiedhiou1_24@gmail.edu.sn\",\r\n" + //
                                                "    \"nom\": \"Diedhiou\",\r\n" + //
                                                "    \"etranger\": false,\r\n" + //
                                                "    \"genre\": \"Feminin\",\r\n" + //
                                                "    \"adresse\": null,\r\n" + //
                                                "    \"telephone\": null,\r\n" + //
                                                "    \"promo\": 1,\r\n" + //
                                                "    \"dateInscription\": null,\r\n" + //
                                                "    \"montant\": null,\r\n" + //
                                                "    \"adresseRecupBus\": null\r\n" + //
                                                "  },\r\n" + //
                                                "  {\r\n" + //
                                                "    \"id\": 26,\r\n" + //
                                                "    \"prenom\": \"Saër\",\r\n" + //
                                                "    \"email\": \"SaërTall1_25@gmail.edu.sn\",\r\n" + //
                                                "    \"nom\": \"Tall\",\r\n" + //
                                                "    \"etranger\": false,\r\n" + //
                                                "    \"genre\": \"Feminin\",\r\n" + //
                                                "    \"adresse\": null,\r\n" + //
                                                "    \"telephone\": null,\r\n" + //
                                                "    \"promo\": 1,\r\n" + //
                                                "    \"dateInscription\": null,\r\n" + //
                                                "    \"montant\": null,\r\n" + //
                                                "    \"adresseRecupBus\": null\r\n" + //
                                                "  ]"
                                            ),
                                            @ExampleObject(
                                                name = "liste vide",
                                                description = "Il n'ya pas d'apprenants en base",
                                                value = "[]"
                                            )
                                        }
                                    )
                }
            )
        }
    )
    @GetMapping("/apprenants")

    public List<Apprenante> getAllApprenants(){
        return apprenantService.getAllApprenantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Apprenante> findById(@PathVariable Integer id){
         Apprenante result=apprenantService.findById(id);
            return ResponseEntity.ok(result);
       
    }
}

