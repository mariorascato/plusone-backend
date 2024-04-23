package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.Paziente;
import it.unimol.ingegneria.ing_backend.Repository.PazienteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class PazienteService {

    private final PazienteRepository pazienteRepository;

   public ResponseEntity<Paziente> addPaziente(Paziente paziente){
        if(pazienteRepository.findPersonaByCF(paziente.getCF()).isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        else{
            pazienteRepository.save(paziente);
            return ResponseEntity.status(HttpStatus.CREATED).body(paziente);
        }
    }

}
