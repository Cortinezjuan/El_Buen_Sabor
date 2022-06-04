package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.DetalleFactura;
import com.app.elbuensabor.Entidad.Factura;
import com.app.elbuensabor.Repositorio.DetalleFacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleFacturaServicio {
    @Autowired
    DetalleFacturaRepositorio detalleFacturaRepositorio;

    public List<DetalleFactura> listarDetalleFactura(){
        return detalleFacturaRepositorio.findAll();
    }

    public Optional<DetalleFactura> listarDetalleFacturaPorId(int id){
        return detalleFacturaRepositorio.findById(id);
    }

    public DetalleFactura guardarDetalleFactura(DetalleFactura detalleFactura){
        return detalleFacturaRepositorio.save(detalleFactura);
    }

    public DetalleFactura modificarDetalleFactura(DetalleFactura detalleFactura){
        return detalleFacturaRepositorio.save(detalleFactura);
    }
}
