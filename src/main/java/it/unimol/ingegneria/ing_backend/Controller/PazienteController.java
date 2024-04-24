package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.Medico;
import it.unimol.ingegneria.ing_backend.Model.Paziente;
import it.unimol.ingegneria.ing_backend.Model.Persona;
import it.unimol.ingegneria.ing_backend.Service.PazienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("updatePaziente/{id}")
    public ResponseEntity<Paziente> updatePaziente(@RequestBody Paziente paziente,@PathVariable Long id){
        return pazienteService.updatePaziente(paziente,id);
    }
    @GetMapping("getAllPazienti")
    public ResponseEntity<List<Paziente>> getAll(){
        return pazienteService.getAll();
    }
    @GetMapping("getPazienteBycf/{cf}")
    public ResponseEntity<Persona> findPazienteBycf(@PathVariable String cf){
        return pazienteService.findPazienteByCF(cf);
    }
    @GetMapping("getPazientiByNomeAndCognome/{nome}/{cognome}")
    public ResponseEntity<List<Persona>> findPazientiByNomeAndCognome(@PathVariable String nome,@PathVariable String cognome){
        return pazienteService.findPazientiByNomeAndCognome(nome,cognome);
    }
    @GetMapping("getPazienteByEmail/{email}")
    public ResponseEntity<Persona> findPazienteByEmail(@PathVariable String email){
        return pazienteService.findPazienteByEmail(email);
    }
    @DeleteMapping("deletePaziente/{id}")
    public ResponseEntity<Persona> deletePaziente(@PathVariable Long id){
        return pazienteService.deletePaziente(id);
    }
    @GetMapping("findPazientiByCitta/{citta}")
    public ResponseEntity<List<Paziente>> findPazientiByCitta(@PathVariable String citta){
        return pazienteService.findPazientiByCitta(citta);
    }
    @GetMapping("getMedicoOfPaziente/{id_paziente}")
    public ResponseEntity<Medico> getMedicoOfPaziente(@PathVariable Long id_paziente){
        return pazienteService.getMedicoOfPaziente(id_paziente);
    }
}
