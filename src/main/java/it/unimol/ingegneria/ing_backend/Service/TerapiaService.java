package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.Medico;
import it.unimol.ingegneria.ing_backend.Model.Paziente;
import it.unimol.ingegneria.ing_backend.Model.Terapia;
import it.unimol.ingegneria.ing_backend.Model.TipologiaTerapia;
import it.unimol.ingegneria.ing_backend.Repository.MedicoRepository;
import it.unimol.ingegneria.ing_backend.Repository.PazienteRepository;
import it.unimol.ingegneria.ing_backend.Repository.TerapiaRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class TerapiaService {

    private final TerapiaRepository terapiaRepository;
    private final MedicoRepository medicoRepository;
    private final PazienteRepository pazienteRepository;
    public ResponseEntity<Terapia> addTerapia(Terapia terapia,Long id_medico,Long id_paziente){

            Medico medico;
            Paziente paziente;

            if(!medicoRepository.findById(id_medico).isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            else {
                medico = medicoRepository.findById(id_medico).get();
            }
            if(!pazienteRepository.findById(id_paziente).isPresent()){
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
    public ResponseEntity <List<Terapia>> getAllTerapie(){
        return ResponseEntity.status(HttpStatus.FOUND).body(terapiaRepository.findAll());
    }
    public ResponseEntity<Medico> getMedicoByTerapia(Long id){
        if(!terapiaRepository.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else return ResponseEntity.status(HttpStatus.FOUND).body(terapiaRepository.findById(id).get().getMedicoCurante());
    }
    public ResponseEntity<Paziente> getPazienteByTerapia(Long id){
        if(!terapiaRepository.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else return ResponseEntity.status(HttpStatus.FOUND).body(terapiaRepository.findById(id).get().getPaziente());
    }
    public ResponseEntity<List<Terapia>> getTerapieByTipologia(TipologiaTerapia tipologiaTerapia){
        if(terapiaRepository.findTerapiaByTipologiaTerapia(tipologiaTerapia).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.FOUND).body(terapiaRepository.findTerapiaByTipologiaTerapia(tipologiaTerapia).get());
        }
    }


}
