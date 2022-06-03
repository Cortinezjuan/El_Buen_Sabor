package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.Factura;
import com.app.elbuensabor.Repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServicio {
    @Autowired
    FacturaRepositorio facturaRepositorio;

    public List<Factura> listarFacturas(){
        return facturaRepositorio.listarFacturas();
    }

    public Optional<Factura> listarFacturaPorId(int id){
        return facturaRepositorio.findById(id);
    }

    public Factura guardarFactura(Factura factura){
        return facturaRepositorio.save(factura);
    }

    public void borrarFactura(int id){
        Optional<Factura> factura = facturaRepositorio.findById(id);
        factura.get().setBajaFactura(true);
        facturaRepositorio.save(factura.get());

    }

    public Factura modificarFactura(Factura factura){
        return facturaRepositorio.save(factura);
    }
}
