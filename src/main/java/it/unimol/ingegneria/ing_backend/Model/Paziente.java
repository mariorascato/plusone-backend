package it.unimol.ingegneria.ing_backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Paziente extends Persona {

    private Indirizzo indirizzo;

    private Boolean esenzione;

    private Boolean donatoreOrgani;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JsonIgnore
    private Medico medico;

    @OneToMany(mappedBy = "paziente", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Terapia> terapie;

}
