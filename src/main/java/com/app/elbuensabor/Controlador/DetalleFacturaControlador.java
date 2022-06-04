package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.DetalleFactura;
import com.app.elbuensabor.Entidad.Factura;
import com.app.elbuensabor.Servicio.DetalleFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class DetalleFacturaControlador {
    @Autowired
    DetalleFacturaServicio detalleFacturaServicio;

    @GetMapping("/listarDetalleFacturas")
    public List<DetalleFactura> listarFacturas(){
        return detalleFacturaServicio.listarDetalleFactura();
    }

    @GetMapping("/listarDetalleFacturaXId/{id}")
    public Optional<DetalleFactura> listarDetalleFacturaPorId(@PathVariable("id") int id){
        return detalleFacturaServicio.listarDetalleFacturaPorId(id);
    }

    @PostMapping("/crearDetalleFactura")
    public DetalleFactura crearDetalleFactura(@RequestBody DetalleFactura detalleFactura){
        return detalleFacturaServicio.guardarDetalleFactura(detalleFactura);
    }

    @PutMapping("/modificarDetalleFactura")
    public DetalleFactura modificarDetalleFactura(@RequestBody DetalleFactura detalleFactura){
        return detalleFacturaServicio.modificarDetalleFactura(detalleFactura);
    }
}
