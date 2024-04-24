package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.Medico;
import it.unimol.ingegneria.ing_backend.Model.Paziente;
import it.unimol.ingegneria.ing_backend.Service.MedicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/medici")
@CrossOrigin("http://localhost:8100")
    public class MedicoController {

        private final MedicoService medicoService;

        @PostMapping("addMedico")
        public ResponseEntity<Medico> addPersona(@RequestBody Medico medico){
            return medicoService.addMedico(medico);
        }

        @PutMapping("updateMedico/{id}")
        public ResponseEntity<Medico> updateMedico(@RequestBody Medico medico,@PathVariable Long id){
            return medicoService.updateMedico(medico, id);
        }

        @DeleteMapping("deleteMedico/{id}")
        public ResponseEntity<Medico> deleteMedico(@PathVariable Long id){
            return medicoService.deleteMedico(id);
        }

        @GetMapping("getAll")
        public ResponseEntity<List<Medico>> getAll(){
            return medicoService.getAll();
        }
        @PutMapping("addPazienteToMedico/{id_medico}/{id_paziente}")
        public ResponseEntity<Medico> addPazienteToMedico(@PathVariable Long id_medico,@PathVariable Long id_paziente){
            return medicoService.addPazienteToMedico(id_medico,id_paziente);
        }
        @GetMapping("getAllPazientiByMedico/{id_medico}")
        public ResponseEntity<List<Paziente>> getAllPazientiByMedico(@PathVariable Long id_medico){
            return medicoService.getAllPazientiByMedico(id_medico);
        }

}
