package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.Pago;
import com.app.elbuensabor.Servicio.PagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class PagoControlador {
    @Autowired
    PagoServicio pagoServicio;

    @GetMapping("/listarPagos")
    public List<Pago> listarPagos(){
        return pagoServicio.listarPagos();
    }

    @GetMapping("/listarPagoXId/{id}")
    public Optional<Pago> listarPagoPorId(@PathVariable("id") int id){
        return pagoServicio.listarPagoPorId(id);
    }

    @PostMapping("/crearPago")
    public Pago crearPago(@RequestBody Pago pago){
        return pagoServicio.guardarPago(pago);
    }

    @PutMapping("/modificarPago")
    public Pago modificarPago(@RequestBody Pago pago){
        return pagoServicio.modificarPago(pago);
    }
}
