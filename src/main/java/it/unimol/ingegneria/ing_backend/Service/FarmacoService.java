package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.Farmaco;
import it.unimol.ingegneria.ing_backend.Repository.FarmacoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class FarmacoService {

    private final FarmacoRepository farmacoRepository;

    // Aggiungi farmaco
    public ResponseEntity<Farmaco> addFarmaco(Farmaco farmaco){
        if(farmacoRepository.findFarmacoByCodice(farmaco.getCodice()).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        else{
            farmacoRepository.save(farmaco);
            return ResponseEntity.status(HttpStatus.CREATED).body(farmaco);
        }
    }

    // Aggiorna farmaco
    public ResponseEntity<Farmaco> updateFarmaco(Farmaco farmaco,Long id){
        if(!farmacoRepository.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            Farmaco farmacoToUpdate = farmacoRepository.findById(id).get();

            farmacoToUpdate.setCodice(farmaco.getCodice());
            farmacoToUpdate.setNome(farmaco.getNome());
            farmacoToUpdate.setCategoria(farmaco.getCategoria());
            farmacoToUpdate.setPrincipioAttivo(farmaco.getPrincipioAttivo());
            farmacoToUpdate.setAzienda(farmaco.getAzienda());

            farmacoRepository.save(farmacoToUpdate);

            return ResponseEntity.status(HttpStatus.OK).body(farmacoToUpdate);
        }
    }

    // Elimina farmaco
    public ResponseEntity<Farmaco> deleteFarmaco(Long id){

        if(!farmacoRepository.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        farmacoRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    // Stampa tutti i farmaci
    public ResponseEntity<List<Farmaco>>getAll(){
        if(farmacoRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else return ResponseEntity.status(HttpStatus.OK).body(farmacoRepository.findAll());
    }

    // Stampa farmaco da codice
    public ResponseEntity<Farmaco> findFarmacoByCodice(String codice){
        if(!farmacoRepository.findFarmacoByCodice(codice).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.FOUND).body(farmacoRepository.findFarmacoByCodice(codice).get());
        }
    }

    // Stampa farmaco da nome
    public ResponseEntity<List<Farmaco>> findFarmacoByNome(String nome){
        if(!farmacoRepository.findFarmacoByNome(nome).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.FOUND).body(farmacoRepository.findFarmacoByNome(nome).get());
        }
    }

    // Stampa farmaco da categoria
    public ResponseEntity<List<Farmaco>> findFarmacoByCategoria(String categoria){
        if(!farmacoRepository.findFarmacoByCategoria(categoria).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.FOUND).body(farmacoRepository.findFarmacoByCategoria(categoria).get());
        }
    }

    // Stampa farmaco da principioAttivo
    public ResponseEntity<List<Farmaco>> findFarmacoByPrincipioAttivo(String principioAttivo){
        if(!farmacoRepository.findFarmacoByPrincipioAttivo(principioAttivo).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.FOUND).body(farmacoRepository.findFarmacoByPrincipioAttivo(principioAttivo).get());
        }
    }

    // Stampa farmaco da azienda
    public ResponseEntity<List<Farmaco>> findFarmacoByAzienda(String azienda){
        if(!farmacoRepository.findFarmacoByAzienda(azienda).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.FOUND).body(farmacoRepository.findFarmacoByAzienda(azienda).get());
        }
    }
    
}
