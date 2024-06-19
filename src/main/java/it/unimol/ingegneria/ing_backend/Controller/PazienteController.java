package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.*;
import it.unimol.ingegneria.ing_backend.Service.PazienteService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/pazienti")
@CrossOrigin(origins = {"http://localhost:8100", "https://3.75.158.163:5432"})
public class PazienteController {

    private final PazienteService pazienteService;

    // Aggiungi un paziente
    @PostMapping("addPaziente")
    public ResponseEntity<Paziente> addPersona(@RequestBody Paziente paziente){
        return pazienteService.addPaziente(paziente);
    }

    // Aggiungi più pazienti
    @PostMapping("addPazienti")
    public ResponseEntity<List<Paziente>> addPazienti(@RequestBody List<Paziente> pazienti){
        return pazienteService.addPazienti(pazienti);
    }

    // Aggiorna paziente
    @PutMapping("updatePaziente/{id}")
    public ResponseEntity<Paziente> updatePaziente(@RequestBody Paziente paziente,@PathVariable Long id){
        return pazienteService.updatePaziente(paziente,id);
    }

    // Stampa tutti i pazienti
    @GetMapping("getAllPazienti")
    public ResponseEntity<List<Paziente>> getAll(){
        return pazienteService.getAll();
    }

    // Stampa pazienti attivi
    @GetMapping("getAllPazientiAttivi")
    public ResponseEntity<List<Paziente>> getAllAttivi() {
        return pazienteService.getAllAttivi();
    }

    // Stampa pazienti non attivi
    @GetMapping("getAllPazientiInattivi")
    public ResponseEntity<List<Paziente>> getAllInattivi() {
        return pazienteService.getAllInattivi();
    }

    // Stampa paziente da cf
    @GetMapping("getPazienteBycf/{cf}")
    public ResponseEntity<Persona> findPazienteBycf(@PathVariable String cf){
        return pazienteService.findPazienteByCF(cf);
    }

    // Stampa paziente da nome e cognome
    @GetMapping("getPazientiByNomeAndCognome/{nome}/{cognome}")
    public ResponseEntity<List<Persona>> findPazientiByNomeAndCognome(@PathVariable String nome,@PathVariable String cognome){
        return pazienteService.findPazientiByNomeAndCognome(nome,cognome);
    }

    // Stampa paziente da email
    @GetMapping("getPazienteByEmail/{email}")
    public ResponseEntity<Persona> findPazienteByEmail(@PathVariable String email){
        return pazienteService.findPazienteByEmail(email);
    }

    // Stampa paziente da citta
    @GetMapping("findPazientiByCitta/{citta}")
    public ResponseEntity<List<Paziente>> findPazientiByCitta(@PathVariable String citta){
        return pazienteService.findPazientiByCitta(citta);
    }

    // Attiva paziente
    @PutMapping("activatePaziente/{id}")
    public ResponseEntity<Persona> activatePaziente(@PathVariable Long id){
        return pazienteService.activatePaziente(id);
    }

    // Elimina paziente
    @DeleteMapping("deletePaziente/{id}")
    public ResponseEntity<Persona> deletePaziente(@PathVariable Long id){
        return pazienteService.deletePaziente(id);
    }

    // Stampa il medico del paziente
    @GetMapping("getMedicoOfPaziente/{id_paziente}")
    public ResponseEntity<Medico> getMedicoOfPaziente(@PathVariable Long id_paziente){
        return pazienteService.getMedicoOfPaziente(id_paziente);
    }
    @GetMapping("getAllTerapieByPaziente/{id}")
    public ResponseEntity<List<Terapia>> getAllTerapieByPaziente(@PathVariable Long id){
        return pazienteService.getAllTerapieByPaziente(id);
    }
    @GetMapping("getAllTerapieFarmacologicaByPaziente/{id}")
    public ResponseEntity<List<Tfarmacologica>> getAllTerapiaFarmacologicaByPaziente(@PathVariable Long id){
        return pazienteService.getAllTerapieFarmacologicaByPaziente(id);
    }

}
