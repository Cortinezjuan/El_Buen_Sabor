package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.RubroArticulo;
import com.app.elbuensabor.Servicio.RubroArticuloServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RubroArticuloControlador {

    @Autowired
    RubroArticuloServicio rubroArticuloServicio;

    @GetMapping("/listarRubrosArticulos")
    public List<RubroArticulo> listarRubrosArticulos() {
        return rubroArticuloServicio.listarRubrosArticulos();
    }

 /*   @GetMapping("/listarSubRubrosXId/{id}")
    public List<RubroArticulo> listarSubRubrosPorId(@PathVariable("id") int id) {
        return rubroArticuloServicio.listarSubRubrosPorId(id);
    }*/

    @GetMapping("/listarRubroArticuloXId/{id}")
    public Optional<RubroArticulo> listarRubroArticuloPorId(@PathVariable("id") int id) {
        return rubroArticuloServicio.listarRubroArticuloPorId(id);
    }

    @PostMapping("/crearRubroArticulo")
    public RubroArticulo crearRubroArticulo(@RequestBody RubroArticulo rubroArticulo) {
        return rubroArticuloServicio.guardarRubroArticulo(rubroArticulo);
    }

    @DeleteMapping("/borrarRubroArticulo/{id}")
    public void borrarRubroArticulo(@PathVariable("id") int id) {
        rubroArticuloServicio.borrarRubroArticulo(id);
    }

    @PutMapping("/modificarRubroArticulo")
    public RubroArticulo modificarRubroArticulo(@RequestBody RubroArticulo rubroArticulo) {
        return rubroArticuloServicio.modificarRubroArticulo(rubroArticulo);
    }
}
