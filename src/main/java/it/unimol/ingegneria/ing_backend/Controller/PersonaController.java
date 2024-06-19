package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.HashedPassword;
import it.unimol.ingegneria.ing_backend.Model.Persona;
import it.unimol.ingegneria.ing_backend.Service.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/persona")
@CrossOrigin(origins = "*")
public class PersonaController {

    private final PersonaService personaService;

    @PutMapping("updatePersonaPassword/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody HashedPassword password){
        return this.personaService.updatePassword(id,password);
    }

}
