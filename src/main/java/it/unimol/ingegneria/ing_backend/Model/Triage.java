package it.unimol.ingegneria.ing_backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Triage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float latitudine;
    private float longitudine;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Colore colore;

    private String descrizione;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private Paziente paziente;
    private LocalDate data;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Conferma conferma;

}
