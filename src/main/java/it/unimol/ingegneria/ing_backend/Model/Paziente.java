package it.unimol.ingegneria.ing_backend.Model;

import lombok.Data;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Getter
@Setter
public class Paziente extends Persona {

    private Indirizzo indirizzo;

    private Boolean esenzione;

    private Boolean donatoreOrgani;

    private Diagnosi diagnosi;

    private Boolean attivo;

    // Relazione con medico
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JsonIgnore
    private Medico medico;

    // Relazione con terapie
    @OneToMany(mappedBy = "paziente", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Terapia> terapie;

    // Relazione con terapie farmacologiche
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
