package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.Medico;
import it.unimol.ingegneria.ing_backend.Model.Paziente;
import it.unimol.ingegneria.ing_backend.Model.Tfarmacologica;
import it.unimol.ingegneria.ing_backend.Repository.FarmacoRepository;
import it.unimol.ingegneria.ing_backend.Model.Farmaco;
import it.unimol.ingegneria.ing_backend.Repository.MedicoRepository;
import it.unimol.ingegneria.ing_backend.Repository.PazienteRepository;
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
    private final MedicoRepository medicoRepository;
    private final PazienteRepository pazienteRepository;

    // Aggiungi terapia farmacologica
    public ResponseEntity<Tfarmacologica> addTfarmacologica(Tfarmacologica tfarmacologica,Long id_medico,Long id_paziente){
        Medico medico;
        Paziente paziente;

        // Controllo esistenza medico
        if(!medicoRepository.findById(id_medico).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            medico = medicoRepository.findById(id_medico).get();
        }

        // Controllo esistenza paziente
        if(!pazienteRepository.findById(id_paziente).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            paziente = pazienteRepository.findById(id_paziente).get();
        }

        tfarmacologica.setPaziente(paziente);
        tfarmacologica.setMedico(medico);

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
            tfarmacologicaToUpdate.setPaziente(tfarmacologica.getPaziente());
            tfarmacologicaToUpdate.setMedico(tfarmacologica.getMedico());

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
    public ResponseEntity<Medico> getMedicoByTFarmacologica(Long id){
        if(!tfarmacologicaRepository.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else return ResponseEntity.status(HttpStatus.FOUND).body(tfarmacologicaRepository.findById(id).get().getMedico());
    }
    public ResponseEntity<Paziente> getPazienteByTFarmacologica(Long id){
        if(!tfarmacologicaRepository.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else return ResponseEntity.status(HttpStatus.FOUND).body(tfarmacologicaRepository.findById(id).get().getPaziente());
    }



}
