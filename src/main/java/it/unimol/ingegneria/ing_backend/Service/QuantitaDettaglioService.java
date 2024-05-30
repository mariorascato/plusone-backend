package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.*;
import it.unimol.ingegneria.ing_backend.Repository.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class QuantitaDettaglioService {

    private final QuantitaDettaglioRepository quantitaDettaglioRepository;
    private final FarmacoRepository farmacoRepository;
    private final TfarmacologicaRepository tfarmacologicaRepository;

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // Aggiungi quantita dettaglio
    public ResponseEntity<QuantitaDettaglio> addQuantitaDettaglio(QuantitaDettaglio quantitaDettaglio, Long id_farmaco, Long id_tfarmacologica){
        Farmaco farmaco;
        Tfarmacologica tfarmacologica;

        // Controllo esistenza farmaco
        if(farmacoRepository.findById(id_farmaco).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            farmaco = farmacoRepository.findById(id_farmaco).get();
        }

        // Controllo esistenza terapia farmacologica
        if(tfarmacologicaRepository.findById(id_tfarmacologica).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            tfarmacologica = tfarmacologicaRepository.findById(id_tfarmacologica).get();
        }

        quantitaDettaglio.setFarmaco(farmaco);
        quantitaDettaglio.setTfarmacologica(tfarmacologica);

        quantitaDettaglioRepository.save(quantitaDettaglio);
        return ResponseEntity.status(HttpStatus.OK).body(quantitaDettaglio);

    }

    // Aggiorna quantita dettaglio
    public ResponseEntity<QuantitaDettaglio> updateQuantitaDettaglio(QuantitaDettaglio quantitaDettaglio, Long id){
        if(quantitaDettaglioRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            QuantitaDettaglio quantitaDettaglioToUpdate = quantitaDettaglioRepository.findById(id).get();

            quantitaDettaglioToUpdate.setQuantita(quantitaDettaglio.getQuantita());
            quantitaDettaglioToUpdate.setNote(quantitaDettaglio.getNote());

            quantitaDettaglioRepository.save(quantitaDettaglioToUpdate);
            return ResponseEntity.status(HttpStatus.OK).body(quantitaDettaglioToUpdate);
        }
    }

    // Stampa tutte le quantita dettaglio
    public ResponseEntity<List<QuantitaDettaglio>> getAll(){
        if(quantitaDettaglioRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(quantitaDettaglioRepository.findAll());
        }
    }

    // Elimina quantita dettaglio
    public ResponseEntity<QuantitaDettaglio> deleteQuantitaDettaglio(Long id){
        if(quantitaDettaglioRepository.findById(id).isPresent()){
            quantitaDettaglioRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

}
