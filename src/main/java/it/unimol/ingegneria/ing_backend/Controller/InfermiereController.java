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
@CrossOrigin(origins = {"http://localhost:8100", "https://3.75.158.163:5432"})
public class InfermiereController {

    private final InfermiereService infermiereService;

    // Aggiungi un infermiere
    @PostMapping("addInfermiere")
    public ResponseEntity<Infermiere> addPersona(@RequestBody Infermiere infermiere){
        return infermiereService.addInfermiere(infermiere);
    }

    // Aggiungi più infermieri
    @PostMapping("addInfermieri")
    public ResponseEntity<List<Infermiere>> addInfermieri(@RequestBody List<Infermiere> infermieri){
        return infermiereService.addInfermieri(infermieri);
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

    // Stampa tutti gli infermieri
    @GetMapping("getAll")
    public ResponseEntity<List<Infermiere>> getAll(){
        return infermiereService.getAll();
    }

    // Stampa infermiere da email
    @GetMapping("getInfermiereByEmail/{email}")
    public ResponseEntity<Persona> getInfermiereByEmail(@PathVariable String email){
        return infermiereService.getInfermiereByEmail(email);
    }

}
