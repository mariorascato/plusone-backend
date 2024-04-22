package it.unimol.ingegneria.ing_backend.Repository;

import it.unimol.ingegneria.ing_backend.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PersonaRepository extends JpaRepository<Persona,Long> {
    Optional<Persona> findPersonaByEmail(String email);



    Optional<Persona> findPersonaByUsername(String username);
    Optional<Persona> findPersonaByEmailAndPassword(String email, String password);
    Optional<Persona> findPersonaByPassword(String password);
}
