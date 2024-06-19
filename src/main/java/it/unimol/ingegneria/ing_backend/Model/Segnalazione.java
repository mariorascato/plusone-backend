package it.unimol.ingegneria.ing_backend.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Segnalazione {
    @Id //jakarta.persistence id non spring
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String schermataBug;
    private String descrizione;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private Persona utente;
    private Boolean attivo;
}
