package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.Paziente;
import it.unimol.ingegneria.ing_backend.Model.Triage;
import it.unimol.ingegneria.ing_backend.Repository.PazienteRepository;
import it.unimol.ingegneria.ing_backend.Repository.TriageRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TriageService {
    private final TriageRepository triageRepository;
    private final PazienteRepository pazienteRepository;
    public ResponseEntity<Triage> addTriage(Triage triage, Long id_paziente){

        if(pazienteRepository.findById(id_paziente).isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Paziente paziente = pazienteRepository.findById(id_paziente).get();
        triage.setPaziente(paziente);
        return ResponseEntity.status(HttpStatus.OK).body(triageRepository.save(triage));
    }

    public ResponseEntity <List<Triage>> getAllTriage(){
        if(triageRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(triageRepository.findAll());
        }
    }
}
