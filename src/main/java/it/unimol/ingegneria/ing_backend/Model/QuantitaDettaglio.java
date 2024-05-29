package it.unimol.ingegneria.ing_backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class QuantitaDettaglio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantita;

    private String note;

    // Relazione con farmaco
    @ManyToOne(fetch = FetchType.LAZY) // cascade = CascadeType.MERGE, fetch = FetchType.EAGER
    @JsonIgnore
    private Farmaco farmaco;

    // Relazione con terapia farmacologica
    @ManyToOne(fetch = FetchType.LAZY) // cascade = CascadeType.MERGE, fetch = FetchType.EAGER
    @JsonIgnore
    private Tfarmacologica tfarmacologica;

}
