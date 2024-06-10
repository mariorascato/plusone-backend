package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.HashedPassword;
import it.unimol.ingegneria.ing_backend.Model.Persona;
import it.unimol.ingegneria.ing_backend.Repository.PersonaRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class PersonaService {
    private final PersonaRepository<Persona> personaRepository;

    public ResponseEntity<Persona> updatePassword(Long id, HashedPassword password) {
        Persona persona;

        if (personaRepository.findById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        persona = personaRepository.findById(id).get();
        persona.setPassword(password.getHashedPassword());

        personaRepository.save(persona);

        return ResponseEntity.status(HttpStatus.OK).body(persona);


    }
}
