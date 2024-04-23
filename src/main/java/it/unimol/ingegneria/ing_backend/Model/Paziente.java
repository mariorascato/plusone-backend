package it.unimol.ingegneria.ing_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Paziente extends Persona {

    private Indirizzo indirizzo;

    private Boolean esenzione;

    private Boolean donatoreOrgani;

    @ManyToOne
    private Medico medico;

}
