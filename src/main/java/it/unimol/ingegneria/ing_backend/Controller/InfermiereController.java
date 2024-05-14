package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.Infermiere;
import it.unimol.ingegneria.ing_backend.Model.Persona;
import it.unimol.ingegneria.ing_backend.Service.InfermiereService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/infermieri")
@CrossOrigin("http://localhost:8100")

public class InfermiereController {

    private final InfermiereService infermiereService;

    // Aggiungi infermiere
    @PostMapping("addInfermiere")
    public ResponseEntity<Infermiere> addPersona(@RequestBody Infermiere infermiere){
        return infermiereService.addInfermiere(infermiere);
    }

    // Aggiorna infermiere
    @PutMapping("updateInfermiere/{id}")
    public ResponseEntity<Infermiere> updateInfermiere(@RequestBody Infermiere infermiere,@PathVariable Long id){
        return infermiereService.updateInfermiere(infermiere, id);
    }

    // Elimina infermiere
    @DeleteMapping("deleteInfermiere/{id}")
    public ResponseEntity<Infermiere> deleteInfermiere(@PathVariable Long id){
        return infermiereService.deleteInfermiere(id);
    }

    // Stampa tutti gli infermiere
    @GetMapping("getAll")
    public ResponseEntity<List<Infermiere>> getAll(){
        return infermiereService.getAll();
    }

    @GetMapping("getInfermiereByEmail/{email}")
    public ResponseEntity<Persona> getInfermiereByEmail(@PathVariable String email){
        return infermiereService.findInfermiereByEmail(email);
    }
    @GetMapping("getInfermiereBycf/{cf}")
    public ResponseEntity<Persona> getInfermiereBycf(@PathVariable String cf){
        return infermiereService.findInfermiereByCF(cf);
    }
    @GetMapping("getInfermieriByNomeAndCognome/{nome}/{cognome}")
    public ResponseEntity<List<Persona>> getInfermieriByNomeAndCognome(@PathVariable String nome, @PathVariable String cognome) {
        return infermiereService.findInfermieriByNomeAndCognome(nome,cognome);
    }
    @PostMapping("addInfermieri")
    public ResponseEntity<List<Infermiere>> addInfermieri(@RequestBody List<Infermiere> infermieri){
        return infermiereService.addInfermieri(infermieri);
    }

}
