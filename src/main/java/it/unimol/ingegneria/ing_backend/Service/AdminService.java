package it.unimol.ingegneria.ing_backend.Service;

import it.unimol.ingegneria.ing_backend.Model.Admin;
import it.unimol.ingegneria.ing_backend.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private AdminRepository adminRepository;
   /* @Autowired
    private PasswordEncoder passwordEncoder;

    */

    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    public Admin save(Admin admin) {
        // Codifica la password prima di salvarla nel database
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);

    }

     

}