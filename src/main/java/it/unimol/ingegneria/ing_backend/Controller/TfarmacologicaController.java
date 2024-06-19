package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.*;
import it.unimol.ingegneria.ing_backend.Model.Farmaco;
import it.unimol.ingegneria.ing_backend.Model.Medico;
import it.unimol.ingegneria.ing_backend.Model.Paziente;
import it.unimol.ingegneria.ing_backend.Model.Tfarmacologica;
import it.unimol.ingegneria.ing_backend.Service.TfarmacologicaService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/medici")
@CrossOrigin(origins = "*")
public class TfarmacologicaController {

    private final TfarmacologicaService tfarmacologicaService;

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // Aggiungi una terapia farmacologica
    @PostMapping("addTfarmacologica/{id_medico}/{id_paziente}")
    public ResponseEntity<Tfarmacologica> addTfarmacologica(@PathVariable Long id_medico,@PathVariable Long id_paziente){
        return tfarmacologicaService.addTfarmacologica(id_medico,id_paziente);
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

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // RELAZIONE CON FARMACO

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
    @GetMapping("getMedicoByTfarmacologica/{id}")
    public ResponseEntity<Medico> getMedicoByTfarmacologica(@PathVariable Long id){
        return tfarmacologicaService.getMedicoByTFarmacologica(id);
    }
    @GetMapping("getPazienteByTfarmacologica/{id}")
    public ResponseEntity<Paziente> getPazienteByTfarmacologica(@PathVariable Long id){
        return tfarmacologicaService.getPazienteByTFarmacologica(id);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // RELAZIONE CON ESAME

    // Aggiungi un esame a terapia farmacologica
    @PutMapping("addEsameToTfarmacologica/{id_esame}/{id_tfarmacologica}")
    public ResponseEntity<Tfarmacologica> addEsameToTfarmacologica(@PathVariable Long id_esame,@PathVariable Long id_tfarmacologica) {
        return tfarmacologicaService.addEsameToTfarmacologica(id_esame, id_tfarmacologica);
    }

    // Stampa tutti gli esami di una terapia farmacologica
    @GetMapping("getAllEsamiOfTfarmacologica/{id_tfarmacologica}")
    public ResponseEntity<List<Esame>> getAllEsamiOfTfarmacologica(@PathVariable Long id_tfarmacologica){
        return tfarmacologicaService.getAllEsamiOfTfarmacologica(id_tfarmacologica);
    }

    // Rimuovi esame da una terapia farmacologica
    @PutMapping("removeEsameOfTfarmacologica/{id_esame}/{id_tfarmacologica}")
    public ResponseEntity<Esame> removeEsameOfTfarmacologica(@PathVariable Long id_esame, @PathVariable Long id_tfarmacologica){
        return tfarmacologicaService.removeEsameOfTfarmacologica(id_esame, id_tfarmacologica);
    }
    @GetMapping("getAllQuantitaDettaglioByTFarmacologica/{id}")
    public ResponseEntity<List<QuantitaDettaglio>> getAllQuantitaDettaglioByTFarmacologica(@PathVariable Long id){
        return tfarmacologicaService.getAllQuantitaDettaglioByTFarmacologica(id);
    }
    @PutMapping("setState/{id}/{attivo}")
    public ResponseEntity<Tfarmacologica> setState(@PathVariable Long id,@PathVariable Boolean attivo){
        return tfarmacologicaService.setState(id,attivo);
    }


}
