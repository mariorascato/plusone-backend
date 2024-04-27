package it.unimol.ingegneria.ing_backend.Model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Infermiere extends Persona{

    private String ospedale;

    private String reparto;

    private String ruolo;

}
