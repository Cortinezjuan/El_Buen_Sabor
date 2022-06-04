package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.MercadoPago;
import com.app.elbuensabor.Entidad.Pago;
import com.app.elbuensabor.Servicio.MercadoPagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class MercadoPagoControlador {
    @Autowired
    MercadoPagoServicio mercadoPagoServicio;

    @GetMapping("/listarMercadoPagos")
    public List<MercadoPago> listarMercadoPagos(){
        return mercadoPagoServicio.listarMercadoPagos();
    }

    @GetMapping("/listarMercadoPagoXId/{id}")
    public Optional<MercadoPago> listarMercadoPagoPorId(@PathVariable("id") int id){
        return mercadoPagoServicio.listarMercadoPagoPorId(id);
    }

    @PostMapping("/crearMercadoPago")
    public MercadoPago crearMercadoPago(@RequestBody MercadoPago mercadoPago){
        return mercadoPagoServicio.guardarMercadoPago(mercadoPago);
    }

    @PutMapping("/modificarMercadoPago")
    public MercadoPago modificarMercadoPago(@RequestBody MercadoPago mercadoPago){
        return mercadoPagoServicio.modificarMercadoPago(mercadoPago);
    }
}




