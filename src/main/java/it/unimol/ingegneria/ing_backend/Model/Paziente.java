package it.unimol.ingegneria.ing_backend.Model;

import lombok.Data;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Data
@Entity
public class Paziente extends Persona {

    private Indirizzo indirizzo;

    private Boolean esenzione;

    private Boolean donatoreOrgani;

    // Relazione con medico
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JsonIgnore
    private Medico medico;

    // Relazione con terapie
    @OneToMany(mappedBy = "paziente", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Terapia> terapie;

    @OneToMany(mappedBy = "paziente", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Tfarmacologica> terapieFarmacologiche;

    // Relazione con farmaco
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Farmaco> farmaci;

    // Relazione con triage
    @OneToMany(mappedBy = "paziente", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Triage> triages;

}
