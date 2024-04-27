package it.unimol.ingegneria.ing_backend.Repository;

import it.unimol.ingegneria.ing_backend.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;


@NoRepositoryBean
public interface PersonaRepository < T extends Persona> extends JpaRepository<T ,Long> {
    Optional<Persona> findPersonaByEmail(String email);

    Optional<Persona> findPersonaByCF(String CF);
    Optional<List<Persona>> findPersonaByNomeAndCognome(String nome, String cognome);
}
