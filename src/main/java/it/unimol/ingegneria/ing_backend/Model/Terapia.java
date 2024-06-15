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

    // Relazione con medico
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private Medico medicoCurante;

    // Relazione con paziente
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private Paziente paziente;

    private TipologiaTerapia tipologiaTerapia;

}
