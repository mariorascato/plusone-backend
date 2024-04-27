package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.Infermiere;
import it.unimol.ingegneria.ing_backend.Service.InfermiereService;
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

}