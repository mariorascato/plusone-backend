package it.unimol.ingegneria.ing_backend.Repository;

import it.unimol.ingegneria.ing_backend.Model.Paziente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PazienteRepository extends PersonaRepository<Paziente> {
    public Optional<List<Paziente>> findAllByAttivoTrue();

    public Optional<List<Paziente>> findAllByAttivoFalse();
}
