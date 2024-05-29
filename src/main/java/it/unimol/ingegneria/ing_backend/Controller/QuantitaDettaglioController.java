package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.QuantitaDettaglio;
import it.unimol.ingegneria.ing_backend.Service.QuantitaDettaglioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/medici")
@CrossOrigin("http://localhost:8100")
public class QuantitaDettaglioController {

    private final QuantitaDettaglioService quantitaDettaglioService;

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // Aggiungi una quantita dettaglio
    @PostMapping("addQuantitaDettaglio/{id_farmaco}/{id_tfarmacologica}")
    public ResponseEntity<QuantitaDettaglio> addQuantitaDettaglio(@RequestBody QuantitaDettaglio quantitaDettaglio, @PathVariable Long id_farmaco, @PathVariable Long id_tfarmacologica){
        return quantitaDettaglioService.addQuantitaDettaglio(quantitaDettaglio,id_farmaco,id_tfarmacologica);
    }

    // Aggiorna una quantita dettaglio
    @PutMapping("updateQuantitaDettaglio/{id}")
    public ResponseEntity<QuantitaDettaglio> updateQuantitaDettaglio(@RequestBody QuantitaDettaglio quantitaDettaglio, @PathVariable Long id){
        return quantitaDettaglioService.updateQuantitaDettaglio(quantitaDettaglio,id);
    }

    // Stampa tutte le quantita dettaglio
    @GetMapping("getAllQuantitaDettaglio")
    public ResponseEntity<List<QuantitaDettaglio>> getAll(){
        return quantitaDettaglioService.getAll();
    }

    // Elimina una quantita dettaglio
    @DeleteMapping("deleteQuantitaDettaglio/{id}")
    public ResponseEntity<QuantitaDettaglio> deleteQuantitaDettaglio(@PathVariable Long id){
        return quantitaDettaglioService.deleteQuantitaDettaglio(id);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

}
