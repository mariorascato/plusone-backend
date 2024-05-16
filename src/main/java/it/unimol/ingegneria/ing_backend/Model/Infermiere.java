package it.unimol.ingegneria.ing_backend.Model;

import lombok.Data;
import jakarta.persistence.Entity;

@Data
@Entity
public class Infermiere extends Persona{

    private String ospedale;

    private String reparto;

    private String ruolo;

}
