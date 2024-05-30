package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.Admin;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/admin")
@CrossOrigin("http://localhost:8100")
public class AdminController {
    @GetMapping("getAdmin")
    public ResponseEntity<Admin> getAdmin(){
        return ResponseEntity.status(HttpStatus.OK).body(Admin.getAdmin());
    }
}
