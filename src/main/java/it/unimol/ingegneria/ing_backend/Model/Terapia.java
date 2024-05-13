package it.unimol.ingegneria.ing_backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Terapia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date orario;


    private String reparto;

    private Boolean attivo;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private Medico medicoCurante;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private Paziente paziente;

    private TipologiaTerapia tipologiaTerapia;

}
