package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.*;
import it.unimol.ingegneria.ing_backend.Repository.PazienteRepository;

import org.springframework.stereotype.Service;
import lombok.Data;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
@Data
public class PazienteService {

    private final PazienteRepository pazienteRepository;

    // Aggiungi un paziente
    public ResponseEntity<Paziente> addPaziente(Paziente paziente){
        if(pazienteRepository.findPersonaByCF(paziente.getCF()).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        else{
            pazienteRepository.save(paziente);
            return ResponseEntity.status(HttpStatus.OK).body(paziente);
        }
    }

    // Aggiungi più pazienti
    public ResponseEntity<List<Paziente>> addPazienti(List<Paziente> pazienti){
        if(pazienti.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(pazienteRepository.saveAll(pazienti));
    }

    // Aggiorna paziente
    public ResponseEntity<Paziente> updatePaziente(Paziente paziente,Long id){

       if(pazienteRepository.findById(id).isEmpty()){
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

    // Stampa tutti i pazienti
    public ResponseEntity<List<Paziente>>getAll(){
        if(pazienteRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(pazienteRepository.findAll());
        }
    }

    // Stampa pazienti attivi
    public ResponseEntity<List<Paziente>> getAllAttivi() {
        if(pazienteRepository.findAllByAttivoTrue().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(pazienteRepository.findAllByAttivoTrue().get());
        }
    }

    // Stampa pazienti non attivi
    public ResponseEntity<List<Paziente>> getAllInattivi() {
        if(pazienteRepository.findAllByAttivoFalse().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(pazienteRepository.findAllByAttivoFalse().get());
        }
    }

    // Stampa paziente da cf
    public ResponseEntity<Persona> findPazienteByCF(String cf){
        if(pazienteRepository.findPersonaByCF(cf).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(pazienteRepository.findPersonaByCF(cf).get());
        }
    }

    // Stampa paziente da nome e cognome
    public ResponseEntity<List<Persona>> findPazientiByNomeAndCognome(String nome,String cognome){
        if(pazienteRepository.findPersonaByNomeAndCognome(nome,cognome).get().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(pazienteRepository.findPersonaByNomeAndCognome(nome,cognome).get());
        }
    }

    // Stampa paziente da email
    public ResponseEntity<Persona> findPazienteByEmail(String email){
        if (pazienteRepository.findPersonaByEmail(email).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(pazienteRepository.findPersonaByEmail(email).get());
        }
    }

    // Stampa paziente da citta
    public ResponseEntity<List<Paziente>> findPazientiByCitta(String citta){
            List<Paziente> pazienti = new ArrayList<>();
        for (Paziente paziente: pazienteRepository.findAll()) {
            if(paziente.getIndirizzo().getCittà().equalsIgnoreCase(citta)) {
                pazienti.add(paziente);
            }
        }
        if(pazienti.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(pazienti);
        }

    }

    // Attiva il paziente verificando la sua registrazione
    public ResponseEntity<Persona> activatePaziente(Long id) {
        Optional<Paziente> paziente = pazienteRepository.findById(id);

        if(paziente.isPresent()) {
            paziente.get().setAttivo(true);
            pazienteRepository.save(paziente.get());
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Elimina paziente
    public ResponseEntity<Persona> deletePaziente(Long id){
        if(pazienteRepository.findById(id).isPresent()){
            pazienteRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Stampa il medico del paziente
    public ResponseEntity<Medico> getMedicoOfPaziente(Long id_paziente){
        Medico medico;
        if(pazienteRepository.findById(id_paziente).isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            medico = pazienteRepository.findById(id_paziente).get().getMedico();

            if(medico==null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            }
            else return ResponseEntity.status(HttpStatus.OK).body(medico);
        }
    }
    public ResponseEntity<List<Terapia>> getAllTerapieByPaziente(Long id){
        if(pazienteRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(pazienteRepository.findById(id).get().getTerapie());
    }
    public ResponseEntity<List<Tfarmacologica>> getAllTerapieFarmacologicaByPaziente(Long id){
        if(pazienteRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(pazienteRepository.findById(id).get().getTerapieFarmacologiche());
    }

}
