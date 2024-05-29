package it.unimol.ingegneria.ing_backend.Repository;

import it.unimol.ingegneria.ing_backend.Model.Esame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EsameRepository extends JpaRepository<Esame,Long> {
    Optional<Esame> findEsameByCodice(String codice);
}
