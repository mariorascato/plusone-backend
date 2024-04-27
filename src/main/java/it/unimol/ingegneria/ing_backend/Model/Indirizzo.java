package it.unimol.ingegneria.ing_backend.Model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Indirizzo {

    private String cap;

    private String via;

    private String numeroCivico;

    private String città;

}
