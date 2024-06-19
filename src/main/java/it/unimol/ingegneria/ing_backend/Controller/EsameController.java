package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.Esame;
import it.unimol.ingegneria.ing_backend.Model.Farmaco;
import it.unimol.ingegneria.ing_backend.Service.EsameService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/esami")
@CrossOrigin(origins = {"http://localhost:8100", "https://3.75.158.163:5432"})
public class EsameController {

    private final EsameService esameService;

    // Aggiungi esame
    @PostMapping("addEsame")
    public ResponseEntity<Esame> addEsame(@RequestBody Esame esame){
        return esameService.addEsame(esame);
    }
    @PostMapping("addEsami")
    public ResponseEntity<List<Esame>> addEsami(@RequestBody List<Esame> esami){
        return esameService.addEsami(esami);
    }

    // Aggiorna esame
    @PutMapping("updateEsame/{id}")
    public ResponseEntity<Esame> updateEsame(@RequestBody Esame esame,@PathVariable Long id){
        return esameService.updateEsame(esame, id);
    }

    // Elimina esame
    @DeleteMapping("deleteEsame/{id}")
    public ResponseEntity<Esame> deleteEsame(@PathVariable Long id){
        return esameService.deleteEsame(id);
    }

    // Stampa tutti gli esami
    @GetMapping("getAll")
    public ResponseEntity<List<Esame>> getAll(){
        return esameService.getAll();
    }

}
