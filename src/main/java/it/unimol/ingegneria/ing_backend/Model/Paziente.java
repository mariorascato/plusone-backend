package it.unimol.ingegneria.ing_backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Paziente extends Persona {

    private Indirizzo indirizzo;

    private Boolean esenzione;

    private Boolean donatoreOrgani;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JsonIgnore
    private Medico medico;

}
