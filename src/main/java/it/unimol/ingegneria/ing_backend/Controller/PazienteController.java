package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.Paziente;
import it.unimol.ingegneria.ing_backend.Service.PazienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/pazienti")
@CrossOrigin("http://localhost:8100")

public class PazienteController {

    private final PazienteService pazienteService;
    @PostMapping("addPaziente")
    public ResponseEntity<Paziente> addPersona(@RequestBody Paziente paziente){
        return pazienteService.addPaziente(paziente);
    }
}
