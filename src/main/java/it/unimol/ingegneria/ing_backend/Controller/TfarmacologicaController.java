package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.Farmaco;
import it.unimol.ingegneria.ing_backend.Model.Tfarmacologica;
import it.unimol.ingegneria.ing_backend.Service.TfarmacologicaService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/medici")
@CrossOrigin("http://localhost:8100")
public class TfarmacologicaController {

    private final TfarmacologicaService tfarmacologicaService;

    // Aggiungi una terapia farmacologica
    @PostMapping("addTfarmacologica")
    public ResponseEntity<Tfarmacologica> addTfarmacologica(@RequestBody Tfarmacologica tfarmacologica){
        return tfarmacologicaService.addTfarmacologica(tfarmacologica);
    }

    // Aggiorna terapia farmacologica
    @PutMapping("updateTfarmacologica/{id}")
    public ResponseEntity<Tfarmacologica> updateTfarmacologica(@RequestBody Tfarmacologica tfarmacologica, @PathVariable Long id){
        return tfarmacologicaService.updateTfarmacologica(tfarmacologica,id);
    }

    // Stampa tutte le terapie farmacologiche
    @GetMapping("getAllTfarmacologiche")
    public ResponseEntity<List<Tfarmacologica>> getAll(){
        return tfarmacologicaService.getAll();
    }

    // Elimina terapia farmacologica
    @DeleteMapping("deleteTfarmacologica/{id}")
    public ResponseEntity<Tfarmacologica> deleteTfarmacologica(@PathVariable Long id){
        return tfarmacologicaService.deleteTfarmacologica(id);
    }

    // Aggiungi un farmaco a terapia farmacologica
    @PutMapping("addFarmacoToTfarmacologica/{id_farmaco}/{id_tfarmacologica}")
    public ResponseEntity<Tfarmacologica> addFarmacoToTfarmacologica(@PathVariable Long id_farmaco,@PathVariable Long id_tfarmacologica) {
        return tfarmacologicaService.addFarmacoToTfarmacologica(id_farmaco, id_tfarmacologica);
    }

    // Stampa tutti i farmaci di una terapia farmacologica
    @GetMapping("getAllFarmaciOfTfarmacologica/{id_tfarmacologica}")
    public ResponseEntity<List<Farmaco>> getAllFarmaciOfTfarmacologica(@PathVariable Long id_tfarmacologica){
        return tfarmacologicaService.getAllFarmaciOfTfarmacologica(id_tfarmacologica);
    }

    // Rimuovi farmaco da una terapia farmacologica
    @PutMapping("removeFarmacoOfTfarmacologica/{id_farmaco}/{id_tfarmacologica}")
    public ResponseEntity<Farmaco> removeFarmacoOfTfarmacologica(@PathVariable Long id_farmaco, @PathVariable Long id_tfarmacologica){
        return tfarmacologicaService.removeFarmacoOfTfarmacologica(id_farmaco, id_tfarmacologica);
    }

}
