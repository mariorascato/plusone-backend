package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.Medico;
import it.unimol.ingegneria.ing_backend.Model.Paziente;
import it.unimol.ingegneria.ing_backend.Repository.MedicoRepository;
import it.unimol.ingegneria.ing_backend.Repository.PazienteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
@AllArgsConstructor
public class MedicoService {

        private final MedicoRepository medicoRepository;
        private final PazienteRepository pazienteRepository;
        public ResponseEntity<Medico> addMedico(Medico medico){
            if(medicoRepository.findPersonaByCF(medico.getCF()).isPresent()){

                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
            }
            else{
                medicoRepository.save(medico);
                return ResponseEntity.status(HttpStatus.CREATED).body(medico);
            }
        }
        public ResponseEntity<Medico> updateMedico(Medico medico,Long id){
            if(!medicoRepository.findById(id).isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            else{
                Medico medicoToUpdate = medicoRepository.findById(id).get();

                medicoToUpdate.setNome(medico.getNome());
                medicoToUpdate.setCognome(medico.getCognome());
                medicoToUpdate.setCF(medico.getCF());
                medicoToUpdate.setEmail(medico.getEmail());
                medicoToUpdate.setPassword(medico.getPassword());
                medicoToUpdate.setTipologiaMedico(medico.getTipologiaMedico());
                medicoToUpdate.setRuolo(medico.getRuolo());
                medicoToUpdate.setReparto(medico.getReparto());
                medicoToUpdate.setOspedale(medico.getOspedale());

                medicoRepository.save(medicoToUpdate);

                return ResponseEntity.status(HttpStatus.OK).body(medicoToUpdate);
            }
        }

        public ResponseEntity<Medico> deleteMedico(Long id){
            if(!medicoRepository.findById(id).isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            else{
                medicoRepository.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        }

        public ResponseEntity<List<Medico>>getAll(){
            if(medicoRepository.findAll().isEmpty()){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            else return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findAll());
        }
        public ResponseEntity<Medico> addPazienteToMedico(Long id_medico,Long id_paziente){
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

            paziente.setMedico(medico);

            pazienteRepository.save(paziente);


            return ResponseEntity.status(HttpStatus.OK).body(medico);
        }
        public ResponseEntity<List<Paziente>> getAllPazientiByMedico(Long id_medico){
            Medico medico;
            if(!medicoRepository.findById(id_medico).isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            else{
                medico = medicoRepository.findById(id_medico).get();
            }
            return ResponseEntity.status(HttpStatus.OK).body(medico.getPazienti());
        }
}
