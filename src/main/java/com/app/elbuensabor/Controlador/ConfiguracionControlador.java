package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.Configuracion;
import com.app.elbuensabor.Servicio.ConfiguracionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class ConfiguracionControlador {
    @Autowired
    ConfiguracionServicio configuracionServicio;

    @GetMapping("/listarConfiguraciones")
    public List<Configuracion> listarConfiguraciones(){
        return configuracionServicio.listarConfiguraciones();
    }

    @GetMapping("/listarConfiguracionXId/{id}")
    public Optional<Configuracion> listarConfiguracionPorId(@PathVariable("id") int id){
        return configuracionServicio.listarConfiguracionPorId(id);
    }

    @PostMapping("/crearConfiguracion")
    public Configuracion crearConfiguracion(@RequestBody Configuracion configuracion){
        return configuracionServicio.guardarConfiguracion(configuracion);
    }

    @PutMapping("/modificarConfiguracion")
    public Configuracion modificarConfiguracion(@RequestBody Configuracion configuracion){
        return configuracionServicio.modificarConfiguracion(configuracion);
    }
}





