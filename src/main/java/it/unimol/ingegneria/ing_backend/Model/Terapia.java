package it.unimol.ingegneria.ing_backend.Model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
public class Terapia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date orario;

    private String informazioniAggiuntive;

    private String causa;

    private Boolean attivo;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JsonIgnore
    private Medico medicoCurante;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JsonIgnore
    private Paziente paziente;

    private TipologiaTerapia tipologiaTerapia;

}
