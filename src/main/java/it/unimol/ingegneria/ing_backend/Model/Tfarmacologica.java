package it.unimol.ingegneria.ing_backend.Model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
public class Tfarmacologica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relazione con esame
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Esame> esami;

    // Relazione con farmaco
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Farmaco> farmaci;

    // Relazione con medico
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JsonIgnore
    private Medico medico;

    // Relazione con paziente
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JsonIgnore
    private Paziente paziente;

    // Relazione con quantità dettaglio
    @OneToMany(mappedBy = "tfarmacologica", fetch = FetchType.LAZY)
    @JsonIgnore
    private List <QuantitaDettaglio> quantitaDettagli;

}
