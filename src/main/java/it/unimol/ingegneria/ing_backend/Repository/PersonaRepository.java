package it.unimol.ingegneria.ing_backend.Repository;

import it.unimol.ingegneria.ing_backend.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@NoRepositoryBean
public interface PersonaRepository < T extends Persona> extends JpaRepository<T ,Long> {
    Optional<Persona> findPersonaByEmail(String email);



    Optional<Persona> findPersonaByEmailAndPassword(String email, String password);
    Optional<Persona> findPersonaByPassword(String password);
    Optional<Persona> findPersonaByCF(String CF);
}
