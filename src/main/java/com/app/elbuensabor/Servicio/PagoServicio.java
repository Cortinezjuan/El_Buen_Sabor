package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.Pago;
import com.app.elbuensabor.Repositorio.PagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServicio {
    @Autowired
    PagoRepositorio pagoRepositorio;

    public List<Pago> listarPagos(){
        return pagoRepositorio.findAll();
    }

    public Optional<Pago> listarPagoPorId(int id){
        return pagoRepositorio.findById(id);
    }

    public Pago guardarPago(Pago pago){
        return pagoRepositorio.save(pago);
    }

    public Pago modificarPago(Pago pago){
        return pagoRepositorio.save(pago);
    }
}
