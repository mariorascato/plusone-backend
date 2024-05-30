package it.unimol.ingegneria.ing_backend.Service;


import it.unimol.ingegneria.ing_backend.Model.Conferma;
import it.unimol.ingegneria.ing_backend.Model.Medico;
import it.unimol.ingegneria.ing_backend.Model.Paziente;
import it.unimol.ingegneria.ing_backend.Model.Triage;
import it.unimol.ingegneria.ing_backend.Repository.TriageRepository;
import it.unimol.ingegneria.ing_backend.Model.Paziente;
import it.unimol.ingegneria.ing_backend.Repository.PazienteRepository;
import it.unimol.ingegneria.ing_backend.Model.Conferma;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class TriageService {

    private final TriageRepository triageRepository;
    private final PazienteRepository pazienteRepository;

    // Aggiungi triage
    public ResponseEntity<Triage> addTriage(Triage triage, Long id_paziente){
        if(pazienteRepository.findById(id_paziente).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Paziente paziente = pazienteRepository.findById(id_paziente).get();
        paziente.getTriages().add(triage);
        pazienteRepository.save(paziente);
        triage.setPaziente(paziente);
        return ResponseEntity.status(HttpStatus.OK).body(triageRepository.save(triage));
    }

    // Stampa tutti i triage
    public ResponseEntity <List<Triage>> getAllTriage(){
        if(triageRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(triageRepository.findAll());
        }
    }

    // Aggiorna triage
    public ResponseEntity<Triage> updateTriage(Triage triage, Long id){
        if(triageRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            Triage triageToUpdate = triageRepository.findById(id).get();

            triageToUpdate.setLatitudine(triage.getLatitudine());
            triageToUpdate.setLongitudine(triage.getLongitudine());
            triageToUpdate.setColore(triage.getColore());
            triageToUpdate.setDescrizione(triage.getDescrizione());

            triageRepository.save(triageToUpdate);
            return ResponseEntity.status(HttpStatus.OK).body(triageToUpdate);
        }
    }

    // Elimina triage
    public ResponseEntity<Triage> deleteTriage(Long id){

        if(triageRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        triageRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    public ResponseEntity<Triage> setState(Long id,Conferma conferma){
        if(triageRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Triage triage = triageRepository.findById(id).get();
        triage.setConferma(conferma);
        return ResponseEntity.status(HttpStatus.OK).body(triageRepository.save(triage));
    }


}
