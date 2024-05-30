package it.unimol.ingegneria.ing_backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  abstract class Persona {

        @Id //jakarta.persistence id non spring
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;

        private String cognome;

        @Column(unique = true)
        private String CF;

        @Column(unique = true)
        @Email
        private String email;

        private String password;

        @OneToMany(mappedBy = "utente",fetch = FetchType.LAZY)
        @JsonIgnore
        private List<Segnalazione> segnalazioni;


}
