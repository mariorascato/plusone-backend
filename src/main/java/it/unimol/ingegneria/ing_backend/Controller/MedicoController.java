package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.*;
import it.unimol.ingegneria.ing_backend.Service.MedicoService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/medici")
@CrossOrigin(origins = "*")
public class MedicoController {

    private final MedicoService medicoService;

    // Aggiungi un medico
    @PostMapping("addMedico")
    public ResponseEntity<Medico> addPersona(@RequestBody Medico medico){
            return medicoService.addMedico(medico);
    }

    // Aggiungi più medici
    @PostMapping("addMedici")
    public ResponseEntity<List<Medico>> addMedici(@RequestBody List<Medico> medici){
        return medicoService.addMedici(medici);
    }

    // Aggiorna medico
    @PutMapping("updateMedico/{id}")
    public ResponseEntity<Medico> updateMedico(@RequestBody Medico medico,@PathVariable Long id){
        return medicoService.updateMedico(medico, id);
    }

    // Elimina medico
    @DeleteMapping("deleteMedico/{id}")
    public ResponseEntity<Medico> deleteMedico(@PathVariable Long id){
        return medicoService.deleteMedico(id);
    }

    // Stampa tutti i medici
    @GetMapping("getAll")
    public ResponseEntity<List<Medico>> getAll(){
            return medicoService.getAll();
    }

    // Stampa medico da codice fiscale
    @GetMapping("getMedicoBycf/{cf}")
    public ResponseEntity<Persona> getMedicoBycf(@PathVariable String cf){
        return medicoService.findMedicoByCF(cf);
    }

    // Stampa medico da email
    @GetMapping("getMedicoByEmail/{email}")
    public ResponseEntity<Persona> getMedicoByEmail(@PathVariable String email){
        return medicoService.findMedicoByEmail(email);
    }

    // Stampa medico da nome e cognome
    @GetMapping("getMediciByNomeAndCognome/{nome}/{cognome}")
    public ResponseEntity<List<Persona>> getMediciByNomeAndCognome(@PathVariable String nome,@PathVariable String cognome){
        return medicoService.findMediciByNomeAndCognome(nome,cognome);
    }

    // Relazione paziente-medico
    @PutMapping("addPazienteToMedico/{id_medico}/{id_paziente}")
    public ResponseEntity<Medico> addPazienteToMedico(@PathVariable Long id_medico,@PathVariable Long id_paziente){
        return medicoService.addPazienteToMedico(id_medico,id_paziente);
    }

    // Stampa i pazienti seguiti dal medico
    @GetMapping("getAllPazientiByMedico/{id_medico}")
    public ResponseEntity<List<Paziente>> getAllPazientiByMedico(@PathVariable Long id_medico){
        return medicoService.getAllPazientiByMedico(id_medico);
    }

    // Stampa i medici di una Tipologia
    @GetMapping("getMedicoByTipologia/{tipologia}")
    public ResponseEntity<List<Medico>> getMedicoByTipologia(@PathVariable TipologiaMedico tipologia){
        return medicoService.getMedicoByTipologia(tipologia);
    }

    // Aggiungi farmaco a un paziente
    @PutMapping("addFarmacoToPaziente/{id_farmaco}/{id_paziente}")
    public ResponseEntity<Paziente> addFarmacoToPaziente(@PathVariable Long id_farmaco,@PathVariable Long id_paziente) {
        return medicoService.addFarmacoToPaziente(id_farmaco, id_paziente);
    }

    // Stampa tutti i farmaci di un paziente
    @GetMapping("getAllFarmaciOfPaziente/{id_paziente}")
    public ResponseEntity<List<Farmaco>> getAllFarmaciOfPaziente(@PathVariable Long id_paziente){
        return medicoService.getAllFarmaciOfPaziente(id_paziente);
    }

    // Rimuovi farmaco a un paziente
    @PutMapping("removeFarmacoOfPaziente/{id_farmaco}/{id_paziente}")
    public ResponseEntity<Farmaco> removeFarmacoOfPaziente(@PathVariable Long id_farmaco, @PathVariable Long id_paziente){
        return medicoService.removeFarmacoOfPaziente(id_farmaco, id_paziente);
    }

    // Stampa tutte le prenotazioni di un medico
    @GetMapping("getAllPrenotazioniByMedico/{id}")
    public ResponseEntity<List<Terapia>> getAllPrenotazioniByMedico(@PathVariable Long id){
        return medicoService.getAllPrenotazioniByMedico(id);
    }

}
