package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.Infermiere;
import it.unimol.ingegneria.ing_backend.Model.Persona;
import it.unimol.ingegneria.ing_backend.Repository.InfermiereRepository;
import it.unimol.ingegneria.ing_backend.Model.Persona;

import org.springframework.stereotype.Service;
import lombok.Data;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class InfermiereService {

    private final InfermiereRepository infermiereRepository;

    // Aggiungi un infermiere
    public ResponseEntity<Infermiere> addInfermiere(Infermiere infermiere){
        if(infermiereRepository.findPersonaByCF(infermiere.getCF()).isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        else{
            infermiereRepository.save(infermiere);
            return ResponseEntity.status(HttpStatus.CREATED).body(infermiere);
        }
    }

    // Aggiungi più infermieri
    public ResponseEntity<List<Infermiere>> addInfermieri(@RequestBody List<Infermiere> infermieri){
        if(infermieri.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(infermiereRepository.saveAll(infermieri));
    }

    // Aggiorna infermiere
    public ResponseEntity<Infermiere> updateInfermiere(Infermiere infermiere,Long id){
        if(infermiereRepository.findById(id).isEmpty()){
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

        if(infermiereRepository.findById(id).isEmpty()){
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
    public ResponseEntity<Persona> getInfermiereByEmail(String email){
        if (!infermiereRepository.findPersonaByEmail(email).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(infermiereRepository.findPersonaByEmail(email).get());
        }
    }

    // Stampa infermiere da email
    public ResponseEntity<Persona> getInfermiereByEmail(String email){
        if (infermiereRepository.findPersonaByEmail(email).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(infermiereRepository.findPersonaByEmail(email).get());
        }
    }

}
