package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.ArticuloManufacturadoDetalle;
import com.app.elbuensabor.Servicio.ArticuloManufacturadoDetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ArticuloManufacturadoDetalleControlador {

    @Autowired
    ArticuloManufacturadoDetalleServicio amdServicio;

    @GetMapping("/listarArticulosManuDetalle")
    public List<ArticuloManufacturadoDetalle> listarArticulosManuDetalle() {
        return amdServicio.listarArticulosManuDetalle();
    }

    @GetMapping("/listarArticuloManuDetalleXId/{id}")
    public Optional<ArticuloManufacturadoDetalle> listarArticuloManuDetallePorId(@PathVariable("id") int id) {
        return amdServicio.listarArticulosManuDetallePorId(id);
    }

    @PostMapping("/crearArticuloManuDetalle")
    public ArticuloManufacturadoDetalle crearArticuloManuDetalle(@RequestBody ArticuloManufacturadoDetalle articuloManufacturadoDetalle) {
        return amdServicio.guardarArticuloManuDetalle(articuloManufacturadoDetalle);
    }

    @PutMapping("/modificarArticuloManuDetalle")
    public ArticuloManufacturadoDetalle modificarArticuloManuDetalle(@RequestBody ArticuloManufacturadoDetalle articuloManufacturadoDetalle) {
        return amdServicio.modificarArticuloManuDetalle(articuloManufacturadoDetalle);
    }
}
