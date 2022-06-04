package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.Estado;
import com.app.elbuensabor.Entidad.Pago;
import com.app.elbuensabor.Servicio.EstadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class EstadoControlador {
    @Autowired
    EstadoServicio estadoServicio;

    @GetMapping("/listarEstados")
    public List<Estado> listarEstados(){
        return estadoServicio.listarEstados();
    }

    @GetMapping("/listarEstadoXId/{id}")
    public Optional<Estado> listarEstadoPorId(@PathVariable("id") int id){
        return estadoServicio.listarEstadoPorId(id);
    }

    @PostMapping("/crearEstado")
    public Estado crearEstado(@RequestBody Estado estado){
        return estadoServicio.guardarEstado(estado);
    }

    @PutMapping("/modificarEstado")
    public Estado modificarEstado(@RequestBody Estado estado){
        return estadoServicio.modificarEstado(estado);
    }
}
