package it.unimol.ingegneria.ing_backend.Controller;

import it.unimol.ingegneria.ing_backend.Model.Medico;
import it.unimol.ingegneria.ing_backend.Model.Paziente;
import it.unimol.ingegneria.ing_backend.Model.Terapia;
import it.unimol.ingegneria.ing_backend.Model.TipologiaTerapia;
import it.unimol.ingegneria.ing_backend.Service.TerapiaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/terapie")
@CrossOrigin("http://localhost:8100")
public class TerapiaController {

    private final TerapiaService terapiaService;

    @PostMapping("addTerapia/{id_medico}/{id_paziente}")
    public ResponseEntity<Terapia> addTerapia(@RequestBody Terapia terapia,@PathVariable Long id_medico,@PathVariable Long id_paziente){
        return terapiaService.addTerapia(terapia,id_medico,id_paziente);
    }
    @GetMapping("getAll")
    public ResponseEntity<List<Terapia>> getAll(){
        return terapiaService.getAllTerapie();
    }
    @GetMapping("getMedicoByTerapia/{id}")
    public ResponseEntity<Medico> getMedicoByTerapia(@PathVariable Long id){
        return terapiaService.getMedicoByTerapia(id);
    }
    @GetMapping("getPazienteByTerapia/{id}")
    public ResponseEntity<Paziente> getPazienteByTerapia(@PathVariable Long id){
        return terapiaService.getPazienteByTerapia(id);
    }
    @GetMapping("getTerapieByTipologiaTerapia/{tipologia}")
    public ResponseEntity<List<Terapia>> getTerapieByTipologiaTerapia(@PathVariable TipologiaTerapia tipologia){
        return terapiaService.getTerapieByTipologia(tipologia);
    }
}
