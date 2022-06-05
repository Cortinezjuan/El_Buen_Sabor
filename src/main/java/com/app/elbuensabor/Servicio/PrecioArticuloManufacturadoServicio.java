package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.PrecioArticuloManufacturado;
import com.app.elbuensabor.Repositorio.PrecioArticuloManufacturadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrecioArticuloManufacturadoServicio {
    @Autowired
    PrecioArticuloManufacturadoRepositorio precioArticuloManufacturadoRepositorio;

    public List<PrecioArticuloManufacturado> listarPrecioArticuloManufacturados() {
        return precioArticuloManufacturadoRepositorio.findAll();
    }

    public Optional<PrecioArticuloManufacturado> listarPrecioArticuloManufacturadoPorId(int id) {
        return precioArticuloManufacturadoRepositorio.findById(id);
    }

    public PrecioArticuloManufacturado guardarPrecioArticuloManufacturado(PrecioArticuloManufacturado precioArticuloManufacturado) {
        return precioArticuloManufacturadoRepositorio.save(precioArticuloManufacturado);
    }

    public PrecioArticuloManufacturado modificarPrecioArticuloManufacturado(PrecioArticuloManufacturado precioArticuloManufacturado) {
        return precioArticuloManufacturadoRepositorio.save(precioArticuloManufacturado);
    }
}
