package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.Esame;
import it.unimol.ingegneria.ing_backend.Model.Farmaco;
import it.unimol.ingegneria.ing_backend.Repository.EsameRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class EsameService {

    private final EsameRepository esameRepository;

    // Aggiungi esame
    public ResponseEntity<Esame> addEsame(Esame esame){
        if(esameRepository.findEsameByCodice(esame.getCodice()).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        else{
            esameRepository.save(esame);
            return ResponseEntity.status(HttpStatus.OK).body(esame);
        }
    }
    public ResponseEntity<List<Esame>> addEsami(List<Esame> esami){
        return ResponseEntity.status(HttpStatus.OK).body(esameRepository.saveAll(esami));
    }

    // Aggiorna esame
    public ResponseEntity<Esame> updateEsame(Esame esame, Long id){
        if(esameRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            Esame esameToUpdate = esameRepository.findById(id).get();

            esameToUpdate.setCodice(esame.getCodice());
            esameToUpdate.setNome(esame.getNome());

            esameRepository.save(esameToUpdate);

            return ResponseEntity.status(HttpStatus.OK).body(esameToUpdate);
        }
    }

    // Elimina esame
    public ResponseEntity<Esame> deleteEsame(Long id){

        if(esameRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        esameRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    // Stampa tutti gli esami
    public ResponseEntity<List<Esame>>getAll(){
        if(esameRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else return ResponseEntity.status(HttpStatus.OK).body(esameRepository.findAll());
    }

}
