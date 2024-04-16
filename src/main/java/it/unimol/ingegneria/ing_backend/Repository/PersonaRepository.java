package it.unimol.ingegneria.ing_backend.Repository;

import it.unimol.ingegneria.ing_backend.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PersonaRepository extends JpaRepository<Persona,Long> {
    Persona findPersonaByEmail(String email);
    Persona findPersonaByUsername(String username);
    Persona findPersonaByEmailAndPassword(String email, String password);
    Persona findPersonaByPassword(String password);
}
