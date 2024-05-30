package it.unimol.ingegneria.ing_backend.Repository;

import it.unimol.ingegneria.ing_backend.Model.Segnalazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegnalazioneRepository extends JpaRepository<Segnalazione,Long> {
}
