package it.unimol.ingegneria.ing_backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Esame {

    @Id //jakarta.persistence id non spring
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codice;
    private String nome;

    // Relazione con terapia farmacologica
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Tfarmacologica> tfarmacologiche;

}
