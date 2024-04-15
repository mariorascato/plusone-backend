package it.unimol.ingegneria.ing_backend.Controller;
import it.unimol.ingegneria.ing_backend.Model.Admin;
import it.unimol.ingegneria.ing_backend.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/{username}")
    public ResponseEntity<Admin> getByUsername(@PathVariable String username) {
        Admin admin = adminService.findByUsername(username);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Admin> createUser(@RequestBody Admin admin) {
        Admin existingAdmin = adminService.findByUsername(admin.getUsername());
        if (existingAdmin != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Admin savedAdmin = adminService.save(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdmin);
    }
}



