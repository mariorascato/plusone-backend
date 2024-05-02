package it.unimol.ingegneria.ing_backend.Repository;

import it.unimol.ingegneria.ing_backend.Model.Paziente;
import org.springframework.stereotype.Repository;

@Repository
public interface PazienteRepository extends PersonaRepository<Paziente> {

}
