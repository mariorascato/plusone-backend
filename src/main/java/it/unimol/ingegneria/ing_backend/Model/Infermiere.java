package it.unimol.ingegneria.ing_backend.Model;

import jakarta.persistence.OneToMany;
import lombok.Data;
import jakarta.persistence.Entity;

import java.util.List;

@Data
@Entity
public class Infermiere extends Persona{

    private String ospedale;

    private String reparto;

    private String ruolo;


}
