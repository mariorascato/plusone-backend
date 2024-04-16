package it.unimol.ingegneria.ing_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
public class Persona {
        @Id //jakarta.persistence id non spring
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;

        private String cognome;

        @Email
        private String email;

        String username;

        String password;

        private Ruolo ruolo;


}

