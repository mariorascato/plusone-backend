package it.unimol.ingegneria.ing_backend.Repository;

import it.unimol.ingegneria.ing_backend.Model.Tfarmacologica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TfarmacologicaRepository  extends JpaRepository<Tfarmacologica,Long> {
    public Optional<List<Tfarmacologica>> findTfarmacologicaByAttivoTrue();
    public Optional<List<Tfarmacologica>> findTfarmacologicaByAttivoFalse();
}
