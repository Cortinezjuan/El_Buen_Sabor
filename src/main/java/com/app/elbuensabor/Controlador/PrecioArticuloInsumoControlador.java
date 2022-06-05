package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.PrecioArticuloInsumo;
import com.app.elbuensabor.Servicio.PrecioArticuloInsumoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PrecioArticuloInsumoControlador {

    @Autowired
    PrecioArticuloInsumoServicio precioArticuloInsumoServicio;

    @GetMapping("/listarPreciosArtInsumo")
    public List<PrecioArticuloInsumo> listarPreciosArtInsumo() {
        return precioArticuloInsumoServicio.listarPreciosArtInsumo();
    }

    @GetMapping("/listarPrecioArtInsumoXId/{id}")
    public Optional<PrecioArticuloInsumo> listarPrecioArtInsumoPorId(@PathVariable("id") int id) {
        return precioArticuloInsumoServicio.listarPrecioArtInsumoPorId(id);
    }

    @PostMapping("/crearPrecioArtInsumo")
    public PrecioArticuloInsumo crearPrecioArtInsumo(@RequestBody PrecioArticuloInsumo precioArticuloInsumo) {
        return precioArticuloInsumoServicio.guardarPrecioArtInsumo(precioArticuloInsumo);
    }

    @PutMapping("/modificarPrecioArtInsumo")
    public PrecioArticuloInsumo modificarPrecioArtInsumo(@RequestBody PrecioArticuloInsumo precioArticuloInsumo) {
        return precioArticuloInsumoServicio.modificarPrecioArtInsumo(precioArticuloInsumo);
    }
}
