package it.unimol.ingegneria.ing_backend.Model;

import lombok.Data;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Data
@Entity
public class Farmaco {

    @Id //jakarta.persistence id non spring
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codice;

    private String nome;

    private String categoria;

    private String principioAttivo;

    private String azienda;

    // Relazione con paziente
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Paziente> pazienti;

    // Relazione con Terapia farmacologica
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Tfarmacologica> tfarmacologica;

}
