package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.Domicilio;
import com.app.elbuensabor.Servicio.DomicilioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class DomicilioControlador {
    @Autowired
    DomicilioServicio domicilioServicio;

    @GetMapping("/listarDomicilios")
    public List<Domicilio> listarDomicilios(){
        return domicilioServicio.listarDomicilios();
    }

    @GetMapping("/listarDomicilioXId/{id}")
    public Optional<Domicilio> listarDomicilioPorId(@PathVariable("id") int id){
        return domicilioServicio.listarDomicilioPorId(id);
    }

    @PostMapping("/crearDomicilio")
    public Domicilio crearDomicilio(@RequestBody Domicilio domicilio){
        return domicilioServicio.guardarDomicilio(domicilio);
    }

    @DeleteMapping("/borrarDomicilio/{id}")
    public void borrarDomicilio(@PathVariable("id") int id){
        domicilioServicio.borrarDomicilio(id);
    }

    @PutMapping("/modificarDomicilio")
    public Domicilio modificarDomicilio(@RequestBody Domicilio domicilio){
        return domicilioServicio.modificarDomicilio(domicilio);
    }
}

