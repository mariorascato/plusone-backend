package it.unimol.ingegneria.ing_backend.Model;

import lombok.Data;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
public class Indirizzo {

    private String cap;

    private String via;

    private String numeroCivico;

    private String città;

}
