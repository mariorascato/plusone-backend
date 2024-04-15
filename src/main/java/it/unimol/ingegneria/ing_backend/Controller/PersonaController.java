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
public class PersonaController {

    private PersonaService personaService;
    @GetMapping("getAll")
    public List<Persona> getAllUsers(){
        return personaService.getAll();
    }

    @PostMapping("addUser")
    public Persona addPersona(@RequestBody Persona persona){
       return personaService.addPersona(persona);
    }

    @GetMapping("getUserByUsername/{username}")
    public Persona getByUsername(@PathVariable String username) {
        return personaService.findByUsername(username);
    }
    @GetMapping("GetUserByEmail/{email}")
    public Persona getByEmail(@PathVariable String email) {
        return personaService.findByEmail(email);
    }




}



