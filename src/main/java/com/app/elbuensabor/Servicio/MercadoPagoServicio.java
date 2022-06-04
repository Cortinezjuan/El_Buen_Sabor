package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.MercadoPago;
import com.app.elbuensabor.Repositorio.MercadoPagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercadoPagoServicio {
    @Autowired
    MercadoPagoRepositorio mercadoPagoRepositorio;

    public List<MercadoPago> listarMercadoPagos(){
        return mercadoPagoRepositorio.findAll();
    }

    public Optional<MercadoPago> listarMercadoPagoPorId(int id){
        return mercadoPagoRepositorio.findById(id);
    }

    public MercadoPago guardarMercadoPago(MercadoPago mercadoPago){
        return mercadoPagoRepositorio.save(mercadoPago);
    }

    public MercadoPago modificarMercadoPago(MercadoPago mercadoPago){
        return mercadoPagoRepositorio.save(mercadoPago);
    }
}
