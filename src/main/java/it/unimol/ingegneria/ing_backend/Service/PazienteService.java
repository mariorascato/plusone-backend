package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.Paziente;
import it.unimol.ingegneria.ing_backend.Model.Persona;
import it.unimol.ingegneria.ing_backend.Repository.PazienteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Data
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
    public ResponseEntity<Paziente> updatePaziente(Paziente paziente,Long id){

       if(!pazienteRepository.findById(id).isPresent()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       else{
           Paziente pazienteToUpdate = pazienteRepository.findById(id).get();

           pazienteToUpdate.setNome(paziente.getNome());
           pazienteToUpdate.setCognome(paziente.getCognome());
           pazienteToUpdate.setCF(paziente.getCF());
           pazienteToUpdate.setIndirizzo(paziente.getIndirizzo());
           pazienteToUpdate.setEmail(paziente.getEmail());
           pazienteToUpdate.setMedico(paziente.getMedico());
           pazienteToUpdate.setPassword(paziente.getPassword());
           pazienteToUpdate.setEsenzione(paziente.getEsenzione());
           pazienteToUpdate.setDonatoreOrgani(paziente.getDonatoreOrgani());

           pazienteRepository.save(pazienteToUpdate);

           return ResponseEntity.status(HttpStatus.OK).body(pazienteToUpdate);
       }
    }
    public ResponseEntity<List<Paziente>> getAll(){
        if(!pazienteRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(pazienteRepository.findAll());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
    public ResponseEntity<Persona> findPazienteByCF(String cf){
        if(!pazienteRepository.findPersonaByCF(cf).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.FOUND).body(pazienteRepository.findPersonaByCF(cf).get());
        }
    }
    public ResponseEntity<List<Persona>> findPazientiByNomeAndCognome(String nome,String cognome){
        if(pazienteRepository.findPersonaByNomeAndCognome(nome,cognome).get().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.FOUND).body(pazienteRepository.findPersonaByNomeAndCognome(nome,cognome).get());
        }
    }
    public ResponseEntity<Persona> findPazienteByEmail(String email){
        if (!pazienteRepository.findPersonaByEmail(email).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.FOUND).body(pazienteRepository.findPersonaByEmail(email).get());
        }
    }
    public ResponseEntity<Persona> deletePaziente(Long id){
        if(pazienteRepository.findById(id).isPresent()){
            pazienteRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
