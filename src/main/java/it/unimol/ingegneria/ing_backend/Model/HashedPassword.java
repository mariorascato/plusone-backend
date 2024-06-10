package it.unimol.ingegneria.ing_backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HashedPassword {
    public HashedPassword(){

    }
    private String hashedPassword;
}
