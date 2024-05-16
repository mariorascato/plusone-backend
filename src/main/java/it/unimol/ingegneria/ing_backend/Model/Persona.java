package it.unimol.ingegneria.ing_backend.Model;

import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Data
@MappedSuperclass
public class Persona {

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

}

