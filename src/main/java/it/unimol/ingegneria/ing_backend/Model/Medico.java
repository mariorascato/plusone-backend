package it.unimol.ingegneria.ing_backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Medico extends Persona {
    private String ospedale;

    private String reparto;

    private String ruolo;

    private TipologiaMedico tipologiaMedico;

    @OneToMany(mappedBy = "medico",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Paziente> pazienti;
}
