package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.RubroGeneral;
import com.app.elbuensabor.Servicio.RubroGeneralServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RubroGeneralControlador {

    @Autowired
    RubroGeneralServicio rubroGeneralServicio;

    @GetMapping("/listarRubroGenerales")
    public List<RubroGeneral> listarRubroGenerales() {
        return rubroGeneralServicio.listarRubroGenerales();
    }

    @GetMapping("/listarRubroGeneralXId/{id}")
    public Optional<RubroGeneral> listarRubroGeneralPorId(@PathVariable("id") int id) {
        return rubroGeneralServicio.listarRubroGeneralPorId(id);
    }

    @PostMapping("/crearRubroGeneral")
    public RubroGeneral crearRubroGeneral(@RequestBody RubroGeneral rubroGeneral) {
        return rubroGeneralServicio.guardarRubroGeneral(rubroGeneral);
    }

    @DeleteMapping("/borrarRubroGeneral/{id}")
    public void borrarRubroGeneral(@PathVariable("id") int id) {
        rubroGeneralServicio.borrarRubroGeneral(id);
    }

    @PutMapping("/modificarRubroGeneral")
    public RubroGeneral modificarRubroGeneral(@RequestBody RubroGeneral rubroGeneral) {
        return rubroGeneralServicio.modificarRubroGeneral(rubroGeneral);
    }
}

