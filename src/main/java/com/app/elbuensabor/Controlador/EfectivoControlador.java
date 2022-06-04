package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.Efectivo;
import com.app.elbuensabor.Servicio.EfectivoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class EfectivoControlador {
    @Autowired
    EfectivoServicio efectivoServicio;

    @GetMapping("/listarEfectivo")
    public List<Efectivo> listarEfectivo(){
        return efectivoServicio.listarEfectivo();
    }

    @GetMapping("/listarEfectivoXId/{id}")
    public Optional<Efectivo> listarEfectivoPorId(@PathVariable("id") int id){
        return efectivoServicio.listarEfectivoPorId(id);
    }

    @PostMapping("/crearEfectivo")
    public Efectivo crearEfectivo(@RequestBody Efectivo efectivo){
        return efectivoServicio.guardarEfectivo(efectivo);
    }

    @PutMapping("/modificarEfectivo")
    public Efectivo modificarEfectivo(@RequestBody Efectivo efectivo){
        return efectivoServicio.modificarEfectivo(efectivo);
    }
}
