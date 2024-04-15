package it.unimol.ingegneria.ing_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@Entity
public class Admin {
        @Id //jakarta.persistence id non spring
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;

        @NotEmpty @NotBlank
        private String nome;
        @NotEmpty @NotBlank
        private String cognome;
        @NotEmpty @NotBlank @UniqueElements
        @Email private String email;
        @NotEmpty @NotBlank
        @Length(min = 3, max = 30) String username;
        @NotEmpty @NotBlank
        @Length(min = 8, max = 30) String password;

        @NotEmpty @NotBlank
        private String ruolo;

}

