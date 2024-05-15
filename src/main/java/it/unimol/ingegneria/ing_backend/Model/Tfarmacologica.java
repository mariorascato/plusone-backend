package it.unimol.ingegneria.ing_backend.Model;

import lombok.Data;
import jakarta.persistence.*;
import it.unimol.ingegneria.ing_backend.Model.Esame;
import it.unimol.ingegneria.ing_backend.Model.Farmaco;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
public class Tfarmacologica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Esame esame;

    // Relazione con farmaco
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Farmaco> farmaci;

}
