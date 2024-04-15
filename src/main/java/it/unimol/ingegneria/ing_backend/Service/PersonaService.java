package it.unimol.ingegneria.ing_backend.Service;


import it.unimol.ingegneria.ing_backend.Model.Persona;
import it.unimol.ingegneria.ing_backend.Repository.PersonaRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonaService {

    private PersonaRepository personaRepository;

    public Persona addPersona(Persona persona){
        return personaRepository.save(persona);
    }
    public Persona findByEmail(String email) {
        return personaRepository.findPersonaByEmail(email);
    }

    public Persona findByUsername(String username) {
        return personaRepository.findPersonaByUsername(username);
    }
    public Persona findByPassword(String password) {
        return  personaRepository.findPersonaByPassword( password);
    }
    public List<Persona> getAll(){
        return personaRepository.findAll();
    }



     

}