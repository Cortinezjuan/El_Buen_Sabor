package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.ArticuloInsumo;
import com.app.elbuensabor.Servicio.ArticuloInsumoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ArticuloInsumoControlador {
    
    @Autowired
    ArticuloInsumoServicio articuloInsumoServicio;

    @GetMapping("/listarArticulosInsumo")
    public List<ArticuloInsumo> listarFacturas() {
        return articuloInsumoServicio.listarArticulosInsumo();
    }

    @GetMapping("/listarArticuloInsumoXId/{id}")
    public Optional<ArticuloInsumo> listarArticuloInsumoPorId(@PathVariable("id") int id) {
        return articuloInsumoServicio.listarArticuloInsumoPorId(id);
    }

    @PostMapping("/crearArticuloInsumo")
    public ArticuloInsumo crearArticuloInsumo(@RequestBody ArticuloInsumo articuloInsumo) {
        return articuloInsumoServicio.guardarArticuloInsumo(articuloInsumo);
    }

    @DeleteMapping("/borrarArticuloInsumo/{id}")
    public void borrarArticuloInsumo(@PathVariable("id") int id) {
        articuloInsumoServicio.borrarArticuloInsumo(id);
    }

    @PutMapping("/modificarArticuloInsumo")
    public ArticuloInsumo modificarArticuloInsumo(@RequestBody ArticuloInsumo articuloInsumo) {
        return articuloInsumoServicio.modificarArticuloInsumo(articuloInsumo);
    }
}
