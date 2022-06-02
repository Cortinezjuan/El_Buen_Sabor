package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.Factura;
import com.app.elbuensabor.Servicio.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class FacturaControlador {
    @Autowired
    FacturaServicio facturaServicio;

    @GetMapping("/facturas")
    public List<Factura> listarFacturas(){
        return facturaServicio.listarFacturas();
    }

    @GetMapping("/factura/{id}")
    public Optional<Factura> listarFacturaPorId(@PathVariable("id") int id){
        return facturaServicio.listarFacturaPorId(id);
    }

    @PostMapping("/crearFactura")
    public Factura crearFactura(@RequestBody Factura factura){
        return facturaServicio.guardarFactura(factura);
    }

    @DeleteMapping("/borrarFactura/{id}")
    public void borrarFactura(@PathVariable("id") int id){
        facturaServicio.borrarFactura(id);
    }

    @PutMapping("/modificarFactura")
    public Factura modificarFactura(@RequestBody Factura factura){
        return facturaServicio.modificarFactura(factura);
    }
}
