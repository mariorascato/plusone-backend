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
        private Long id;

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


        // Altri campi e metodi

        // Costruttore vuoto richiesto da JPA
        public Admin() {
        }

        // Costruttore con username e password
        public Admin(String username, String password) {
                this.username = username;
                this.password = password;
        }

        // Metodi getter e setter per gli attributi
        public Long getId() {
                return id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

}

