package it.unimol.ingegneria.ing_backend.Model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Data
@Entity
public class Medico extends Persona {

    private String ospedale;

    private String reparto;

    private String ruolo;

    private TipologiaMedico tipologiaMedico;

    @OneToMany(mappedBy = "medico",fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JsonIgnore
    private List<Paziente> pazienti;

    @OneToMany(mappedBy = "medicoCurante",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Terapia> terapie;

}
