package it.unimol.ingegneria.ing_backend.Model;

import lombok.Data;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
public class Esame {

    private String codice;
    private String nome;

}
