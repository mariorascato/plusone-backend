package it.unimol.ingegneria.ing_backend.Service;


import it.unimol.ingegneria.ing_backend.Model.Persona;
import it.unimol.ingegneria.ing_backend.Repository.PersonaRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonaService {

    private PersonaRepository personaRepository;

    public Persona addPersona(Persona persona){
        return personaRepository.save(persona);
    }
    public Optional<Persona> findByEmail(String email) {
        return personaRepository.findPersonaByEmail(email);
    }

    public Optional<Persona> findByUsername(String username) {
        return personaRepository.findPersonaByUsername(username);
    }
    public Optional<Persona> findByEmailAndPassword(String password,String email) {
        return  personaRepository.findPersonaByEmailAndPassword(email,password);
    }
    public List<Persona>getAll(){
        return personaRepository.findAll();
    }
    public Optional<Persona> getPersonaById(Long id){
        return personaRepository.findById(id);
    }
    public void deletePerson(long id){

            personaRepository.deleteById(id);



    }



     

}