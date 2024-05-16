package it.unimol.ingegneria.ing_backend.Repository;

import it.unimol.ingegneria.ing_backend.Model.Farmaco;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface FarmacoRepository extends JpaRepository<Farmaco,Long> {

    Optional<Farmaco> findFarmacoByCodice(String codice);
    Optional<List<Farmaco>> findFarmacoByNome(String nome);
    Optional<List<Farmaco>> findFarmacoByCategoria(String categoria);
    Optional<List<Farmaco>> findFarmacoByPrincipioAttivo(String principioAttivo);
    Optional<List<Farmaco>> findFarmacoByAzienda(String azienda);

}
