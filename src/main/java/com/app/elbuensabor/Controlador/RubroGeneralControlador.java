package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Dto.RubroGeneralDto;
import com.app.elbuensabor.Entidad.RubroGeneral;
import com.app.elbuensabor.Servicio.RubroGeneralServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/rubroGeneral")
public class RubroGeneralControlador {

    @Autowired
    RubroGeneralServicio rubroGeneralServicio;

    @GetMapping("/listarRubrosGenerales")
    public List<RubroGeneralDto> listarRubrosGenerales() {
        return rubroGeneralServicio.listarRubrosGenerales();
    }

    @GetMapping("/listarRubroGeneralXId/{id}")
    public RubroGeneralDto listarRubroGeneralPorId(@PathVariable("id") int id) {
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

