package it.unimol.ingegneria.ing_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

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

}
