package it.unimol.ingegneria.ing_backend.Controller;
import it.unimol.ingegneria.ing_backend.Model.Persona;
import it.unimol.ingegneria.ing_backend.Service.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:8100")
public class PersonaController {

    private PersonaService personaService;

    @GetMapping("getAll")
    public List<Persona> getAllUsers() {
        return personaService.getAll();
    }

    @PostMapping("addUser")
    public ResponseEntity<Persona> addPersona(@RequestBody Persona persona) {
        if(personaService.findByEmail(persona.getEmail()).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        else return ResponseEntity.status(HttpStatus.CREATED).body(persona);
    }

    @GetMapping("getUserByEmailAndPassword/{email}/{password}")
    public ResponseEntity<Persona> getByUserByEmailAndByPassword(@PathVariable String email, @PathVariable String password) {
        if (personaService.findByEmailAndPassword(password, email).isPresent()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(personaService.findByEmailAndPassword(password, email).get());
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }
   /* @GetMapping("getUserByUsername/{username}")
    public Persona getByUsername(@PathVariable String username) {
        return personaService.findByUsername(username);


    }

    */
    @GetMapping("GetUserByEmail/{email}")
    public ResponseEntity<Persona> getByEmail(@PathVariable String email) {
        if(personaService.findByEmail(email).isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(personaService.findByEmail(email).get());
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        @DeleteMapping("RemoveUser/{id}")
        public ResponseEntity<Persona> removePersonById(@PathVariable Long id){
            if(personaService.getPersonaById(id).isPresent()) {
                personaService.deletePerson(id);
                return ResponseEntity.status(HttpStatus.OK).build();
            }
            else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        }










