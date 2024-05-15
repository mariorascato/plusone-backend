package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.Paziente;
import it.unimol.ingegneria.ing_backend.Model.Tfarmacologica;
import it.unimol.ingegneria.ing_backend.Repository.FarmacoRepository;
import it.unimol.ingegneria.ing_backend.Model.Farmaco;
import it.unimol.ingegneria.ing_backend.Repository.TfarmacologicaRepository;

import org.springframework.stereotype.Service;
import lombok.Data;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class TfarmacologicaService {

    private final TfarmacologicaRepository tfarmacologicaRepository;
    private final FarmacoRepository farmacoRepository;

    // Aggiungi terapia farmacologica
    public ResponseEntity<Tfarmacologica> addTfarmacologica(Tfarmacologica tfarmacologica){
        tfarmacologicaRepository.save(tfarmacologica);
        return ResponseEntity.status(HttpStatus.CREATED).body(tfarmacologica);
    }

    // Aggiorna terapia farmacologica
    public ResponseEntity<Tfarmacologica> updateTfarmacologica(Tfarmacologica tfarmacologica, Long id){
        if(tfarmacologicaRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            Tfarmacologica tfarmacologicaToUpdate = tfarmacologicaRepository.findById(id).get();

            tfarmacologicaToUpdate.setEsame(tfarmacologica.getEsame());

            tfarmacologicaRepository.save(tfarmacologicaToUpdate);
            return ResponseEntity.status(HttpStatus.OK).body(tfarmacologicaToUpdate);
        }
    }

    // Stampa tutte le terapie farmacologiche
    public ResponseEntity<List<Tfarmacologica>> getAll(){
        if(tfarmacologicaRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(tfarmacologicaRepository.findAll());
        }
    }

    // Elimina terapia farmacologica
    public ResponseEntity<Tfarmacologica> deleteTfarmacologica(Long id){
        if(tfarmacologicaRepository.findById(id).isPresent()){
            tfarmacologicaRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Aggiungi un farmaco a terapia farmacologica
    public ResponseEntity<Tfarmacologica> addFarmacoToTfarmacologica(Long id_farmaco,Long id_tfarmacologica){
        Farmaco farmaco;
        Tfarmacologica tfarmacologica;
        if(farmacoRepository.findById(id_farmaco).isPresent()){
            farmaco = farmacoRepository.findById(id_farmaco).get();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        if(tfarmacologicaRepository.findById(id_tfarmacologica).isPresent()){
            tfarmacologica = tfarmacologicaRepository.findById(id_tfarmacologica).get();
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        tfarmacologica.getFarmaci().add(farmaco);
        tfarmacologicaRepository.save(tfarmacologica);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Stampa tutti i farmaci di una terapia farmacologica
    public ResponseEntity<List<Farmaco>> getAllFarmaciOfTfarmacologica(Long id_tfarmacologica){
        Tfarmacologica tfarmacologica;
        if(tfarmacologicaRepository.findById(id_tfarmacologica).isPresent()){
            tfarmacologica = tfarmacologicaRepository.findById(id_tfarmacologica).get();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(tfarmacologica.getFarmaci());
    }

    // Rimuovi farmaco da una terapia farmacologica
    public ResponseEntity<Farmaco> removeFarmacoOfTfarmacologica(Long id_farmaco, Long id_tfarmacologica){
        Tfarmacologica tfarmacologica;
        Farmaco farmaco;

        if(tfarmacologicaRepository.findById(id_tfarmacologica).isPresent()){
            tfarmacologica = tfarmacologicaRepository.findById(id_tfarmacologica).get();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if(farmacoRepository.findById(id_farmaco).isPresent()){
            farmaco = farmacoRepository.findById(id_farmaco).get();
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        tfarmacologica.getFarmaci().remove(farmaco);
        tfarmacologicaRepository.save(tfarmacologica);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
