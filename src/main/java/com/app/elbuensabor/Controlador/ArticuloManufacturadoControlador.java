package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Dto.ArticuloManufacturadoDto;
import com.app.elbuensabor.Entidad.ArticuloManufacturado;
import com.app.elbuensabor.Servicio.ArticuloManufacturadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/articuloManufacturado")
public class ArticuloManufacturadoControlador {

    @Autowired
    ArticuloManufacturadoServicio articuloManufacturadoServicio;

    @GetMapping("/listarArticuloManufacturados")
    public List<ArticuloManufacturadoDto> listarArticuloManufacturados() {
        return articuloManufacturadoServicio.listarArticuloManufacturados();
    }

    @GetMapping("/listarArticuloManufacturadoXId/{id}")
    public Optional<ArticuloManufacturado> listarArticuloManufacturadoPorId(@PathVariable("id") int id) {
        return articuloManufacturadoServicio.listarArticuloManufacturadoPorId(id);
    }

    @PostMapping("/articuloManufacturado")
    public ArticuloManufacturado crearArticuloManufacturado(@RequestBody ArticuloManufacturado articuloManufacturado) {
        return articuloManufacturadoServicio.guardarArticuloManufacturado(articuloManufacturado);
    }

    @DeleteMapping("/borrarArticuloManufacturado/{id}")
    public void borrarArticuloManufacturado(@PathVariable("id") int id) {
        articuloManufacturadoServicio.borrarArticuloManufacturado(id);
    }

    @PutMapping("/modificarArticuloManufacturado")
    public ArticuloManufacturado modificarArticuloManufacturado(@RequestBody ArticuloManufacturado articuloManufacturado) {
        return articuloManufacturadoServicio.modificarArticuloManufacturado(articuloManufacturado);
    }
}
