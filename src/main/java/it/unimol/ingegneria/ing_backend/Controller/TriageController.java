package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.Conferma;
import it.unimol.ingegneria.ing_backend.Model.Medico;
import it.unimol.ingegneria.ing_backend.Model.Triage;
import it.unimol.ingegneria.ing_backend.Service.TriageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/triage")
@CrossOrigin("http://localhost:8100")
public class TriageController {

    private final TriageService triageService;

    // Aggiungi triage
    @PostMapping("addTriage/{id_paziente}")
    public ResponseEntity<Triage> addTriage(@RequestBody Triage triage,@PathVariable Long id_paziente){
        return triageService.addTriage(triage,id_paziente);
    }

    // Stampa tutti i triage
    @GetMapping("getAllTriage")
    public  ResponseEntity<List<Triage>>getAllTriage(){
        return  triageService.getAllTriage();
    }

    // Aggiorna triage
    @PutMapping("updateTriage/{id}")
    public ResponseEntity<Triage> updateTriage(@RequestBody Triage triage, @PathVariable Long id){
        return triageService.updateTriage(triage, id);
    }

    // Elimina triage
    @DeleteMapping("deleteTriage/{id}")
    public ResponseEntity<Triage> deleteTriage(@PathVariable Long id){
        return triageService.deleteTriage(id);
    }
    @PutMapping("setState/{id}/{conferma}")
    public ResponseEntity<Triage> setState(@PathVariable Long id, @PathVariable Conferma conferma){
        return triageService.setState(id,conferma);
    }

}
