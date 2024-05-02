package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.Farmaco;
import it.unimol.ingegneria.ing_backend.Service.FarmacoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/farmaci")
@CrossOrigin("http://localhost:8100")
public class FarmacoController {

    private final FarmacoService farmacoService;

    // Aggiungi farmaco
    @PostMapping("addFarmaco")
    public ResponseEntity<Farmaco> addFarmaco(@RequestBody Farmaco farmaco){
        return farmacoService.addFarmaco(farmaco);
    }

    // Aggiorna farmaco
    @PutMapping("updateFarmaco/{id}")
    public ResponseEntity<Farmaco> updateFarmaco(@RequestBody Farmaco farmaco,@PathVariable Long id){
        return farmacoService.updateFarmaco(farmaco, id);
    }

    // Elimina farmaco
    @DeleteMapping("deleteFarmaco/{id}")
    public ResponseEntity<Farmaco> deleteFarmaco(@PathVariable Long id){
        return farmacoService.deleteFarmaco(id);
    }

    // Stampa tutti i farmaci
    @GetMapping("getAll")
    public ResponseEntity<List<Farmaco>> getAll(){
        return farmacoService.getAll();
    }

    // Stampa farmaco da codice
    @GetMapping("getFarmacoByCodice/{codice}")
    public ResponseEntity<Farmaco> findFarmacoByCodice(@PathVariable String codice){
        return farmacoService.findFarmacoByCodice(codice);
    }

    // Stampa farmaco da nome
    @GetMapping("getFarmacoByNome/{nome}")
    public ResponseEntity<List<Farmaco>> findFarmacoByNome(@PathVariable String nome){
        return farmacoService.findFarmacoByNome(nome);
    }

    // Stampa farmaco da categoria
    @GetMapping("getFarmacoByCategoria/{categoria}")
    public ResponseEntity<List<Farmaco>> findFarmacoByCategoria(@PathVariable String categoria){
        return farmacoService.findFarmacoByCategoria(categoria);
    }

    // Stampa farmaco da principioAttivo
    @GetMapping("getFarmacoByPrincipioAttivo/{principioAttivo}")
    public ResponseEntity<List<Farmaco>> findFarmacoByPrincipioAttivo(@PathVariable String principioAttivo){
        return farmacoService.findFarmacoByPrincipioAttivo(principioAttivo);
    }

    // Stampa farmaco da azienda
    @GetMapping("getFarmacoByAzienda/{azienda}")
    public ResponseEntity<List<Farmaco>> findFarmacoByAzienda(@PathVariable String azienda){
        return farmacoService.findFarmacoByAzienda(azienda);
    }

}
