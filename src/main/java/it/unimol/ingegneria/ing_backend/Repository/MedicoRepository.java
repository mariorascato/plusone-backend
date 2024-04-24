package it.unimol.ingegneria.ing_backend.Repository;
import it.unimol.ingegneria.ing_backend.Model.Medico;
import it.unimol.ingegneria.ing_backend.Model.TipologiaMedico;

import java.util.Optional;

public interface MedicoRepository extends PersonaRepository<Medico>{



    public Optional<Medico> findMedicoByReparto(String reparto);

    public Optional<Medico> findMedicoByOspedale(String ospedale);

    public Optional<Medico> findMedicoByTipologiaMedico(TipologiaMedico tipologiaMedico);


}
