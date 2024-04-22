package it.unimol.ingegneria.ing_backend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.stereotype.Indexed;

@Data
@Entity
public class Persona {
        @Id //jakarta.persistence id non spring
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;

        private String cognome;

        @UniqueElements
        @Email
        private String email;

        private String username;
        @UniqueElements
        private String password;

        private Ruolo ruolo;


}

