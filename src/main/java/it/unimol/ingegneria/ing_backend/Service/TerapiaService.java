package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.Terapia;
import it.unimol.ingegneria.ing_backend.Repository.TerapiaRepository;
import it.unimol.ingegneria.ing_backend.Model.TipologiaTerapia;
import it.unimol.ingegneria.ing_backend.Model.Medico;
import it.unimol.ingegneria.ing_backend.Repository.MedicoRepository;
import it.unimol.ingegneria.ing_backend.Model.Paziente;
import it.unimol.ingegneria.ing_backend.Repository.PazienteRepository;

import org.springframework.stereotype.Service;
import lombok.Data;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class TerapiaService {

    private final TerapiaRepository terapiaRepository;
    private final MedicoRepository medicoRepository;
    private final PazienteRepository pazienteRepository;

    // Aggiungi terapia
    public ResponseEntity<Terapia> addTerapia(Terapia terapia,Long id_medico,Long id_paziente){

            Medico medico;
            Paziente paziente;

            // Controllo esistenza medico
            if(medicoRepository.findById(id_medico).isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            else {
                medico = medicoRepository.findById(id_medico).get();
            }

            // Controllo esistenza paziente
            if(pazienteRepository.findById(id_paziente).isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            else {
                paziente = pazienteRepository.findById(id_paziente).get();
            }

            terapia.setPaziente(paziente);
            terapia.setMedicoCurante(medico);
            terapiaRepository.save(terapia);
            return ResponseEntity.status(HttpStatus.CREATED).body(terapia);

    }

    // Stampa tutte le terapie
    public ResponseEntity <List<Terapia>> getAllTerapie(){
        return ResponseEntity.status(HttpStatus.FOUND).body(terapiaRepository.findAll());
    }

    // Stampa il medico della terapia
    public ResponseEntity<Medico> getMedicoByTerapia(Long id){
        if(terapiaRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else return ResponseEntity.status(HttpStatus.OK).body(terapiaRepository.findById(id).get().getMedicoCurante());
    }

    // Stampa il paziente della terapia
    public ResponseEntity<Paziente> getPazienteByTerapia(Long id){
        if(terapiaRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else return ResponseEntity.status(HttpStatus.OK).body(terapiaRepository.findById(id).get().getPaziente());
    }

    // Stampa le terapie di una tipologia
    public ResponseEntity<List<Terapia>> getTerapieByTipologia(TipologiaTerapia tipologiaTerapia){
        if(terapiaRepository.findTerapiaByTipologiaTerapia(tipologiaTerapia).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(terapiaRepository.findTerapiaByTipologiaTerapia(tipologiaTerapia).get());
        }
    }
    public ResponseEntity<Terapia> setState(Long id,boolean state){
        if(terapiaRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Terapia terapia = terapiaRepository.findById(id).get();
        terapia.setAttivo(state);

        terapiaRepository.save(terapia);
        return ResponseEntity.status(HttpStatus.OK).body(terapia);
    }
    public ResponseEntity<Terapia> deleteTerapia(Long id){
        if(terapiaRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Terapia terapia =  terapiaRepository.findById(id).get();
        terapiaRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body(terapia);
    }


}
