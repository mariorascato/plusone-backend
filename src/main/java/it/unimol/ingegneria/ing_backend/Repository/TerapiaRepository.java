package it.unimol.ingegneria.ing_backend.Repository;

import it.unimol.ingegneria.ing_backend.Model.Terapia;
import it.unimol.ingegneria.ing_backend.Model.TipologiaTerapia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TerapiaRepository extends JpaRepository<Terapia,Long> {
    Optional<List<Terapia>> findTerapiaByTipologiaTerapia(TipologiaTerapia tipologiaTerapia);
}
