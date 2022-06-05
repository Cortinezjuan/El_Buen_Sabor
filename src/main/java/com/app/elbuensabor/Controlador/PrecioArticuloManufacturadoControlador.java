package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.PrecioArticuloManufacturado;
import com.app.elbuensabor.Servicio.PrecioArticuloManufacturadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class PrecioArticuloManufacturadoControlador {
    @Autowired
    PrecioArticuloManufacturadoServicio precioArticuloManufacturadoServicio;

    @GetMapping("/listarPrecioArticuloManufacturados")
    public List<PrecioArticuloManufacturado> listarPrecioArticuloManufacturados(){
        return precioArticuloManufacturadoServicio.listarPrecioArticuloManufacturados();
    }

    @GetMapping("/listarPrecioArticuloManufacturadoXId/{id}")
    public Optional<PrecioArticuloManufacturado> listarPrecioArticuloManufacturadoPorId(@PathVariable("id") int id){
        return precioArticuloManufacturadoServicio.listarPrecioArticuloManufacturadoPorId(id);
    }

    @PostMapping("/crearPrecioArticuloManufacturado")
    public PrecioArticuloManufacturado crearPrecioArticuloManufacturado(@RequestBody PrecioArticuloManufacturado precioArticuloManufacturado){
        return precioArticuloManufacturadoServicio.guardarPrecioArticuloManufacturado(precioArticuloManufacturado);
    }

    @PutMapping("/modificarPrecioArticuloManufacturado")
    public PrecioArticuloManufacturado modificarPrecioArticuloManufacturado(@RequestBody PrecioArticuloManufacturado precioArticuloManufacturado){
        return precioArticuloManufacturadoServicio.modificarPrecioArticuloManufacturado(precioArticuloManufacturado);
    }
}





