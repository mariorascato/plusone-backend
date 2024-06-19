package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.Segnalazione;
import it.unimol.ingegneria.ing_backend.Service.SegnalazioneService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/segnalazioni")
@CrossOrigin(origins = "*")
public class SegnalazioneController {
    private final SegnalazioneService segnalazioneService;
    @PostMapping("addSegnalazione/{id}")
    public ResponseEntity<Segnalazione> addSegnalazione(@RequestBody Segnalazione segnalazione,@PathVariable Long id){
       return segnalazioneService.addSegnalazione(segnalazione,id);
    }
    @GetMapping("getAll")
    public ResponseEntity<List<Segnalazione>> getAll(){
        return segnalazioneService.getAll();
    }
}
