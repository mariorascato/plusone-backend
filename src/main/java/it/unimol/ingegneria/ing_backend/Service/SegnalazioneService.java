package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.Persona;
import it.unimol.ingegneria.ing_backend.Model.Segnalazione;
import it.unimol.ingegneria.ing_backend.Repository.PersonaRepository;
import it.unimol.ingegneria.ing_backend.Repository.SegnalazioneRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class SegnalazioneService {
    private final SegnalazioneRepository segnalazioneRepository;
    private final PersonaRepository<Persona> personaRepository;

    public ResponseEntity<Segnalazione> addSegnalazione(Segnalazione segnalazione,Long id_utente){
        Persona utente;
        if(personaRepository.findById(id_utente).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            utente = personaRepository.findById(id_utente).get();
            segnalazione.setUtente(utente);
            return ResponseEntity.status(HttpStatus.OK).body(segnalazioneRepository.save(segnalazione));
        }

    }
    public ResponseEntity<List<Segnalazione>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(segnalazioneRepository.findAll());
    }


}
