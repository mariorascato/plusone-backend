package it.unimol.ingegneria.ing_backend.Repository;

import it.unimol.ingegneria.ing_backend.Model.Indirizzo;
import it.unimol.ingegneria.ing_backend.Model.Paziente;
import it.unimol.ingegneria.ing_backend.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PazienteRepository extends PersonaRepository<Paziente> {
    public Optional<Paziente>  findPazienteByIndirizzo(Indirizzo indirizzo);
}
