package it.unimol.ingegneria.ing_backend.Controller;

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
    @PostMapping("addTriage/{id_paziente}")
    public ResponseEntity<Triage> addTriage(@RequestBody Triage triage,@PathVariable Long id_paziente){
        return triageService.addTriage(triage,id_paziente);
    }

    @GetMapping("getAllTriage")
    public  ResponseEntity<List<Triage>>getAllTriage(){
        return  triageService.getAllTriage();
    }
}
