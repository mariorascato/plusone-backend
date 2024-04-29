package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.Infermiere;
import it.unimol.ingegneria.ing_backend.Model.Persona;
import it.unimol.ingegneria.ing_backend.Repository.InfermiereRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class InfermiereService {

    private final InfermiereRepository infermiereRepository;

    // Aggiungi infermiere
    public ResponseEntity<Infermiere> addInfermiere(Infermiere infermiere){
        if(infermiereRepository.findPersonaByCF(infermiere.getCF()).isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        else{
            infermiereRepository.save(infermiere);
            return ResponseEntity.status(HttpStatus.CREATED).body(infermiere);
        }
    }

    // Aggiorna infermiere
    public ResponseEntity<Infermiere> updateInfermiere(Infermiere infermiere,Long id){
        if(!infermiereRepository.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            Infermiere infermiereToUpdate = infermiereRepository.findById(id).get();

            infermiereToUpdate.setNome(infermiere.getNome());
            infermiereToUpdate.setCognome(infermiere.getCognome());
            infermiereToUpdate.setCF(infermiere.getCF());
            infermiereToUpdate.setEmail(infermiere.getEmail());
            infermiereToUpdate.setPassword(infermiere.getPassword());
            infermiereToUpdate.setOspedale(infermiere.getOspedale());
            infermiereToUpdate.setReparto(infermiere.getReparto());
            infermiereToUpdate.setRuolo(infermiere.getRuolo());

            infermiereRepository.save(infermiereToUpdate);

            return ResponseEntity.status(HttpStatus.OK).body(infermiereToUpdate);
        }
    }

    // Elimina infermiere
    public ResponseEntity<Infermiere> deleteInfermiere(Long id){

        if(!infermiereRepository.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        infermiereRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    // Stampa tutti gli infermieri
    public ResponseEntity<List<Infermiere>>getAll(){
        if(infermiereRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else return ResponseEntity.status(HttpStatus.OK).body(infermiereRepository.findAll());
    }
    public ResponseEntity<Persona> findInfermiereByEmail(String email){
        if (!infermiereRepository.findPersonaByEmail(email).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.FOUND).body(infermiereRepository.findPersonaByEmail(email).get());
        }
    }
    public ResponseEntity<List<Persona>> findInfermieriByNomeAndCognome(String nome,String cognome){
        if(infermiereRepository.findPersonaByNomeAndCognome(nome,cognome).get().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.FOUND).body(infermiereRepository.findPersonaByNomeAndCognome(nome,cognome).get());
        }
    }
    public ResponseEntity<Persona> findInfermiereByCF(String cf){
        if(!infermiereRepository.findPersonaByCF(cf).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.FOUND).body(infermiereRepository.findPersonaByCF(cf).get());
        }
    }


}
